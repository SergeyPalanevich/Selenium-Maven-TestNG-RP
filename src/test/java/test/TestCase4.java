package test;

import static helper.Helpers.getPriceFromString;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.DetailsPage;
import pages.LoginPage;
import pages.MainPage;

public class TestCase4 extends BaseTest {
    private MainPage main;
    private LoginPage loginPage;
    private BookingPage booking;
    private DetailsPage details;
    private int totalSum;
    private int paymentAmount;
    private WebDriver driver;

    @Test
    public void comparePriceQquality() {
        String url = "https://www.transavia.com/en-EU/home/";
        String flightNumber = "MF8C9R";
        String lastName = "kukharau";
        String flightDate = "9 June 2016";
        String h1Text = "Booking details";
        driver = getChromeDriver();
        driver.get(url);
        main = new MainPage(driver);
        loginPage = main.goToLoginPage();
        loginPage.setCredentials(flightNumber, lastName, flightDate);
        booking = loginPage.viewBooking();
        details = booking.goToBookingDetails();
        assertEquals(details.h1.getText(), h1Text);
        totalSum = getPriceFromString(details.getTotalSum());
        paymentAmount = getPriceFromString(details.getPaymentAmount());
        assertEquals(totalSum, paymentAmount);
    }

    @AfterTest
    public void terrDown() {
        driver.close();
    }
}
