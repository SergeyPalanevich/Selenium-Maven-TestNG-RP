package test;

import static helper.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.MainPage;

public class TestCase1 extends BaseTest {

    private MainPage main;

    @Test
    public void checkSingleFlight() {
        String url = "https://www.transavia.com/en-EU/home/";
        String airportNameFrom = "Palma de Mallorca, Spain";
        String airportNameTo = "Munich, Germany";
        String countPassengers = "1 Adult";
        String title = "Where do you want to go?";

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