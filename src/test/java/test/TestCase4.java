package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.DetailsPage;
import pages.LoginPage;
import pages.MainPage;

import static driver.MyDriver.getChromeDriver;
import static helper.Helpers.getPriceFromString;
import static org.testng.Assert.assertEquals;

public class TestCase4 {
    private MainPage main;
    private LoginPage loginPage;
    private BookingPage booking;
    private DetailsPage details;
    private WebDriver driver;

    @Test
    public void comparePriceQquality() {
        String url = "https://www.transavia.com/en-EU/home/";
        String flightNumber = "MF8C9R";
        String lastName = "kukharau";
        String flightDate = "9 June 2016";
        driver = getChromeDriver();
        driver.get(url);
        main = new MainPage(driver);
        loginPage = main.goToLoginPage();
        loginPage.setCredentials(flightNumber, lastName, flightDate);
        booking = loginPage.viewBooking();
        details = booking.goToBookingDetails();
        assertEquals(details.getTotalSum(),  details.getPaymentAmount());
    }

    @AfterMethod
    public void terrDown() {
        driver.close();
    }
}
