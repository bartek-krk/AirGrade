package pl.bart.airgrade.data.impl.external.aqicn.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AqicnApiResponseIaqi {
    private AqicnApiResponseIaqiElement co;
    private AqicnApiResponseIaqiElement h;
    private AqicnApiResponseIaqiElement no2;
    private AqicnApiResponseIaqiElement o3;
    private AqicnApiResponseIaqiElement p;
    private AqicnApiResponseIaqiElement pm10;
    private AqicnApiResponseIaqiElement pm25;
    private AqicnApiResponseIaqiElement so2;
    private AqicnApiResponseIaqiElement t;
    private AqicnApiResponseIaqiElement w;

    public Optional<AqicnApiResponseIaqiElement> getOptionalCo() {
        return Optional.ofNullable(this.co);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalH() {
        return Optional.ofNullable(this.h);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalNo2() {
        return Optional.ofNullable(this.no2);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalO3() {
        return Optional.ofNullable(this.o3);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalPm10() {
        return Optional.ofNullable(this.pm10);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalPm25() {
        return Optional.ofNullable(this.pm25);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalSo2() {
        return Optional.ofNullable(this.so2);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalT() {
        return Optional.ofNullable(this.t);
    }

    public Optional<AqicnApiResponseIaqiElement> getOptionalW() {
        return Optional.ofNullable(this.w);
    }

}
