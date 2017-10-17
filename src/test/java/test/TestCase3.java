package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.BookingPage;
import pages.LoginPage;
import pages.MainPage;

public class TestCase3 extends BaseTest {

    private MainPage main;
    private LoginPage loginPage;
    private BookingPage booking;

    @Test
    public void LoginToAccAndCheckTimeArrive() {
        String url = "https://www.transavia.com/en-EU/home/";
        String flightNumber = "MF8C9R";
        String lastname = "kukharau";
        String flightDate = "9 June 2016";
        String arrivalTime = "2016-06-09 23:35";
        String depatureAirport = "Pisa";
        String arrivalAirport = "Amsterdam (Schiphol)";

        driver.get(url);
        main = new MainPage(driver);
        loginPage = main.goToLoginPage();
        loginPage.setCredentials(flightNumber, lastname, flightDate);
        booking = loginPage.viewBooking();
        assertEquals(booking.getTimeArrival(), arrivalTime);
        assertEquals(booking.getDepatureAirport(), depatureAirport);
        assertEquals(booking.getArrivalAirport(), arrivalAirport);
    }
}
