package pl.bart.airgrade.data.impl.external.aqicn.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AqicnApiResponseIaqiElement {
    @JsonProperty("v")
    private Double value;

    public Optional<Double> getOptionalValue() {
        return Optional.ofNullable(this.value);
    }
}
