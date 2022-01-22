package pl.bart.airgrade.data.impl.util;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class WindUtilTest {
    @Test
    public void should() {
        assertEquals(24, WindUtil.knotsToBeaufort(5.2));
    }
}