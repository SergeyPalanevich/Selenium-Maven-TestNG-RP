package com.epam.ta.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FireFoxDriverCreator extends WebDriverCreator{

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
