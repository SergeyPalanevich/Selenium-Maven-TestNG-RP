package com.epam.core.drivers;

import com.epam.core.exeptions.NoSuchWebDriverExeption;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static final long MANAGE_TIMEOUT = 25;
    private static final String PATH_TO_COOKIES = "src/main/resources/cookies.out";
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver(DriverTypes driverName) throws NoSuchWebDriverExeption {
        if(driver == null) {
            switch (driverName) {
                case CHROME:
                    driver = new ChromeDriverCreator().createDriver();
                    setDriverManage();
                    return driver;
                case FIREFOX:
                    driver = new FireFoxDriverCreator().createDriver();
                    setDriverManage();
                    return driver;
                default:
                    throw new NoSuchWebDriverExeption("Invalid name for WebDriver...");
            }
        }else {
            return driver;
        }
    }

    private static void setDriverManage(){
        driver.manage().timeouts().implicitlyWait(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(MANAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver setCookie(WebDriver wDriver){
        WebDriver driver = wDriver;

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PATH_TO_COOKIES);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Cookie> cookies = null;
        try {
            cookies = (Set<Cookie>) oin.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
}
