package helper;

import org.openqa.selenium.By;
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
}
