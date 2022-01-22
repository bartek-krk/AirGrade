package pl.bart.airgrade.service.impl.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.bart.airgrade.data.api.service.WeatherForecastService;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;
import pl.bart.airgrade.service.api.manager.WeatherForecastManager;

@Component
public class DefaultWeatherForecastManager implements WeatherForecastManager {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @Override
    public ResponseEntity<WeatherForecast> getByCoordinates(double latitude, double longitude) {
        final WeatherForecast resonse = weatherForecastService.getByCoordinates(latitude, longitude);
        return new ResponseEntity<>(resonse, HttpStatus.OK);
    }
}