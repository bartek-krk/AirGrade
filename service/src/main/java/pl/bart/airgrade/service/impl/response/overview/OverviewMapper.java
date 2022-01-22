package pl.bart.airgrade.service.impl.response.overview;

import pl.bart.airgrade.data.impl.internal.air.AirQualityData;
import pl.bart.airgrade.data.impl.internal.weather.WeatherNow;
import pl.bart.airgrade.service.api.manager.OverviewManager;

import java.time.LocalDateTime;

public class OverviewMapper {
    public static OverviewResponse map(AirQualityData airQualityData, WeatherNow weather) {
        final OverviewMetadata airMetadata = OverviewMetadata.builder()
                .utc(airQualityData.getUtc())
                .latitude(airQualityData.getLocation().getLatitude())
                .longitude(airQualityData.getLocation().getLongitude())
                .description(airQualityData.getLocation().getDescription())
                .build();

        final PollutionsOverview pollutionsOverview = PollutionsOverview.builder()
                .pm10(airQualityData.getPollutions().getPm10())
                .pm25(airQualityData.getPollutions().getPm25())
                .no2(airQualityData.getPollutions().getNo2())
                .metadata(airMetadata)
                .build();

        final OverviewMetadata weatherMetadata = OverviewMetadata.builder()
                .utc(weather.getWeather().getUtc())
                .latitude(weather.getMetadata().getLatitude())
                .longitude(weather.getMetadata().getLongitude())
                .description(String.format("Location: %s,%s", weather.getMetadata().getLatitude(), weather.getMetadata().getLongitude()))
                .build();

        final WeatherOverview weatherOverview = WeatherOverview.builder()
                .airTemperature(weather.getWeather().getAirTemperature())
                .cloudCover(weather.getWeather().getCloudCover())
                .humidity(weather.getWeather().getHumidity())
                .pressure(weather.getWeather().getPressure())
                .precipitation(weather.getWeather().getPrecipitation())
                .windDirectionDegrees(weather.getWeather().getWindDirectionDegrees())
                .windDirection(weather.getWeather().getWindDirection())
                .windSpeed(weather.getWeather().getWindSpeed())
                .beaufort(weather.getWeather().getBeaufort())
                .metadata(weatherMetadata)
                .build();

        return OverviewResponse.builder()
                .pollutions(pollutionsOverview)
                .weather(weatherOverview)
                .build();
    }
}
