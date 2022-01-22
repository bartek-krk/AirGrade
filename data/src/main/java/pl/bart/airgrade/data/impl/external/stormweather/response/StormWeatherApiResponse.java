package pl.bart.airgrade.data.impl.external.stormweather.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class StormWeatherApiResponse {
    private List<StormWeatherApiTimedForecast> hours;
    private StormWeatherApiMetadata meta;

    public Optional<List<StormWeatherApiTimedForecast>> getOptionalHours() {
        return Optional.ofNullable(this.hours);
    }

    public Optional<StormWeatherApiMetadata> getOptionalMetadata() {
        return Optional.ofNullable(this.meta);
    }
}
