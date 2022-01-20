package pl.bart.airgrade.service.impl.response;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime utc;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.utc = LocalDateTime.now(ZoneOffset.UTC);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getUtc() {
        return utc;
    }

    public void setUtc(LocalDateTime utc) {
        this.utc = utc;
    }
}
