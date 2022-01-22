package pl.bart.airgrade.data.impl.internal.weather;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeatherNow {
    private WeatherForecastRecord weather;
    private WeatherForecastMetadata metadata;
}
