package pl.bart.airgrade.data.api.service;

import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiResponse;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;

public interface WeatherForecastService {
    WeatherForecast getByCoordinates(double latitude, double longitude);
}
