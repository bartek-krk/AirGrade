package pl.bart.airgrade.data.impl.internal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AirQualityDataPollutions {
    private Double pm10;
    private Double pm25;
    private Double no2;
}
