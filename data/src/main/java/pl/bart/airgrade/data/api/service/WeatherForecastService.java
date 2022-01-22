package pl.bart.airgrade.data.api.service;

import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiResponse;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;
import pl.bart.airgrade.data.impl.internal.weather.WeatherNow;

public interface WeatherForecastService {
    WeatherForecast getByCoordinates(double latitude, double longitude);
    WeatherForecast getFutureByCoordinates(double latitude, double longitude, long limit);
    WeatherNow getByCoordinatesNow(double latitude, double longitude);
}
