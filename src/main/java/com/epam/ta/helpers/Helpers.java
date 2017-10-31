package com.epam.ta.helpers;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Set;

public class Helpers {
    private static final String PATH_TO_COOKIES = "src/main/resources/cookies.out";
    private static final String DATE_FORMAT = "dd-MMM-yyyy";


    public static String getCurrentDayPlusSomeDaysWithDateTimeFormat(int countOfDays) {
        DateTime dateTime = new DateTime(new Date());
        dateTime = dateTime.plusDays(countOfDays);
        DateTimeFormatter fmt = DateTimeFormat.forPattern(DATE_FORMAT);
        String dateFormat = dateTime.toString(fmt);
        dateFormat = dateFormat.replace('-', ' ');
        return dateFormat; // dd MMM yyyy
    }

    public static WebDriver setCookie(WebDriver wDriver){
        WebDriver driver = wDriver;

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PATH_TO_COOKIES);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Cookie> cookies = null;
        try {
            cookies = (Set<Cookie>) oin.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        return driver;
    }
}
