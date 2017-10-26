package com.epam.ta.tests;

import com.epam.ta.pages.ErrorPage;
import com.epam.ta.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test8ErrorPage extends BaseTest {
    private static final String DEPATURE_AIRPORT = "Dubai";
    private static final String ARRIVAL_AIRPORT = "Agadir, Morocco";
    private static final String ERROR_MESSAGE = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco."
            + " However, we do fly from Dubai, United Arab Emirates to other destinations."
            + " Please change your destination and try again.";
    private HomePage main;

    @Test(description = "This TC check the error message")
    public void checkErrorMessage() {
        main = new HomePage(driver);
        main.fillFromField(DEPATURE_AIRPORT);
        main.fillToField(ARRIVAL_AIRPORT);
        ErrorPage errorPage = new ErrorPage(main.runSearch());
        assertEquals(errorPage.getError(), ERROR_MESSAGE);
    }
}
