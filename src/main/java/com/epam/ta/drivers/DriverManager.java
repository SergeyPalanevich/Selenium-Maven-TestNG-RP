package com.epam.ta.drivers;

import com.epam.ta.helpers.NoSuchWebDriverExeption;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver chrome;
    private static WebDriver firefox;

    private DriverManager() {
    }

    public static WebDriver getDriver(ChromeAndFireFox chromeAndFirefox) throws NoSuchWebDriverExeption {
        switch (chromeAndFirefox) {
            case ChromeDriver:
                chrome = new ChromeDriverCreator().createDriver();
                return chrome;
            case FirefoxDriver:
                firefox = new FireFoxDriverCreator().createDriver();
                return firefox;
            default:
                throw new NoSuchWebDriverExeption("Invalid name for WebDriver...");
        }
    }
}
