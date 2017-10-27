package com.epam.ta.tests;

import com.epam.ta.pages.BookingPage;
import com.epam.ta.pages.DetailsPage;
import com.epam.ta.pages.LoginPage;
import com.epam.ta.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CorrectTotalSumTest extends BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    private static final String FLIGHT_NUMBER = "MF8C9R";
    private static final String LAST_NAME = "kukharau";
    private static final String FLIGHT_DATE = "9 June 2016";
    private HomePage main;
    private LoginPage loginPage;
    private BookingPage booking;
    private DetailsPage details;

    @Test(description = "This TC check total sum")
    public void comparePriceQuality() {

        main = new HomePage(driver);
        loginPage = main.goToLoginPage();
        loginPage.setCredentials(FLIGHT_NUMBER, LAST_NAME, FLIGHT_DATE);
        booking = loginPage.viewBooking();
        details = booking.goToBookingDetails();
        assertEquals(details.getTotalSum(), details.getPaymentAmount());
    }
}
