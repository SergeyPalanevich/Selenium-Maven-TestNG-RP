package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    public static void elementIsClickable(WebDriver driver, WebElement element, int time){
        (new WebDriverWait(driver, time))
            .until(ExpectedConditions.elementToBeClickable(element));
    }
}
