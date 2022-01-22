package pl.bart.airgrade.data.impl.external.stormweather.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class StormWeatherApiMeasurement {
    private String source;
    private Double value;

    public Optional<String> getOptionalSource() {
        return Optional.ofNullable(this.source);
    }

    public Optional<Double> getOptionalValue() {
        return Optional.ofNullable(this.value);
    }
}
