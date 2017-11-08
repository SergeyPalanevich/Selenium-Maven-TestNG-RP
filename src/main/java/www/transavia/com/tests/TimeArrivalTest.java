package www.transavia.com.tests;

import org.testng.annotations.Test;
import www.transavia.com.pages.BookingPage;
import www.transavia.com.pages.HomePage;
import www.transavia.com.pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class TimeArrivalTest extends BaseTest {

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
