package com.epam.ta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.ta.drivers.MyDriver.getChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = getChromeDriver();
    }


    @AfterClass
    public void terrDown(){
        driver.quit();
    }
}
