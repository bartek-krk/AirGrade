package pl.bart.airgrade.service.api.manager;

import org.springframework.http.ResponseEntity;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;
import pl.bart.airgrade.data.impl.internal.weather.WeatherNow;

public interface WeatherForecastManager {
    ResponseEntity<WeatherForecast> getByCoordinates(double latitude, double longitude);
    ResponseEntity<WeatherNow> getByCoordinatesNow(double latitude, double longitude);
}
