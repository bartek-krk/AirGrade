package pl.bart.airgrade.data.impl.internal.air;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AirQualityData {
    private LocalDateTime utc;
    private AirQualityDataLocation location;
    private AirQualityDataPollutions pollutions;
}
