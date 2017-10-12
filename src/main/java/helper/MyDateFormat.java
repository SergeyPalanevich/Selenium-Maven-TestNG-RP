package helper;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class MyDateFormat {

    public static String currentDatePlusDays(int coutnOfDays) {

        DateTime dateTime = new DateTime(new Date());
        dateTime = dateTime.plusDays(coutnOfDays);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-yyyy");
        String str = dateTime.toString(fmt);
        str = str.replace('-', ' ');
        return str;
    }
}
