package pl.bart.airgrade.service.impl.response.overview;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PollutionsOverview {
    private Double pm10;
    private Double pm25;
    private Double no2;
    private OverviewMetadata metadata;
}
