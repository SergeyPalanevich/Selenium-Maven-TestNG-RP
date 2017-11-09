package com.epam.framework.features.transavia.tests;

import com.epam.framework.core.utils.DateTimeUtils;
import com.epam.framework.features.transavia.business_objects.Trip;
import com.epam.framework.features.transavia.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.framework.features.transavia.business_objects.factory.StaticMethodsFactory.createTrip;
import static org.testng.Assert.assertTrue;

public class MainFormAndSearchTest extends BaseTest {

    private static final String DEPATURE_AIRPORT = "Palma de Mallorca, Spain";
    private static final String ARRIVAL_AIRPORT = "Munich, Germany";
    private static final String COUNT_PASSENGERS = "1 Adult";
    private HomePage home;
    private Trip trip;

    @BeforeMethod
    public void preConditionSetup(){
        trip = createTrip(DEPATURE_AIRPORT, ARRIVAL_AIRPORT);
    }

    @Test(description = "This TC check that departure airport is displayed in From field", priority = 1)
    public void checkDepartureAirportIsDisplayedInFromField() throws IOException {
        home = new HomePage(driver);
        home.fillFromField(trip.getDepatureAirport());
        assertTrue(home.isAirportDisplayedInFromField(DEPATURE_AIRPORT));
    }

    @Test(description = "This TC check that arrival airport is displayed in To field", priority = 2)
    public void checkArrivalAirportIsDisplayedInToField() {
        home.fillToField(trip.getArrivalAirport());
        assertTrue(home.isAirportDisplayedInToField(ARRIVAL_AIRPORT));
    }

    @Test(description = "This TC check that datepicker is displayed", priority = 3)
    public void checkDatepickerIsDisplayed() {
        home.selectDatepickerDepart();
        assertTrue(home.isDatepickerDisplayed());
    }

    @Test(description = "This TC check that count of passengers is displayed", priority = 4)
    public void checkCountOfPassengersIsDisplayed() {
        home.setOutboundDate(DateTimeUtils.getCurrentDayPlusSomeDaysWithDateTimeFormat(2));
        home.uncheckReturnOnCheckBox();
        home.setCountOfPassengers();
        assertTrue(home.isCountOfPassengersDisplayed(COUNT_PASSENGERS));
    }

    @Test(description = "This TC check price for single flight", priority = 5)
    public void checkPriceOfSingleFlight() {
        home.runSearch();
        assertTrue(home.isPriceEnabled());
    }
}