package com.epam.ta.tests;

import com.epam.ta.pages.HomePage;
import com.epam.ta.pages.MultipleFlightPage;
import com.epam.ta.pages.MultipleFormPage;
import org.testng.annotations.Test;

import static com.epam.ta.helpers.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static org.testng.Assert.assertTrue;

public class Test9MultipleFlightPAge extends BaseTest {
    private static final String DEPATURE_AIRPORT_FIRST = "Bologna, Italy";
    private static final String ARRIVAL_AIRPORT_FIRST = "Eindhoven, Netherlands";
    private static final String DEPATURE_AIRPORT_SECOND = "Amsterdam (Schiphol), Netherlands";
    private static final String ARRIVAL_AIRPORT_SECOND = "Casablanca, Morocco";
    private String dateFlightFirst = getCurrentDayPlusSomeDaysWithDateTimeFormat(3);
    private String dateFlightSecond = getCurrentDayPlusSomeDaysWithDateTimeFormat(9);
    private HomePage main;
    private MultipleFlightPage multipleFlight;
    private MultipleFormPage multipleForm;

    @Test(description = "This TC check mulItiple destinations")
    public void checkMultipleDestinations() {

        main = new HomePage(driver);
        multipleForm = main.addMultipleDestinations();
        multipleForm.setOutboundFlight(DEPATURE_AIRPORT_FIRST, ARRIVAL_AIRPORT_FIRST, dateFlightFirst);
        multipleForm.setInboundFlight(DEPATURE_AIRPORT_SECOND, ARRIVAL_AIRPORT_SECOND, dateFlightSecond);
        multipleFlight = multipleForm.runSearch();
        multipleFlight.selectOutboundFlight();
        multipleFlight.selectInboundFlight();
        assertTrue(multipleFlight.getTotalAmount() != 0);
    }
}
