package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookFlightPage extends AbstractPage {

    public BookFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class=\"flight outbound\"]//div[@class='day day-with-availability']")
    public List<WebElement> flightOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight outbound\"]//button[@class=\"flight-result-button\"]")
    public List<WebElement> priceOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight inbound\"]//div[@class='day day-with-availability']")
    public List<WebElement> flightInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight inbound\"]//button[@class=\"flight-result-button\"]")
    public List<WebElement> priceInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight inbound\"]//div[@class='tripadvisor-logo']")
    public WebElement inboundSection;

    @FindBy(xpath = "//button[@name='next_button']")
    public WebElement nextButton;

    @FindBy(xpath = "//section[@class='flight outbound']//div[@class='day day-with-availability is-selected']")
    public WebElement dayOutboundIsSelected;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='day day-with-availability is-selected']")
    public WebElement dayInboundIsSelected;


    public float getPriceOutFlight() {
        waitForJSLoadComplete();
        waitElementIsPresenceOfLocated(driver, "//section[@class=\"flight outbound\"]//button[@class=\"flight-result-button\"]", 20);
        return getPriceFromString(priceOutboundDaysWithAvailability.get(0).getText());
    }

    public float getPriceInFlight() {
        waitForJSLoadComplete();
        waitElementIsPresenceOfLocated(driver, "//section[@class=\"flight inbound\"]//button[@class=\"flight-result-button\"]", 20);
        return getPriceFromString(priceInboundDaysWithAvailability.get(0).getText());
    }

    public void selectOutboundFligh() {
        waitForJSLoadComplete();
        if (dayOutboundIsSelected.isDisplayed()) {
            waitElementToBeClickable(driver, priceOutboundDaysWithAvailability.get(0), 20);
            priceOutboundDaysWithAvailability.get(0).click();
            waitForJSLoadComplete();
        } else {
            waitElementToBeClickable(driver, flightOutboundDaysWithAvailability.get(0), 20);
            flightOutboundDaysWithAvailability.get(0).click();
            waitForJSLoadComplete();
            waitElementToBeClickable(driver, priceOutboundDaysWithAvailability.get(0), 20);
            priceOutboundDaysWithAvailability.get(0).click();
            waitForJSLoadComplete();
        }
    }

    public void selectInboundFlight() {
        waitForJSLoadComplete();
        if (dayInboundIsSelected.isDisplayed()) {
            new Actions(driver).moveToElement(inboundSection).perform();
            waitForJSLoadComplete();
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0), 20);
            priceInboundDaysWithAvailability.get(0).click();
            waitForJSLoadComplete();
        } else {
            new Actions(driver).moveToElement(inboundSection).perform();
            waitForJSLoadComplete();
            waitElementToBeClickable(driver, flightInboundDaysWithAvailability.get(0), 20);
            flightInboundDaysWithAvailability.get(0).click();
            waitForJSLoadComplete();
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0), 20);
            priceInboundDaysWithAvailability.get(0).click();
        }
    }

    public ProductPage goToNext() {
        waitForJSLoadComplete();
        waitElementToBeClickable(driver, nextButton, 20);
        nextButton.click();
        return new ProductPage(driver);
    }
}
