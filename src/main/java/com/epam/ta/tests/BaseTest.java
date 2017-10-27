package com.epam.ta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.ta.drivers.DriverManager.closeChrome;
import static com.epam.ta.drivers.DriverManager.getChrome;
import static com.epam.ta.helpers.Helpers.setCookie;

public class BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    public static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getChrome();
        driver.get(URL);
        driver = setCookie(driver);
        driver.navigate().refresh();
    }

    @AfterClass
    public void terrDown() {
        closeChrome();
    }
}
