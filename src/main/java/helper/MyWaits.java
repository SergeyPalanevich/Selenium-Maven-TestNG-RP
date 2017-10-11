package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyWaits {
    public static void waitSripts(WebDriver driver){
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }



    public static void waitUntilToBePresence(WebDriver driver, String selector){
        (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
    }

    public static void waitUntilToBeVisOf(WebDriver driver, String selector){
        (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOfElementLocated((By.xpath(selector))));
    }



}
