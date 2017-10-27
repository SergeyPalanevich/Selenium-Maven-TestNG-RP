package com.epam.ta.drivers;

import org.openqa.selenium.WebDriver;

public enum DriverManager {
    ChromeDriver,
    FirefoxDriver;

    private static WebDriver chrome;
    private static WebDriver firefox;

    public WebDriver getDriver() {
        switch (this) {
            case ChromeDriver:
                if (chrome == null) {
                    chrome = new ChromeDriverCreator().createDriver();
                }
                return chrome;
            case FirefoxDriver:
                if (firefox == null) {
                    firefox = new FireFoxDriverCreator().createDriver();
                }
                return firefox;
            default:
                throw new AssertionError("Unknown WebDriver !!!");
        }
    }
}
