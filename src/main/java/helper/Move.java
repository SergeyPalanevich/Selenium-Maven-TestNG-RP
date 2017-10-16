package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Move {
    public static void moveToMyElement(WebDriver driver, WebElement element){
        new Actions(driver).moveToElement(element).perform();
    }

}
