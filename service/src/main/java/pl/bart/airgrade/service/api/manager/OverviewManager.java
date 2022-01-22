package pl.bart.airgrade.service.api.manager;

import org.springframework.http.ResponseEntity;
import pl.bart.airgrade.service.impl.response.overview.OverviewResponse;

public interface OverviewManager {
    ResponseEntity<OverviewResponse> getOverviewByCoordinates(double latitude, double longitude);
}
