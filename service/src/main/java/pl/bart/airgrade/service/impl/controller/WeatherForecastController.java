package pl.bart.airgrade.service.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;
import pl.bart.airgrade.data.impl.internal.weather.WeatherNow;
import pl.bart.airgrade.service.api.manager.WeatherForecastManager;

@RestController
public class WeatherForecastController {

    @Autowired
    private WeatherForecastManager weatherForecastManager;

    @GetMapping(RestUri.WEATHER_FORECAST)
    public ResponseEntity<WeatherForecast> get(
            @RequestParam(name = "lat") double latitude,
            @RequestParam(name = "lon") double longitude,
            @RequestParam(name = "limit", required = false, defaultValue = "20") long limit) {
        return weatherForecastManager.getByCoordinates(latitude, longitude, limit);
    }

    @GetMapping(RestUri.WEATHER_NOW)
    public ResponseEntity<WeatherNow> getNow(@RequestParam(name = "lat") double latitude, @RequestParam(name = "lon") double longitude) {
        return weatherForecastManager.getByCoordinatesNow(latitude, longitude);
    }
}
