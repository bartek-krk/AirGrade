package pl.bart.airgrade.data.impl.external.aqicn.response;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "status")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = AqicnApiSuccessResponse.class, name = "ok"),
                @JsonSubTypes.Type(value = AqicnApiErrorResponse.class, name = "error")
        })
public class AqicnApiResponse {
}
