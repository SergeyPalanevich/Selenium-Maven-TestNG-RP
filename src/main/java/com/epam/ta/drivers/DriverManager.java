package com.epam.ta.drivers;

import org.openqa.selenium.WebDriver;

public enum DriverManager {
    ChromeDriver,
    FirefoxDriver;

    public WebDriver getDriver() {
        switch (this) {
            case ChromeDriver:
                return new ChromeDriverCreator().createDriver();
            case FirefoxDriver:
                return new FireFoxDriverCreator().createDriver();
            default:
                throw new AssertionError("Unknown WebDriver !!!");
        }
    }
}
