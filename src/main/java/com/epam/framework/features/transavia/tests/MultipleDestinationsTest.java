package com.epam.framework.features.transavia.tests;

import com.epam.framework.features.transavia.business_objects.MultiTrip;
import com.epam.framework.features.transavia.pages.HomePage;
import com.epam.framework.features.transavia.pages.MultipleFlightPage;
import com.epam.framework.features.transavia.pages.MultipleFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.framework.core.utils.DateTimeUtils.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static org.testng.Assert.assertTrue;

public class MultipleDestinationsTest extends BaseTest {

    private static final String DEPATURE_AIRPORT_FIRST = "Bologna, Italy";
    private static final String ARRIVAL_AIRPORT_FIRST = "Eindhoven, Netherlands";
    private static final String DEPATURE_AIRPORT_SECOND = "Amsterdam (Schiphol), Netherlands";
    private static final String ARRIVAL_AIRPORT_SECOND = "Casablanca, Morocco";
    private static final String DATE_FLIGHT_FIRST = getCurrentDayPlusSomeDaysWithDateTimeFormat(3);
    private static final String DATE_FLIGHT_SECOND = getCurrentDayPlusSomeDaysWithDateTimeFormat(10);
    private HomePage main;
    private MultipleFlightPage multipleFlight;
    private MultipleFormPage multipleForm;

    private MultiTrip multiTrip;

    @BeforeMethod
    public void preConditionSetup(){
        multiTrip = new MultiTrip();
        multiTrip.setDepatureAirportFirst(DEPATURE_AIRPORT_FIRST);
        multiTrip.setArrivalAirportFirst(ARRIVAL_AIRPORT_FIRST);
        multiTrip.setDepatureAirportSecond(DEPATURE_AIRPORT_SECOND);
        multiTrip.setArrivalAirportSecond(ARRIVAL_AIRPORT_SECOND);
        multiTrip.setDateFlightFirst(DATE_FLIGHT_FIRST);
        multiTrip.setDateFlightSecond(DATE_FLIGHT_SECOND);
    }

    @Test(description = "This TC check multiple destinations")
    public void checkMultipleDestinations() {

        main = new HomePage(driver);
        multipleForm = main.addMultipleDestinations();
        multipleForm.setOutboundFlight(multiTrip);
        multipleForm.setInboundFlight(multiTrip);
        multipleFlight = multipleForm.runSearch();
        multipleFlight.selectOutboundFlight();
        multipleFlight.selectInboundFlight();
        assertTrue(multipleFlight.getTotalAmount() != 0);
    }
}
