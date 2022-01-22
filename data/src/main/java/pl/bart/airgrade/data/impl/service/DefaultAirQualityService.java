package pl.bart.airgrade.data.impl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bart.airgrade.data.api.service.AirQualityService;
import pl.bart.airgrade.data.impl.external.aqicn.response.AqicnApiResponse;
import pl.bart.airgrade.data.impl.internal.air.AirQualityData;
import pl.bart.airgrade.data.impl.mapper.AirQualityDataMapper;

@Service
public class DefaultAirQualityService implements AirQualityService {

    @Value("${aqicn.api.key:null}")
    private String apiKey;

    public AirQualityData getByCoordinates(double latitude, double longitude) {
        String url = "https://api.waqi.info/feed/geo:{lat};{lon}/?token={key}"
                .replace("{lat}", String.valueOf(latitude))
                .replace("{lon}", String.valueOf(longitude))
                .replace("{key}", apiKey);
        RestTemplate rt = new RestTemplate();
        AqicnApiResponse response = rt.getForObject(url, AqicnApiResponse.class);
        return AirQualityDataMapper.map(response);
    }
}
