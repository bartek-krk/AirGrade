package pl.bart.airgrade.data.impl.external.aqicn.response;

import lombok.Getter;
import lombok.Setter;
import pl.bart.airgrade.data.impl.util.SafeList;

import java.util.Optional;

@Getter
@Setter
public class AqicnApiResponseCity {
    private SafeList<Double> geo;
    private String name;
    private String url;

    public Optional<SafeList<Double>> getOptionalGeo() {
        return Optional.ofNullable(this.geo);
    }

    public Optional<String> getOptionalName() {
        return Optional.ofNullable(this.name);
    }

    public Optional<String> getOptionalUrl() {
        return Optional.ofNullable(this.url);
    }
}
