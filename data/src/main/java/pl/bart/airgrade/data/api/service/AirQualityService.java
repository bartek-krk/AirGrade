package pl.bart.airgrade.data.api.service;

import pl.bart.airgrade.data.impl.internal.AirQualityData;

public interface AirQualityService {
    AirQualityData getByCoordinates(double latitude, double longitude);
}
