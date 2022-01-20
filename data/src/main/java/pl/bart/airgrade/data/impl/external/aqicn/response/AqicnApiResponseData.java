package pl.bart.airgrade.data.impl.external.aqicn.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class AqicnApiResponseData {
    private Integer aqi;
    private Integer idx;
    private List<AqicnApiResponseAttribution> attributions;
    private AqicnApiResponseCity city;
    private String dominentpol;
    private AqicnApiResponseIaqi iaqi;
    private AqicnApiResponseTime time;

    public Optional<Integer> getOptionalAqi() {
        return Optional.ofNullable(this.aqi);
    }

    public Optional<Integer> getOptionalIdx() {
        return Optional.ofNullable(this.idx);
    }

    public Optional<List<AqicnApiResponseAttribution>> getOptionalAttributions () {
        return Optional.ofNullable(this.attributions);
    }

    public Optional<AqicnApiResponseCity> getOptionalCity () {
        return Optional.ofNullable(this.city);
    }

    public Optional<String> getOptionalDomonentpol () {
        return Optional.ofNullable(this.dominentpol);
    }

    public Optional<AqicnApiResponseIaqi> getOptionalIaqi () {
        return Optional.ofNullable(this.iaqi);
    }

    public Optional<AqicnApiResponseTime> getOptionalTime () {
        return Optional.ofNullable(this.time);
    }
}
