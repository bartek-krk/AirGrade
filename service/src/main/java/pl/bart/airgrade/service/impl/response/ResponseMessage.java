package pl.bart.airgrade.service.impl.response;

public class ResponseMessage {
    public static final String AQICN_INVALID_API_KEY = "Invalid AQICN API key";
    public static final String AQICN_QUOTA_LIMIT_EXCEEDED = "AQICN API quota limit exceeded";
    public static final String AQICN_UNKNOWN_API_ERROR = "Unknown AQICN API error";

    public static final String WEATHER_API_FORBIDDEN = "Forbidden access to StormWeather API";
    public static final String WEATHER_API_INVALID_COORDINATES = "Given coordinates are incorrect";
    public static final String WEATHER_API_ERROR = "StormWeather API returned error code %d";
}
