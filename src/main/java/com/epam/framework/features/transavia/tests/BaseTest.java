package com.epam.framework.features.transavia.tests;

import com.epam.framework.core.drivers.DriverTypes;
import com.epam.framework.core.exeptions.NoSuchWebDriverExeption;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.framework.core.drivers.DriverManager.*;

public class BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    public static WebDriver driver;

    @BeforeClass()
    public void setUp() throws NoSuchWebDriverExeption {
        driver = getDriver(DriverTypes.CHROME);
        driver.get(URL);
        driver = setCookie(driver);
    }

    @AfterClass()
    public void cleanUp(){
        closeDriver();
    }
}
