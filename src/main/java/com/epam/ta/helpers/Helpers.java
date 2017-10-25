package com.epam.ta.helpers;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {

    public static void moveToMyElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    // format "dd MMM yyyy"
    public static String getCurrentDayPlusSomeDaysWithDateTimeFormat(int countOfDays) {
        DateTime dateTime = new DateTime(new Date());
        dateTime = dateTime.plusDays(countOfDays);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-yyyy");
        String dateFormat = dateTime.toString(fmt);
        dateFormat = dateFormat.replace('-', ' ');
        return dateFormat;
    }

    public static float getPriceFromString(String argStr) {
        String subString = "";
        float price;
        Pattern p1 = Pattern.compile("[€|Ç].\\d*.\\d*");
        Matcher m = p1.matcher(argStr);
        while (m.find()) {
            subString = argStr.substring(m.start(0));
        }
        String numberPart = subString.replaceAll("[^0-9.]", "");
        price = Float.valueOf(numberPart);
        return price;
    }
}
