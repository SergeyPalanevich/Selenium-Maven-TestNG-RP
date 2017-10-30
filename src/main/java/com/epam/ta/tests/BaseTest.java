package com.epam.ta.tests;

import com.epam.ta.drivers.DriverManager;
import com.epam.ta.helpers.NoSuchWebDriverExeption;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.ta.drivers.ChromeAndFireFox.ChromeDriver;
import static com.epam.ta.helpers.Helpers.setCookie;

public class BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    private static final String BLANK = "about:BLANK";
    public static WebDriver driver;


    @BeforeClass()
    public void setUp() throws NoSuchWebDriverExeption {
        driver = DriverManager.getDriver(ChromeDriver);
        driver.get(URL);
        driver = setCookie(driver);
    }

    @AfterClass()
    public void cleanUp() throws NoSuchWebDriverExeption {
        driver.quit();
    }
}
