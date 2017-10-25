package com.epam.ta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.epam.ta.pages.MainPage;
import com.epam.ta.pages.MultipleFlightPage;
import com.epam.ta.pages.MultipleFormPage;

import static com.epam.ta.drivers.MyDriver.getChromeDriver;
import static com.epam.ta.helpers.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static org.testng.Assert.assertTrue;

public class TestCase9 {

    private MainPage main;
    private MultipleFlightPage multipleFlight;
    private MultipleFormPage multipleForm;
    private WebDriver driver;

    @Test
    public void checkMulItipleDestinations() {
        String url = "https://www.transavia.com/en-EU/home/";
        String depatureAirportFirst = "Bologna, Italy";
        String arrivalAirportFirst = "Eindhoven, Netherlands";
        String dateFlightFirst = getCurrentDayPlusSomeDaysWithDateTimeFormat(3);

        String depatureAirportSecond = "Amsterdam (Schiphol), Netherlands";
        String arrivalAirportSecond = "Casablanca, Morocco";
        String dateFlightSecond = getCurrentDayPlusSomeDaysWithDateTimeFormat(9);
        driver = getChromeDriver();
        driver.get(url);
        main = new MainPage(driver);
        multipleForm = main.addMultipleDestinations();
        multipleForm.setOutboundFlight(depatureAirportFirst, arrivalAirportFirst, dateFlightFirst);
        multipleForm.setInboundFlight(depatureAirportSecond, arrivalAirportSecond, dateFlightSecond);
        multipleFlight = multipleForm.runSearch();
        multipleFlight.selectOutboundFlight();
        multipleFlight.selectInboundFlight();
        assertTrue(multipleFlight.getTotalAmount() != 0);
    }

    @AfterMethod
    public void terrDown() {
       driver.close();
    }
}
