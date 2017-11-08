package com.epam.core.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateTimeUtils {

    private static final String DATE_FORMAT = "dd-MMM-yyyy";

    public static String getCurrentDayPlusSomeDaysWithDateTimeFormat(int countOfDays) {
        DateTime dateTime = new DateTime(new Date());
        dateTime = dateTime.plusDays(countOfDays);
        DateTimeFormatter fmt = DateTimeFormat.forPattern(DATE_FORMAT);
        String dateFormat = dateTime.toString(fmt);
        dateFormat = dateFormat.replace('-', ' ');
        return dateFormat; // dd MMM yyyy
    }


}
