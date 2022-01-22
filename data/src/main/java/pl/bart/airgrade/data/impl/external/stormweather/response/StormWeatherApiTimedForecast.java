package pl.bart.airgrade.data.impl.external.stormweather.response;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class StormWeatherApiTimedForecast {
    private List<StormWeatherApiMeasurement> airTemperature;
    private List<StormWeatherApiMeasurement> cloudCover;
    private List<StormWeatherApiMeasurement> humidity;
    private List<StormWeatherApiMeasurement> pressure;
    private List<StormWeatherApiMeasurement> windDirection;
    private List<StormWeatherApiMeasurement> windSpeed;
    private List<StormWeatherApiMeasurement> precipitation;
    private ZonedDateTime time;

    public Optional<List<StormWeatherApiMeasurement>> getOptionalAirTemperature() {
        return Optional.ofNullable(this.airTemperature);
    }

    public Optional<List<StormWeatherApiMeasurement>> getOptionalCloudCover() {
        return Optional.ofNullable(this.cloudCover);
    }

    public Optional<List<StormWeatherApiMeasurement>> getOptionalHumidity() {
        return Optional.ofNullable(this.humidity);
    }

    public Optional<List<StormWeatherApiMeasurement>> getOptionalPressure() {
        return Optional.ofNullable(this.pressure);
    }

    public Optional<List<StormWeatherApiMeasurement>> getOptionalWindDirection() {
        return Optional.ofNullable(this.windDirection);
    }

    public Optional<List<StormWeatherApiMeasurement>> getOptionalWindSpeed() {
        return Optional.ofNullable(this.windSpeed);
    }

    public Optional<List<StormWeatherApiMeasurement>> getOptionalPrecipitation() {
        return Optional.ofNullable(this.precipitation);
    }

    public Optional<ZonedDateTime> getOptionalTime() {
        return Optional.ofNullable(this.time);
    }
}
