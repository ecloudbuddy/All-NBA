package com.gmail.jorgegilcavazos.ballislife.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * Class to test {@link DateFormatUtil}.
 */
public class DateFormatUtilTest {

    @Test
    public void testFormatRedditDate() {
        Calendar now = Calendar.getInstance();
        Calendar fiftyMinAgo = Calendar.getInstance();
        fiftyMinAgo.add(Calendar.MINUTE, -50);
        Calendar fourHoursAgo = Calendar.getInstance();
        fourHoursAgo.add(Calendar.HOUR, -4);
        Calendar twoDaysAgo = Calendar.getInstance();
        twoDaysAgo.add(Calendar.HOUR, -60);

        String nowString = DateFormatUtil.formatRedditDate(now.getTime());
        String fiftyMinAgoString = DateFormatUtil.formatRedditDate(fiftyMinAgo.getTime());
        String fourHoursAgoString = DateFormatUtil.formatRedditDate(fourHoursAgo.getTime());
        String twoDaysAgoString = DateFormatUtil.formatRedditDate(twoDaysAgo.getTime());

        assertEquals(" just now ", nowString);
        assertEquals("50m", fiftyMinAgoString);
        assertEquals("4hr", fourHoursAgoString);
        assertEquals("2 days", twoDaysAgoString);
    }

    @Test
    public void testFormatScoreBoardDate() {
        String actual = DateFormatUtil.formatScoreboardDate(1999, 12, 30);
        String expected = "1999-12-30";

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatScoreBoardDate_dayAndMonthLessThanTen() {
        String actual = DateFormatUtil.formatScoreboardDate(2016, 9, 3);
        String expected = "2016-09-03";

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatToolbarDate() {
        String actual = DateFormatUtil.formatToolbarDate("20100516");
        String expected = "05/16";

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatToolbarDate_Today() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.US);

        String actual = DateFormatUtil.formatToolbarDate(format.format(now.getTime()));
        String expected = "Today";

        assertEquals(expected, actual);
    }

    @Test
    public void testFormatNavigatorDate() {
        String date1 = DateFormatUtil.formatNavigatorDate(Calendar.getInstance().getTime());
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DAY_OF_YEAR, -1);
        String date2 = DateFormatUtil.formatNavigatorDate(yesterday.getTime());
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_YEAR, 1);
        String date3 = DateFormatUtil.formatNavigatorDate(tomorrow.getTime());
        Calendar someDay = Calendar.getInstance();
        someDay.set(2016, 9, 14);
        String date4 = DateFormatUtil.formatNavigatorDate(someDay.getTime());

        assertEquals("Today", date1);
        assertEquals("Yesterday", date2);
        assertEquals("Tomorrow", date3);
        assertEquals("Friday, October 14", date4);
    }

    @Test
    public void testLocalizeGameTime() {
        String date1 = "9:00 pm";
        String date2 = "10:30 pm ET";
        String date3 = "8:15 am";
        String date4 = "11:59 am ET";
        String date5 = "12:00 pm ET";

        String actual1 = DateFormatUtil.localizeGameTime(date1, TimeZone.getTimeZone("America/Mexico_City"));
        String actual2 = DateFormatUtil.localizeGameTime(date2, TimeZone.getTimeZone("America/Los_Angeles"));
        String actual3 = DateFormatUtil.localizeGameTime(date3, TimeZone.getTimeZone("America/New_York"));
        String actual4 = DateFormatUtil.localizeGameTime(date4, TimeZone.getTimeZone("America/Europe/London"));
        String actual5 = DateFormatUtil.localizeGameTime(date5, TimeZone.getTimeZone("America/Los_Angeles"));

        assertEquals("8:00 PM", actual1);
        assertEquals("7:30 PM", actual2);
        assertEquals("8:15 AM", actual3);
        assertEquals("4:59 PM", actual4);
        assertEquals("9:00 AM", actual5);
    }
}
