package com.gmail.jorgegilcavazos.ballislife.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class UtilitiesTest {

    @Test
    public void testGetPeriodString() {
        String firstQtr = Utilities.getPeriodString("1", "Qtr");
        String fourthQtr = Utilities.getPeriodString("4", "Qtr");
        String overTime1 = Utilities.getPeriodString("5", "OT");
        String overTime2 = Utilities.getPeriodString("6", "OT");
        String overTime6 = Utilities.getPeriodString("10", "OT");

        assertEquals("1 Qtr", firstQtr);
        assertEquals("4 Qtr", fourthQtr);
        assertEquals("1OT", overTime1);
        assertEquals("2OT", overTime2);
        assertEquals("6OT", overTime6);
    }

    @Test
    public void testGetStreamableShortcodeFromUrl() {
        String url1 = "http://streamable.com/12345";
        String url2 = "streamable.com/ft67e";
        String url3 = "http://streamable.com/a23r";
        String url4 = "http://google.com/12345";

        assertEquals("12345", Utilities.getStreamableShortcodeFromUrl(url1));
        assertEquals("ft67e", Utilities.getStreamableShortcodeFromUrl(url2));
        assertEquals("a23r", Utilities.getStreamableShortcodeFromUrl(url3));
        assertEquals(null, Utilities.getStreamableShortcodeFromUrl(url4));
    }
}
