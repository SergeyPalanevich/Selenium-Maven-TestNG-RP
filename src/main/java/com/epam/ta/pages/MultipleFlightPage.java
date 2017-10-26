package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.ta.helpers.Waiters.doSleep;

public class MultipleFlightPage extends AbstractPage {

    public MultipleFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='flight outbound']//div[@class='day day-with-availability']//h5")
    public List<WebElement> flightOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='day day-with-availability']")
    public List<WebElement> flightInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight outbound']//button[@class='flight-result-button']")
    public List<WebElement> priceOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//button[@class='flight-result-button']")
    public List<WebElement> priceInboundDaysWithAvailability;

    @FindBy(xpath = "//div[@class='HV-gs-type-c--bp0']")
    public WebElement inboundSection;

    @FindBy(xpath = "//div[@class='grand-total__price-container']//div[@class='back']")
    public WebElement totalPrice;

    public void selectOutboundFlight() {
        doSleep(1500);
        if (priceOutboundDaysWithAvailability.size() > 0) {
            waitElementToBeClickable(driver, priceOutboundDaysWithAvailability.get(0), 10);
            priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            waitElementToBeClickable(driver, flightOutboundDaysWithAvailability.get(0), 10);
            flightOutboundDaysWithAvailability.get(0).click(); // select first Out flight
            waitForJSLoadComplete();
            waitElementToBeClickable(driver, priceOutboundDaysWithAvailability.get(0), 10);
            priceOutboundDaysWithAvailability.get(0).click(); //click on first price
            waitForJSLoadComplete();
        }
    }

    public void selectInboundFlight() {
        doSleep(1500);
        if (priceInboundDaysWithAvailability.size() > 0) {
            new Actions(driver).moveToElement(inboundSection).perform();
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0), 10);
            priceInboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            new Actions(driver).moveToElement(inboundSection).perform();
            flightInboundDaysWithAvailability.get(0).click(); // select first Out flight
            waitForJSLoadComplete();
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0), 10);
            priceInboundDaysWithAvailability.get(0).click(); //click on first price
        }
    }

    public float getTotalAmount() {
        waitForJSLoadComplete();
        waitElementToBeClickable(driver, totalPrice, 10);
        return getPriceFromString(totalPrice.getText());
    }
}
