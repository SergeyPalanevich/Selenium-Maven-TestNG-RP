package com.epam.ta.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FireFoxDriverCreator {
    private static WebDriver driver;

    private FireFoxDriverCreator() {
    }

    static WebDriver setupFireFoxDriver() {
        if(driver == null){
            FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox46\\firefox.exe"));
            FirefoxProfile profile = new FirefoxProfile();
            driver = new FirefoxDriver(binary, profile);
        }
        return driver;
    }

    static void closeFireFoxDriver() {
        driver.quit();
        driver = null;
    }
}
