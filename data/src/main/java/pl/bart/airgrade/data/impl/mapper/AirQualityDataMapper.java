package pl.bart.airgrade.data.impl.mapper;

import pl.bart.airgrade.data.impl.external.aqicn.code.AqicnApiErrorCode;
import pl.bart.airgrade.data.impl.external.aqicn.response.*;
import pl.bart.airgrade.data.impl.internal.air.AirQualityData;
import pl.bart.airgrade.data.impl.internal.air.AirQualityDataLocation;
import pl.bart.airgrade.data.impl.internal.air.AirQualityDataPollutions;
import pl.bart.airgrade.data.impl.log.AqicnApiException;
import pl.bart.airgrade.data.impl.log.AqicnApiQuotaLimitExceededException;
import pl.bart.airgrade.data.impl.log.AqicnInvalidApiKeyException;
import pl.bart.airgrade.data.impl.util.SafeList;
import pl.bart.airgrade.data.impl.util.TimeUtil;

import java.time.LocalDateTime;
import java.util.Optional;

public class AirQualityDataMapper {

    public static final int LATITUDE_INDEX = 0;
    public static final int LONGITUDE_INDEX = 1;

    public static AirQualityData map(AqicnApiResponse aqicnResponse) {
        if (aqicnResponse instanceof AqicnApiSuccessResponse) {

            AqicnApiSuccessResponse successResponse = (AqicnApiSuccessResponse) aqicnResponse;

            final Optional<AqicnApiResponseData> aiqcnData = successResponse.getOptionalData();

            final Optional<String> iso = aiqcnData.flatMap(AqicnApiResponseData::getOptionalTime).flatMap(AqicnApiResponseTime::getOptionalIsoString);
            final LocalDateTime utc = iso.map(TimeUtil::convertZonedIsoStringToUtc).orElse(null);

            final SafeList<Double> coordinates = aiqcnData
                    .flatMap(AqicnApiResponseData::getOptionalCity)
                    .flatMap(AqicnApiResponseCity::getOptionalGeo)
                    .orElse(null);

            final String description = aiqcnData
                    .flatMap(AqicnApiResponseData::getOptionalCity)
                    .flatMap(AqicnApiResponseCity::getOptionalName)
                    .orElse(null);

            final AirQualityDataLocation location = AirQualityDataLocation.builder()
                    .longitude(coordinates.getOrNull(LONGITUDE_INDEX))
                    .latitude(coordinates.getOrNull(LATITUDE_INDEX))
                    .description(description)
                    .build();

            final Double pm10 = aiqcnData
                    .flatMap(AqicnApiResponseData::getOptionalIaqi)
                    .flatMap(AqicnApiResponseIaqi::getOptionalPm10)
                    .flatMap(AqicnApiResponseIaqiElement::getOptionalValue)
                    .orElse(null);

            final Double pm25 = aiqcnData
                    .flatMap(AqicnApiResponseData::getOptionalIaqi)
                    .flatMap(AqicnApiResponseIaqi::getOptionalPm25)
                    .flatMap(AqicnApiResponseIaqiElement::getOptionalValue)
                    .orElse(null);

            final Double no2 = aiqcnData
                    .flatMap(AqicnApiResponseData::getOptionalIaqi)
                    .flatMap(AqicnApiResponseIaqi::getOptionalNo2)
                    .flatMap(AqicnApiResponseIaqiElement::getOptionalValue)
                    .orElse(null);

            final AirQualityDataPollutions pollutions = AirQualityDataPollutions.builder()
                    .pm10(pm10)
                    .pm25(pm25)
                    .no2(no2)
                    .build();

            return AirQualityData.builder()
                    .utc(utc)
                    .location(location)
                    .pollutions(pollutions)
                    .build();
        } else {
            AqicnApiErrorResponse errorResponse = (AqicnApiErrorResponse) aqicnResponse;
            if (errorResponse.getData().equals(AqicnApiErrorCode.INVALID_KEY)) {
                throw new AqicnInvalidApiKeyException(AqicnApiErrorCode.INVALID_KEY);
            } else if (errorResponse.getData().equals(AqicnApiErrorCode.OVER_QUOTA)) {
                throw new AqicnApiQuotaLimitExceededException(AqicnApiErrorCode.OVER_QUOTA);
            } else {
                throw new AqicnApiException();
            }
        }
    }
}
