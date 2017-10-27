package com.epam.ta.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FireFoxDriverCreator extends WebDriverCreator{
    private static final String LOCAL_PATH_TO_FIREFOX = "C:\\Program Files\\Mozilla Firefox46\\firefox.exe";

    @Override
    public WebDriver createDriver() {
        FirefoxBinary binary = new FirefoxBinary(new File(LOCAL_PATH_TO_FIREFOX));
        FirefoxProfile profile = new FirefoxProfile();
        return  new FirefoxDriver(binary, profile);
    }
}
