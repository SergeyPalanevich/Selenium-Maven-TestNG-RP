package com.epam.framework.features.transavia.tests;

import com.epam.framework.features.transavia.business_objects.Booking;
import com.epam.framework.features.transavia.pages.BookingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.framework.features.transavia.business_objects.factory.StaticMethodsFactory.createBooking;
import static com.epam.framework.features.transavia.services.AccountService.loginToAccount;
import static org.testng.Assert.assertEquals;

public class TimeArrivalTest extends BaseTest {

    private static final String FLIGHT_NUMBER = "MF8C9R";
    private static final String LAST_NAME = "kukharau";
    private static final String FLIGHT_DATE = "9 June 2016";
    private static final String ARRIVAL_TIME = "2016-06-09 23:35";
    private BookingPage bookingPage;
    private Booking booking;

    @BeforeMethod
    public void preConditionSetup(){
        booking = createBooking(FLIGHT_NUMBER, LAST_NAME, FLIGHT_DATE);
    }

    @Test(description = "This TC check arrival time ")
    public void loginToAccAndCheckTimeArrive() {
        bookingPage = loginToAccount(driver, booking);
        assertEquals(bookingPage.getTimeArrival(), ARRIVAL_TIME);
    }
}
