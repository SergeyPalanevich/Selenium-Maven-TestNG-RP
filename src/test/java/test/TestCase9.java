package test;

import static helper.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static helper.Waiters.doSleep;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.MultipleFlightPage;
import pages.MultipleFormPage;

public class TestCase9 extends BaseTest {

    private MainPage main;
    private MultipleFlightPage multipleFlight;
    private MultipleFormPage multipleForm;

    @Test
    public void checkMultipleDestinations() {
        String url = "https://www.transavia.com/en-EU/home/";
        String depatureAirportFirst = "Bologna, Italy";
        String arrivalAirportFirst = "Eindhoven, Netherlands";
        String dateFlightFirst = getCurrentDayPlusSomeDaysWithDateTimeFormat(3);

        String depatureAirportSecond = "Amsterdam (Schiphol), Netherlands";
        String arrivalAirportSecond = "Casablanca, Morocco";
        String dateFlightSecond = getCurrentDayPlusSomeDaysWithDateTimeFormat(9);

        driver.get(url);
        doSleep(3000); /* After document complete - page reloads for this reason need waits */
        main = new MainPage(driver);
        multipleForm = main.addMultipleDestinations();
        doSleep(5000); /* After document complete - page reloads for this reason need waits */
        multipleForm.setOutboundFlight(depatureAirportFirst, arrivalAirportFirst, dateFlightFirst);
        multipleForm.setInboundFlight(depatureAirportSecond, arrivalAirportSecond, dateFlightSecond);
        multipleFlight = multipleForm.runSearch();
        multipleFlight.selectOutboundFlight();
        multipleFlight.selectInboundFlight();
        assertTrue(multipleFlight.getTotalAmount() != 0);
    }
}
