package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ReadyState {

    public static void checkPageIsReady(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Initially bellow given if condition will check ready state of page.

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i = 0; i < 25; i++) {
            if (js.executeScript("return document.readyState").toString().equals("complete") && js.executeScript("return jQuery.active").toString().equals("0")) {
                break;
            }else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
          }
    }

}
