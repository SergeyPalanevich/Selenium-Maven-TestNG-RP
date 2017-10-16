package test;

import static helper.Helpers.getPriceFromString;
import static helper.Waiters.doSleep;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.BookingPage;
import pages.DetailsPage;
import pages.LoginPage;
import pages.MainPage;

public class TestCase4 extends BaseTest {

    @Test
    public void comparePriceQquality() {
        String url = "https://www.transavia.com/en-EU/home/";
        String flightNumber = "MF8C9R";
        String lastName = "kukharau";
        String flightDate = "9 June 2016";
        String h1Text = "Booking details";

        driver.get(url);
        doSleep(2000); /* After document complete - page reloads for this reason need waits */
        MainPage main = new MainPage(driver);
        LoginPage loginPage = main.goToLoginPage();
        loginPage.setCredentials(flightNumber, lastName, flightDate);
        BookingPage booking = loginPage.viewBooking();
        DetailsPage details = booking.goToBookingDetails();
        assertEquals(details.h1.getText(), h1Text);
        int totalSum = getPriceFromString(details.getTotalSum());
        int paymentAmount = getPriceFromString(details.getPaymentAmount());
        assertEquals(totalSum, paymentAmount);
    }

}
