package pl.bart.airgrade.data.impl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.bart.airgrade.data.api.service.WeatherForecastService;
import pl.bart.airgrade.data.impl.external.stormweather.response.StormWeatherApiResponse;
import pl.bart.airgrade.data.impl.internal.weather.WeatherForecast;
import pl.bart.airgrade.data.impl.log.StormWeatherApiException;
import pl.bart.airgrade.data.impl.log.StormWeatherApiForbiddenException;
import pl.bart.airgrade.data.impl.log.StormWeatherApiInvalidCoordinatesException;
import pl.bart.airgrade.data.impl.mapper.WeatherForecastMapper;


@Service
public class DefaultWeatherForecastService implements WeatherForecastService {

    public static final String RAPID_API_KEY_HEADER = "x-rapidapi-key";

    @Value("${stormweather.api.key:null}")
    private String apiKey;

    @Override
    public WeatherForecast getByCoordinates(double latitude, double longitude) {
        try {
            String url = "https://stormglass.p.rapidapi.com/forecast?lng={lon}&lat={lat}"
                    .replace("{lon}", String.valueOf(longitude))
                    .replace("{lat}", String.valueOf(latitude));
            final RestTemplate rt = new RestTemplate();
            final HttpHeaders headers = new HttpHeaders();
            headers.set(RAPID_API_KEY_HEADER, apiKey);
            final HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<StormWeatherApiResponse> response = rt.exchange(url, HttpMethod.GET, entity, StormWeatherApiResponse.class);
            return WeatherForecastMapper.map(response.getBody());
        } catch (HttpClientErrorException clientErrorException) {
            final int status = clientErrorException.getRawStatusCode();
            if (status == 403) {
                throw new StormWeatherApiForbiddenException();
            } else if (status == 422) {
                throw new StormWeatherApiInvalidCoordinatesException();
            } else {
                throw new StormWeatherApiException(status);
            }
        } catch (Exception e) {
            throw new StormWeatherApiException(0);
        }
    }
}
