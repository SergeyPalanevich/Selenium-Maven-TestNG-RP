package com.epam.framework.features.transavia.tests;

import com.epam.framework.features.transavia.business_objects.MultiTrip;
import com.epam.framework.features.transavia.pages.HomePage;
import com.epam.framework.features.transavia.pages.MultipleFlightPage;
import com.epam.framework.features.transavia.pages.MultipleFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.epam.framework.core.utils.DateTimeUtils.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static com.epam.framework.features.transavia.business_objects.factory.StaticMethodsFactory.createMultiTrip;
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
        ArrayList<String> array = new ArrayList();
        array.add(0, DEPATURE_AIRPORT_FIRST);
        array.add(1, ARRIVAL_AIRPORT_FIRST);
        array.add(2, DATE_FLIGHT_FIRST);
        array.add(3, DEPATURE_AIRPORT_SECOND);
        array.add(4, ARRIVAL_AIRPORT_SECOND);
        array.add(5, DATE_FLIGHT_SECOND);
        multiTrip = createMultiTrip(array);
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
