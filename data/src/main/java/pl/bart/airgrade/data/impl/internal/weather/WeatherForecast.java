package pl.bart.airgrade.data.impl.internal.weather;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class WeatherForecast {
    private List<WeatherForecastRecord> records;
    private WeatherForecastMetadata metadata;
}
