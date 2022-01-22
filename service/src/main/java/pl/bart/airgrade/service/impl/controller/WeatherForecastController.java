package pl.bart.airgrade.service.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;
import pl.bart.airgrade.service.api.manager.WeatherForecastManager;

@RestController
@RequestMapping(RestUri.WEATHER_FORECAST)
public class WeatherForecastController {

    @Autowired
    private WeatherForecastManager weatherForecastManager;

    @GetMapping
    public ResponseEntity<WeatherForecast> get(@RequestParam(name = "lat") double latitude, @RequestParam(name = "lon") double longitude) {
        return weatherForecastManager.getByCoordinates(latitude, longitude);
    }
}
