package pl.bart.airgrade.service.impl.response.overview;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherOverview {
    private Double airTemperature;
    private Double cloudCover;
    private Double humidity;
    private Double pressure;
    private Double precipitation;
    private Double windDirectionDegrees;
    private String windDirection;
    private Double windSpeed;
    private Integer beaufort;
    private OverviewMetadata metadata;
}
