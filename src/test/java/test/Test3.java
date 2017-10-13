package test;

import static helper.MySleep.mySleep;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BookingPage;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Test3 {

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
    public void LoginToAccAndCheckTimeArrive() {
        String url = "https://www.transavia.com/en-EU/home/";
        String flightNumber = "MF8C9R";
        String lastname = "kukharau";
        String flightDate = "9 June 2016";
        String arrivalTime = "2016-06-09 23:35";
        String depatureAirport = "Pisa";
        String arrivalAirport = "Amsterdam (Schiphol)";


        driver.get(url);
        mySleep(5000); /* //div[@class='cookie-consent'] - Reloads the page */
        MainPage main = new MainPage(driver);
        LoginPage loginPage = main.goToLoginPage();
        loginPage.setCredentials(flightNumber, lastname, flightDate);
        BookingPage booking = loginPage.viewBooking();
        assertEquals(booking.getTimeArrival(), arrivalTime);
        assertEquals(booking.getDepatureAirport(), depatureAirport);
        assertEquals(booking.getArrivalAirport(), arrivalAirport);

    }
}
