package com.epam.ta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.epam.ta.pages.ErrorPage;
import com.epam.ta.pages.MainPage;

import static com.epam.ta.drivers.MyDriver.getChromeDriver;
import static org.testng.Assert.assertEquals;

public class TestCase8 {

    private MainPage main;
    private WebDriver driver;

    @Test
    public void checkErrorMessage() {
        String url = "https://www.transavia.com/en-EU/home/";
        String from = "Dubai";
        String to = "Agadir, Morocco";
        String error = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco."
                + " However, we do fly from Dubai, United Arab Emirates to other destinations."
                + " Please change your destination and try again.";
        driver = getChromeDriver();
        driver.get(url);
        main = new MainPage(driver);
        main.fillFromField(from);
        main.fillToField(to);
        ErrorPage errorPage = new ErrorPage(main.runSearch());
        assertEquals(errorPage.getError(), error);
    }

    @AfterMethod
    public void terrDown() {
        driver.close();
    }
}
