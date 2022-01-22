package pl.bart.airgrade.data.impl.util;

import java.util.Arrays;
import java.util.List;

public class WindUtil {

    public static final Double NAUTICAL_MILE_IN_KM = 1.852;
    public static final List<String> WIND_DIRECTIONS = Arrays.asList(
            "N",
            "NNE",
            "NE",
            "ENE",
            "E",
            "ESE",
            "SE",
            "SSE",
            "S",
            "SSW",
            "SW",
            "WSW",
            "W",
            "WNW",
            "NW",
            "NNW"
    );

    public static Integer knotsToBeaufort(Double knots) {
        if (knots == null) {
            return null;
        }

        final double kmph = knotsToKmph(knots);
        final double exponent = 2.0/3.0;
        final double basis = kmph/3.01;
        final double beaufort = Math.pow(basis, exponent);
        return Math.toIntExact(Math.round(beaufort));
    }

    public static String degreesToDirection(Double degrees) {
        if (degrees == null) {
            return null;
        }

        int index = (int) (degrees/22.5);
        return WIND_DIRECTIONS.get(index);
    }

    private static double knotsToKmph(double knots) {
        return knots*NAUTICAL_MILE_IN_KM;
    }

    private static boolean isBetween(double value, double threshold1, double threshold2) {
        return (value > threshold1 && value <= threshold2) || (value < threshold1 && value > threshold2);
    }
}
