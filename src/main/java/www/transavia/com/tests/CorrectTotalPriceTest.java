package www.transavia.com.tests;

import org.testng.annotations.Test;
import www.transavia.com.pages.BookFlightPage;
import www.transavia.com.pages.HomePage;
import www.transavia.com.pages.ProductPage;

import static org.testng.Assert.assertTrue;

public class CorrectTotalPriceTest extends BaseTest {

    private static final String DEPATURE_AIRPORT = "Madrid";
    private static final String ARRIVAL_AIRPORT = "Paris";
    private float priceOutboundAfterRegex;
    private float priceInboundAfterRegex;
    private float totalPrice;
    private HomePage main;
    private BookFlightPage book;
    private ProductPage product;

    @Test(description = "This TC check total price for selected flights")
    public void checkTotalPriceSelectedFlights() {
        main = new HomePage(driver);
        main.setAirportFrom(DEPATURE_AIRPORT);
        main.setAirportTo(ARRIVAL_AIRPORT);
        book = main.setWhoWillBeTravelling();
        book.selectOutboundFligh();
        priceOutboundAfterRegex = book.getPriceOutFlight();
        book.selectInboundFlight();
        priceInboundAfterRegex = book.getPriceInFlight();
        product = book.goToNext();
        product.selectPlusPackage();
        totalPrice = product.getPriceWithPlusPackage();
        assertTrue(product.isTotalPriceCorrect(priceOutboundAfterRegex, priceInboundAfterRegex, totalPrice));
    }
}