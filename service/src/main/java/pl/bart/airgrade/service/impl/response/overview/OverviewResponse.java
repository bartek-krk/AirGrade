package pl.bart.airgrade.service.impl.response.overview;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OverviewResponse {
    private WeatherOverview weather;
    private PollutionsOverview pollutions;
}
