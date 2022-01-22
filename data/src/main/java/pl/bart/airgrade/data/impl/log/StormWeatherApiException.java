package pl.bart.airgrade.data.impl.log;

public class StormWeatherApiException extends RuntimeException {
    private int code;

    public StormWeatherApiException(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
