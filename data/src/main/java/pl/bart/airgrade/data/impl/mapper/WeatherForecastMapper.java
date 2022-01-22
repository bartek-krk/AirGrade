package pl.bart.airgrade.data.impl.mapper;

import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiMeasurement;
import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiMetadata;
import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiResponse;
import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiTimedForecast;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecastMetadata;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecastRecord;
import pl.bart.airgrade.data.impl.util.WindUtil;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeatherForecastMapper {

    public static final String NOAA = "noaa";

    public static WeatherForecast map(StormWeatherApiResponse apiResponse) {

        final Optional<List<StormWeatherApiTimedForecast>> hours = apiResponse.getOptionalHours();

        List<WeatherForecastRecord> records = new ArrayList<>();

        if (hours.isPresent()) {
            for (StormWeatherApiTimedForecast record : hours.get()) {
                final Double airTemperature = getValue(record.getOptionalAirTemperature(), NOAA);
                final Double cloudCover = getValue(record.getOptionalCloudCover(), NOAA);
                final Double humidity = getValue(record.getOptionalHumidity(), NOAA);
                final Double pressure = getValue(record.getOptionalPressure(), NOAA);
                final Double precipitation = getValue(record.getOptionalPrecipitation(), NOAA);
                final Double windDirectionDegrees = getValue(record.getOptionalWindDirection(), NOAA);
                final Double windSpeed = getValue(record.getOptionalWindSpeed(), NOAA);
                final LocalDateTime utc = toUtc(record.getOptionalTime());

                records.add(
                        WeatherForecastRecord.builder()
                                .airTemperature(airTemperature)
                                .cloudCover(cloudCover)
                                .humidity(humidity)
                                .pressure(pressure)
                                .precipitation(precipitation)
                                .windDirectionDegrees(windDirectionDegrees)
                                .windDirection(WindUtil.degreesToDirection(windDirectionDegrees))
                                .windSpeed(windSpeed)
                                .beaufort(WindUtil.knotsToBeaufort(windSpeed))
                                .utc(utc)
                                .build()
                );
            }
        }

        final Double latitude = apiResponse.getOptionalMetadata().flatMap(StormWeatherApiMetadata::getOptionalLat).orElse(null);
        final Double longitude = apiResponse.getOptionalMetadata().flatMap(StormWeatherApiMetadata::getOptionalLng).orElse(null);

        final WeatherForecastMetadata metadata = WeatherForecastMetadata.builder()
                .latitude(latitude)
                .longitude(longitude)
                .source(NOAA)
                .build();

        return WeatherForecast.builder()
                .records(records)
                .metadata(metadata)
                .build();
    }

    private static Double getValue(Optional<List<StormWeatherApiMeasurement>> optional, String source) {
        if (optional.isPresent()) {
            for (StormWeatherApiMeasurement measurement : optional.get()) {
                if (measurement.getSource().equals(source)) {
                    return measurement.getValue();
                }
            }
        }
        return null;
    }

    private static LocalDateTime toUtc(Optional<ZonedDateTime> zonedTimeOptional) {
        if (zonedTimeOptional.isPresent()){
            return LocalDateTime.ofInstant(zonedTimeOptional.get().toInstant(), ZoneOffset.UTC);
        }
        return null;
    }

}
