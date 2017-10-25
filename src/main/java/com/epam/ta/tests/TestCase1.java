package com.epam.ta.tests;

import com.epam.ta.pages.MainPage;
import org.testng.annotations.Test;

import static com.epam.ta.helpers.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static org.testng.Assert.assertTrue;

public class TestCase1 extends BaseTest {
    private String url = "https://www.transavia.com/en-EU/home/";
    private String airportNameFrom = "Palma de Mallorca, Spain";
    private String airportNameTo = "Munich, Germany";
    private String countPassengers = "1 Adult";
    private String title = "Where do you want to go?";
    private MainPage main;

    @Test(description = "This TC check price for single flight")
    public void checkSingleFlight() {


        driver.get(url);
        main = new MainPage(driver);
        assertTrue(main.isTitleCorrect(title));
        main.setAirportFrom(airportNameFrom);
        assertTrue(main.isAirportDisplayedInFromField(airportNameFrom));
        main.setAirportTo(airportNameTo);
        assertTrue(main.isAirportDisplayedInToField(airportNameTo));
        main.selectDatepickerDepart();
        assertTrue(main.isDatepickerDisplayed());
        main.setOutboundDate(getCurrentDayPlusSomeDaysWithDateTimeFormat(2));
        main.uncheckReturnOnCheckBox();
        main.setCountOfPassengers();
        assertTrue(main.isCountOfPassengersDisplayed(countPassengers));
        main.runSearch();
        assertTrue(main.isPriceEnabled());
    }
}