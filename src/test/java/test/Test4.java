package test;

import static helper.GetPriceFromRegex.getPrice;
import static helper.MySleep.mySleep;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.DetailsPage;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Test4 {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void terrDown() {
        driver.close();
    }

    @Test
    public void comparePriceQquality() {
        String url = "https://www.transavia.com/en-EU/home/";
        String flightNumber = "MF8C9R";
        String lastname = "kukharau";
        String flightDate = "9 June 2016";
        String h1 = "Booking details";

        driver.get(url);
        mySleep(5000); /* //div[@class='cookie-consent'] - Reloads the page */
        MainPage main = new MainPage(driver);
        LoginPage loginPage = main.goToLoginPage();
        loginPage.setCredentials(flightNumber, lastname, flightDate);
        BookingPage booking = loginPage.viewBooking();
        DetailsPage details = booking.goToBookingDetails();
        assertEquals(details.h1.getText(), h1);
        int totalSum = getPrice(details.getTotalSum());
        int paymentAmount = getPrice(details.getPaymentAmount());
        assertEquals(totalSum, paymentAmount);
    }

}
