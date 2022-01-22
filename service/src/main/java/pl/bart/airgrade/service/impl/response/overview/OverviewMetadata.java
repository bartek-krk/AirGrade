package pl.bart.airgrade.service.impl.response.overview;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OverviewMetadata {
    private LocalDateTime utc;
    private Double latitude;
    private Double longitude;
    private String description;
}
