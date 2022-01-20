package pl.bart.airgrade.data.impl.internal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AirQualityData {
    private LocalDateTime updateTimeUtc;
    private AirQualityDataLocation location;
    private AirQualityDataPollutions pollutions;
}
