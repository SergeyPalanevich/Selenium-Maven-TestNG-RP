package com.epam.ta.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ChromeDriverCreator{

    private static final String PATH_TO_DRIVER = "D:\\drivers\\chromedriver.exe";
    private static WebDriver driver;

    private ChromeDriverCreator() {
    }

    static WebDriver setupChromeDriver() {
        if(driver == null) {
            ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(PATH_TO_DRIVER)).build();
            LoggingPreferences logs = new LoggingPreferences();
            logs.enable(LogType.DRIVER, Level.WARNING);
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
            try {
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver = new ChromeDriver(service, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    static void closeChromeDriver(){
        driver.quit();
    }
}
