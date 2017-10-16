package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    public static void waitElementToBeClickable(WebDriver driver, WebElement element, int time){
        (new WebDriverWait(driver, time))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void ignoreCookieDiv(WebDriver driver, int time) {
        try {
            waitElementToBeClickable(driver, driver.findElement(
                By.xpath("//a[@href='/en-EU/the-small-print/cookie-policy/']")), time);
        } catch (Exception e) {

        }
    }

    public static void doSleep(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitDocumentIsReady(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i = 0; i < 25; i++) {
            if (js.executeScript("return document.readyState").toString().equals("complete") && js
                .executeScript("return jQuery.active").toString().equals("0")) {
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
