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

public class ChromeDriverCreator extends WebDriverCreator{

    private static final String PATH_TO_DRIVER = "src/main/resources/binaries/chromedriver.exe";
    public static final long MANAGE_TIMEOUT = 25;

    @Override
    public WebDriver createDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(PATH_TO_DRIVER)).build();
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.INFO);
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriver driver = new ChromeDriver(service, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
