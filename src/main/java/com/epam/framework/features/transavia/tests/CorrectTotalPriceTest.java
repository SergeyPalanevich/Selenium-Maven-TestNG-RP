package com.epam.framework.features.transavia.tests;

import com.epam.framework.features.transavia.business_objects.Trip;
import com.epam.framework.features.transavia.pages.BookFlightPage;
import com.epam.framework.features.transavia.pages.HomePage;
import com.epam.framework.features.transavia.pages.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.framework.features.transavia.business_objects.factory.StaticMethods.createTrip;
import static org.testng.Assert.assertTrue;

public class CorrectTotalPriceTest extends BaseTest {

    private static final String DEPATURE_AIRPORT = "Madrid";
    private static final String ARRIVAL_AIRPORT = "Paris";
    private float priceOutboundAfterRegex;
    private float priceInboundAfterRegex;
    private float totalPrice;
    private HomePage home;
    private BookFlightPage book;
    private ProductPage product;
    private Trip trip;

    @BeforeMethod
    public void preConditionSetup(){
        trip = createTrip(DEPATURE_AIRPORT, ARRIVAL_AIRPORT);
    }

    @Test(description = "This TC check total price for selected flights")
    public void checkTotalPriceSelectedFlights() {
        home = new HomePage(driver);
        home.fillForm(trip);
        book = home.setWhoWillBeTravelling();
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