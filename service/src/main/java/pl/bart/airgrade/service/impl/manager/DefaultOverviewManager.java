package pl.bart.airgrade.service.impl.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.bart.airgrade.data.api.service.AirQualityService;
import pl.bart.airgrade.data.api.service.WeatherForecastService;
import pl.bart.airgrade.data.impl.internal.air.AirQualityData;
import pl.bart.airgrade.data.impl.internal.weather.WeatherNow;
import pl.bart.airgrade.service.api.manager.OverviewManager;
import pl.bart.airgrade.service.impl.response.overview.OverviewMapper;
import pl.bart.airgrade.service.impl.response.overview.OverviewResponse;

@Service
public class DefaultOverviewManager implements OverviewManager {

    @Autowired
    private AirQualityService airQualityService;

    @Autowired
    private WeatherForecastService weatherForecastService;

    @Override
    public ResponseEntity<OverviewResponse> getOverviewByCoordinates(double latitude, double longitude) {
        final AirQualityData airQualityData = airQualityService.getByCoordinates(latitude, longitude);
        final WeatherNow weather = weatherForecastService.getByCoordinatesNow(latitude, longitude);
        final OverviewResponse response = OverviewMapper.map(airQualityData, weather);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
