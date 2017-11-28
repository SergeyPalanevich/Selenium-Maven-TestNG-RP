package com.epam.framework.features.transavia.tests;

import com.epam.framework.core.drivers.DriverTypes;
import com.epam.framework.core.exeptions.NoSuchWebDriverExeption;
import com.epam.framework.features.transavia.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.framework.core.drivers.DriverManager.closeDriver;
import static com.epam.framework.core.drivers.DriverManager.getDriver;
import static com.epam.framework.core.utils.LoggerUtils.info;


public class BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    public WebDriver driver;

    @BeforeClass()
    public void setUp() throws NoSuchWebDriverExeption {
        driver = getDriver(DriverTypes.CHROME);
        driver.get(URL);
        info(URL);
        new HomePage(driver).confirmCookies();
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(){
        closeDriver();
    }
}
