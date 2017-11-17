package com.epam.framework.features.transavia.tests;

import com.epam.framework.features.transavia.business_objects.Trip;
import com.epam.framework.features.transavia.pages.ErrorPage;
import com.epam.framework.features.transavia.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.framework.features.transavia.business_objects.factory.StaticMethodsFactory.createTrip;
import static org.testng.Assert.assertEquals;

public class CorrectErrorMessageTest extends BaseTest {

    private static final String DEPATURE_AIRPORT = "Dubai, United Arab Emirates";
    private static final String ARRIVAL_AIRPORT = "Agadir, Morocco";
    private static final String ERROR_MESSAGE = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco."
            + " However, we do fly from Dubai, United Arab Emirates to other destinations."
            + " Please change your destination and try again.";
    private HomePage home;
    private Trip trip;

    @BeforeMethod
    public void preConditionSetup(){
        trip = createTrip(DEPATURE_AIRPORT, ARRIVAL_AIRPORT);
    }

    @Test(description = "This TC check the error message")
    public void checkErrorMessage() {
        home = new HomePage(driver);
        home.fillForm(trip);
        ErrorPage errorPage = new ErrorPage(home.runSearch());
        assertEquals(errorPage.getError(), ERROR_MESSAGE);
    }
}
