package com.epam.ta.tests;

import com.epam.ta.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static com.epam.ta.helpers.Helpers.setCookie;

public class BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    public static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.ChromeDriver.getDriver();
        driver.get(URL);
        driver = setCookie(driver);
        driver.navigate().refresh();
    }

    @AfterClass
    public void terrDown() {
        driver.quit();
    }
}
