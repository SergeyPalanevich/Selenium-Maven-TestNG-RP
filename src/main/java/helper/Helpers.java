package helper;

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

    public static String getCurrentDayPlusSomeDaysWithDateTimeFormat(int coutnOfDays) {
        DateTime dateTime = new DateTime(new Date());
        dateTime = dateTime.plusDays(coutnOfDays);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-yyyy");
        String strDate = dateTime.toString(fmt);
        strDate = strDate.replace('-', ' ');
        return strDate;
    }

    public static int getPriceFromString(String str) {

        String testStr = str;
        String first = "";
        float myFloat;
        int value;

        Pattern p1 = Pattern.compile("€.\\d*");
        Matcher m = p1.matcher(testStr);
        while (m.find()) {
            first = testStr.substring(m.start() + 1);
        }

        String[] result;
        String price = "";
        result = first.split("^€\\s|.[a-zA-Z]+");
        for (String s : result) {
            price = s;
        }

        String[] result1;
        String price1 = "";
        result1 = price.split("\\s");
        for (String s : result1) {
            price1 = s;
        }

        myFloat = Float.valueOf(price1);
        value = (int) myFloat;
        System.out.println(value);
        return value;
    }

    public static int calcTotalPrice(int outPriceArg, int inPriceArg) {
        int outPrice = (outPriceArg * 3);
        int inPrice = (inPriceArg * 3);
        int baggage = 42;
        int count = outPrice + inPrice + (baggage * 3);
        return count;
    }
}
