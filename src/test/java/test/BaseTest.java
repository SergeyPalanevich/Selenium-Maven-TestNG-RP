package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static driver.MyDriver.getChromeDriver;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = getChromeDriver();
    }


    @AfterClass
    public void terrDown(){
        driver.quit();
    }
}
