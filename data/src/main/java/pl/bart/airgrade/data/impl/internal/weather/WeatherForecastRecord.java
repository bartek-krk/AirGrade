package pl.bart.airgrade.data.impl.internal.weather;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class WeatherForecastRecord {
    private LocalDateTime utc;
    private Double airTemperature;
    private Double cloudCover;
    private Double humidity;
    private Double pressure;
    private Double precipitation;
    private Double windDirectionDegrees;
    private String windDirection;
    private Double windSpeed;
    private Integer beaufort;
}
