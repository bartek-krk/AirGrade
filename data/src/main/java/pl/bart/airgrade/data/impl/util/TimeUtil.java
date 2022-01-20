package pl.bart.airgrade.data.impl.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static LocalDateTime convertZonedIsoStringToUtc(String iso) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        ZonedDateTime localtime = ZonedDateTime.parse(iso, formatter);
        return LocalDateTime.ofInstant(localtime.toInstant(), ZoneOffset.UTC);
    }
}
