package pl.bart.airgrade.data.impl.external.aqicn.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AqicnApiResponseTime {
    private String s;
    private String tz;
    private Long v;
    private String iso;

    public Optional<String> getOptionalTimeString() {
        return Optional.ofNullable(this.s);
    }

    public Optional<String> getOptionalTimezone() {
        return Optional.ofNullable(this.tz);
    }

    public Optional<Long> getOptionalValue() {
        return Optional.ofNullable(this.v);
    }

    public Optional<String> getOptionalIsoString() {
        return Optional.ofNullable(this.iso);
    }
}
