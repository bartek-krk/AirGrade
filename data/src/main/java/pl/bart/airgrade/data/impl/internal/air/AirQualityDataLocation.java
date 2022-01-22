package pl.bart.airgrade.data.impl.internal.air;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AirQualityDataLocation {
    private Double latitude;
    private Double longitude;
    private String description;
}
