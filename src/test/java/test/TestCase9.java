package test;

import static helper.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static helper.Waiters.doSleep;
import static helper.Waiters.ignoreCookieDiv;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.MultipleFlightPage;
import pages.MultipleFormPage;

public class TestCase9 extends BaseTest {
    
    @Test
    public void checkMultipleDestinations() {
        String url = "https://www.transavia.com/en-EU/home/";
        String depatureAirportFirst = "Bologna, Italy";
        String arrivalAirportFirst = "Eindhoven, Netherlands";
        String dateFlightFirst = getCurrentDayPlusSomeDaysWithDateTimeFormat(3);

        String depatureAirportSecond = "Amsterdam (Schiphol), Netherlands";
        String arrivalAirportSecond = "Casablanca, Morocco";
        String dateFlightSecond = getCurrentDayPlusSomeDaysWithDateTimeFormat(9);
        MainPage main;
        MultipleFlightPage multipleFlight;
        MultipleFormPage multipleForm;


        driver.get(url);
        doSleep(3000);
        main = new MainPage(driver);
        multipleForm = main.addMultipleDestinations();
        doSleep(5000);
        multipleForm.setOutboundFlight(depatureAirportFirst, arrivalAirportFirst, dateFlightFirst);
        multipleForm.setInboundFlight(depatureAirportSecond, arrivalAirportSecond, dateFlightSecond);
        multipleFlight = multipleForm.runSearch();
        multipleFlight.selectOutboundFligh();
        multipleFlight.selectInboundFlight();
        int amount = multipleFlight.getTotalAmount();
        assertTrue(amount != 0);
    }
}
