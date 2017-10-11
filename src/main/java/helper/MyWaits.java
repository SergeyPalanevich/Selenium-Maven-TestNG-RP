package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyWaits {
    public static void waitSripts(WebDriver driver){
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }
    public static void waitLoadPage(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    public static void waitUntilToBeClickable(WebDriver driver, String selector){
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(selector))));
    }


    public static void waitUntilToBePresence(WebDriver driver, String selector){
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
    }

    public static void waitUntilToBeVisOfElement(WebDriver driver, String selector){
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }



}
