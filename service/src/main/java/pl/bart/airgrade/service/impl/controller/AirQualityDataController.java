package pl.bart.airgrade.service.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bart.airgrade.data.api.service.WeatherForecastService;
import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiResponse;
import pl.bart.airgrade.data.impl.internal.air.AirQualityData;
import pl.bart.airgrade.service.api.manager.AirQualityDataManager;

@RestController
@RequestMapping(RestUri.AIR_QUALITY_DATA)
public class AirQualityDataController {

    @Autowired
    private AirQualityDataManager airQualityDataManager;


    @GetMapping
    public ResponseEntity<AirQualityData> get(@RequestParam(name = "lat") double latitude, @RequestParam(name = "lon") double longitude) {
        return airQualityDataManager.getByCoordinates(latitude, longitude);
    }

}
