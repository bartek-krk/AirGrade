package pl.bart.airgrade.service.impl.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.bart.airgrade.data.api.service.AirQualityService;
import pl.bart.airgrade.data.impl.internal.AirQualityData;
import pl.bart.airgrade.service.api.manager.AirQualityDataManager;

@Component
public class DefaultAirQualityDataManager implements AirQualityDataManager {

    @Autowired
    private AirQualityService airQualityService;

    public ResponseEntity<AirQualityData> getByCoordinates(double latitude, double longitude) {
        final AirQualityData response = airQualityService.getByCoordinates(latitude, longitude);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
