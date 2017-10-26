package com.epam.ta.tests;

import com.epam.ta.pages.BookingPage;
import com.epam.ta.pages.LoginPage;
import com.epam.ta.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test3BookingPage extends BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    private static final String FLIGHT_NUMBER = "MF8C9R";
    private static final String LASTNAME = "kukharau";
    private static final String FLIGHT_DATE = "9 June 2016";
    private static final String ARRIVAL_TIME = "2016-06-09 23:35";
    private HomePage main;
    private LoginPage loginPage;
    private BookingPage booking;

    @Test(description = "This TC check arrival time ")
    public void loginToAccAndCheckTimeArrive() {

        main = new HomePage(driver);
        loginPage = main.goToLoginPage();
        loginPage.setCredentials(FLIGHT_NUMBER, LASTNAME, FLIGHT_DATE);
        booking = loginPage.viewBooking();
        assertEquals(booking.getTimeArrival(), ARRIVAL_TIME);
    }
}
