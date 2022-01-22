package pl.bart.airgrade.service.impl.controller;

public class RestUri {
    public static final String URI_BASE = "/api";

    public static final String AIR_QUALITY_DATA = URI_BASE + "/air";

    public static final String WEATHER = URI_BASE + "/weather";
    public static final String WEATHER_FORECAST = WEATHER + "/forecast";
    public static final String WEATHER_NOW = WEATHER + "/now";

    public static final String OVERVIEW = URI_BASE + "/overview";
}
