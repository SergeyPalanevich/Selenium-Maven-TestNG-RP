package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPriceFromRegex {
    public static int getPrice(String str) {

        String testStr = str;
        String first = "";
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

        value = Integer.valueOf(price1);
        return value;
    }
}
