package pl.bart.airgrade.data.impl.external.stormweather.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class StormWeatherApiMetadata {
    private String start;
    private String end;
    private Double lat;
    private Double lng;
    private List<String> params;

    public Optional<String> getOptionalStart() {
        return Optional.ofNullable(this.start);
    }

    public Optional<String> getOptionalEnd() {
        return Optional.ofNullable(this.end);
    }

    public Optional<Double> getOptionalLat() {
        return Optional.ofNullable(this.lat);
    }

    public Optional<Double> getOptionalLng() {
        return Optional.ofNullable(this.lng);
    }

    public Optional<List<String>> getOptionalParams() {
        return Optional.ofNullable(this.params);
    }
}
