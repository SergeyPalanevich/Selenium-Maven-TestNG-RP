package com.epam.ta.drivers;

import org.openqa.selenium.WebDriver;

import static com.epam.ta.drivers.ChromeDriverCreator.closeChromeDriver;
import static com.epam.ta.drivers.ChromeDriverCreator.setupChromeDriver;
import static com.epam.ta.drivers.FireFoxDriverCreator.closeFireFoxDriver;
import static com.epam.ta.drivers.FireFoxDriverCreator.setupFireFoxDriver;

public class DriverManager {
    public static WebDriver getChrome(){
       return setupChromeDriver();
    }

    public static void closeChrome(){
        closeChromeDriver();
    }

    public static WebDriver getFireFox(){
        return setupFireFoxDriver();
    }

    public static void closeFireFox(){
        closeFireFoxDriver();
    }
}
