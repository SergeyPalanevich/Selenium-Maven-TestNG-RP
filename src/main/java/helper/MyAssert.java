package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAssert {

    public static void assertAndVerifyElement(WebDriver driver, By element) throws InterruptedException {
        boolean isPresent = false;

        for (int i = 0; i < 5; i++) {
            try {
                if (driver.findElement(element) != null) {
                    isPresent = true;
                    break;
                }
            } catch (Exception e) {
                // System.out.println(e.getLocalizedMessage());
                Thread.sleep(1000);
            }
        }
        Assert.assertTrue(isPresent, "\"" + element + "\" is not present.");
    }
}
