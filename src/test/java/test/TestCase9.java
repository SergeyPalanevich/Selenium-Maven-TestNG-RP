package test;

import static helper.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static helper.Waiters.ignoreCookieDiv;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.MultipleFlightPage;
import pages.MultipleFormPage;

public class TestCase9 extends BaseTest{
    @Test
    public void checkMultipleDestinations(){
        String url = "https://www.transavia.com/en-EU/home/";
        String fromOutboundFlight = "Bologna, Italy";
        String toOutboundFlight = "Eindhoven, Netherlands";
        String dateOutboundFlight = getCurrentDayPlusSomeDaysWithDateTimeFormat(3);

        String fromInboundFlight = "Amsterdam (Schiphol), Netherlands";
        String toInboundFlight = "Casablanca, Morocco";
        String dateInboundFlight = getCurrentDayPlusSomeDaysWithDateTimeFormat(9);

        driver.get(url);
        ignoreCookieDiv(driver, 5);  /* After document complete - page reloads for this reason need waits */
        MainPage main = new MainPage(driver);
        MultipleFormPage multipleForm = main.addMultipleDestinations();
        ignoreCookieDiv(driver, 5);  /* After document complete - page reloads for this reason need waits */
        multipleForm.setOutboundFlight(fromOutboundFlight, toOutboundFlight, dateOutboundFlight);
        multipleForm.setInboundFlight(fromInboundFlight, toInboundFlight, dateInboundFlight);
        MultipleFlightPage multipleFlight = new MultipleFlightPage(multipleForm.runSearch());
        multipleFlight.selectOutboundFligh();
        multipleFlight.selectInboundFlight();
        int amount = multipleFlight.getTotalAmount();
        assertTrue(amount != 0);
    }
}
