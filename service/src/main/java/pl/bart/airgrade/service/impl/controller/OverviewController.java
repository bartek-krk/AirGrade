package pl.bart.airgrade.service.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bart.airgrade.service.api.manager.OverviewManager;
import pl.bart.airgrade.service.impl.response.overview.OverviewResponse;

@RestController
public class OverviewController {

    @Autowired
    private OverviewManager overviewManager;

    @GetMapping(RestUri.OVERVIEW)
    public ResponseEntity<OverviewResponse> getOverview(@RequestParam(name = "lat") double latitude, @RequestParam(name = "lon") double longitude) {
        return overviewManager.getOverviewByCoordinates(latitude, longitude);
    }
}
