package pl.bart.airgrade.service.api.manager;

import org.springframework.http.ResponseEntity;
import pl.bart.airgrade.data.impl.internal.air.AirQualityData;

public interface AirQualityDataManager {
    ResponseEntity<AirQualityData> getByCoordinates(double latitude, double longitude);
}
