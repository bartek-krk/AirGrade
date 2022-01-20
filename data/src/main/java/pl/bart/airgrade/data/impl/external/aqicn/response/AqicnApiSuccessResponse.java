package pl.bart.airgrade.data.impl.external.aqicn.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AqicnApiSuccessResponse extends AqicnApiResponse {
    private String status;
    private AqicnApiResponseData data;

    public Optional<String> getOptionalStatus() {
        return Optional.ofNullable(this.status);
    }

    public Optional<AqicnApiResponseData> getOptionalData() {
        return Optional.ofNullable(this.data);
    }
}
