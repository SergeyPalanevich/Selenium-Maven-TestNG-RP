package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.BookFlightPage;
import pages.MainPage;
import pages.ProductPage;

public class TestCase2 extends BaseTest {

    private int priceOutboundAfterRegex;
    private int priceInboundAfterRegex;
    private int totalPrice;
    private MainPage main;
    private BookFlightPage book;
    private ProductPage product;
    private WebDriver driver;

    @Test
    public void checkTotalPriceSelectedFlights() {
        String url = "https://www.transavia.com/en-EU/home/";
        String titleMain = "Where do you want to go?";
        String titleBook = "Book a flight";
        String airportNameFrom = "Madrid";
        String airportNameTo = "Paris";
        driver = getChromeDriver();
        driver.get(url);
        main = new MainPage(driver);
        assertTrue(main.isTitleCorrect(titleMain));
        main.setAirportFrom(airportNameFrom);
        main.setAirportTo(airportNameTo);
        book = main.setWhoWillBeTravelling();
        assertTrue(book.isTitleCorrect(titleBook));
        book.selectOutboundFligh();
        priceOutboundAfterRegex = book.getPriceOutFlight();
        book.selectInboundFlight();
        priceInboundAfterRegex = book.getPriceInFlight();
        product = book.goToNext();
        product.selectPlusPackage();
        totalPrice = product.getPriceWithPlusPackage();
        assertTrue(product.isTotalPriceCorrect(priceOutboundAfterRegex, priceInboundAfterRegex, totalPrice));
    }


    @AfterClass
    public void terrDown() {
        driver.close();
    }
}