package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testssss {
    public static void main(String[] args){
        String argStr = "€ 218.00";

        String subString = "";
        float price;

        Pattern p1 = Pattern.compile("[€|Ç].\\d*.\\d*");
        Matcher m = p1.matcher(argStr);
        while (m.find()) {
            subString = argStr.substring(m.start(0));
        }

        String numberPart = subString.replaceAll("[^0-9.]", "");


        price = Float.valueOf(numberPart);
        System.out.println("Price is " + price);
    }
}
