package pl.bart.airgrade.data.impl.external.aqicn.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AqicnApiResponseAttribution {
    private String url;
    private String name;

    public Optional<String> getOptionalUrl() {
        return Optional.ofNullable(this.url);
    }

    public Optional<String> getOptionalName() {
        return Optional.ofNullable(this.name);
    }
}
