package com.epam.core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverCreator extends WebDriverCreator{

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
