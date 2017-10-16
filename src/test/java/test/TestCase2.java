package test;

import static helper.Helpers.calcTotalPrice;
import static helper.Helpers.doSleep;
import static helper.Helpers.getPriceFromString;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BookFlightPage;
import pages.MainPage;
import pages.ProductPage;

public class TestCase2 extends BaseTest{


    private MainPage mainPage;
    private BookFlightPage bookPage;
    private ProductPage productPage;
    int priceOutboundAfterRegex;
    int priceInboundAfterRegex;
    int totalPrice;


    @Test(priority = 1)
    public void checkTitleOnMainPage() {
        String url = "https://www.transavia.com/en-EU/home/";
        String title = "Where do you want to go?";
        driver.get(url);
        mainPage = new MainPage(driver);
        assertEquals(mainPage.titleH1.getText(), title);
    }

    @Test(priority = 2)
    public void fillFromField() {
        String criteria = "Madrid";
        mainPage.fieldFrom.sendKeys(criteria);
        mainPage.firstValueFromListFrom.click();
    }

    @Test(priority = 3)
    public void fillToField() {
        String criteria = "Paris";
        mainPage.fieldTo.sendKeys(criteria);
        mainPage.firstValueFromListTo.click();
        doSleep(2000); // need refactoring
    }

    @Test(priority = 4)
    public void setWhoWillBeTravelling() throws InterruptedException {
        String title = "Book a flight";
        mainPage.fieldPassenger.click();
        (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(mainPage.buttonPlusAdults));
        // move to Waiters
        mainPage.buttonPlusAdults.click();
        (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(mainPage.buttonPlusChildren));
        // move to Waiters
        mainPage.buttonPlusChildren.click();
        mainPage.buttonSavePassengers.click();
        mainPage.searchButton.click();
        bookPage = new BookFlightPage(driver);
        assertEquals(bookPage.titleH1.getText(), title);
    }

    @Test(priority = 5)
    public void selectOutboundFligh() {
        doSleep(2000); // need refactoring

        if (bookPage.priceOutboundDaysWithAvailability.get(0).isEnabled()) {
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            bookPage.flightOutboundDaysWithAvailability.get(0).click(); // select first Out flight
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        }

        priceOutboundAfterRegex = getPriceFromString(bookPage.priceOutboundDaysWithAvailability.get(0).getText());
    }

    @Test(priority = 6)
    public void selectInboundFlight() {

        if (bookPage.priceInboundDaysWithAvailability.get(0).isEnabled()) {
            new Actions(driver).moveToElement(bookPage.inboundSection).perform();
            doSleep(3000); // need refactoring
            bookPage.priceInboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            new Actions(driver).moveToElement(bookPage.inboundSection).perform();
            doSleep(3000); // need refactoring
            bookPage.flightOutboundDaysWithAvailability.get(0).click(); // select first Out flight
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        }
        priceInboundAfterRegex = getPriceFromString(bookPage.priceInboundDaysWithAvailability.get(0).getText());

        doSleep(3000); // need refactoring
        bookPage.nextButton.click();
    }

    @Test(priority = 7)
    public void selectPlusPackage() {
        productPage = new ProductPage(driver);
        productPage.product.click();
        doSleep(3000); // need refactoring
        totalPrice = getPriceFromString(productPage.totalPrice.getText()); // new page

    }

    @Test(priority = 8)
    public void checkTotalAmount() {
        assertEquals(calcTotalPrice(priceOutboundAfterRegex, priceInboundAfterRegex), totalPrice);
    }

}