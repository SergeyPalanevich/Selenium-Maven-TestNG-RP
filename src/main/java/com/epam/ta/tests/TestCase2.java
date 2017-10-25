package com.epam.ta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.epam.ta.pages.BookFlightPage;
import com.epam.ta.pages.MainPage;
import com.epam.ta.pages.ProductPage;

import static com.epam.ta.drivers.MyDriver.getChromeDriver;
import static org.testng.Assert.assertTrue;

public class TestCase2 {

    private float priceOutboundAfterRegex;
    private float priceInboundAfterRegex;
    private float totalPrice;
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


    @AfterMethod
    public void terrDown() {
        driver.close();
    }
}