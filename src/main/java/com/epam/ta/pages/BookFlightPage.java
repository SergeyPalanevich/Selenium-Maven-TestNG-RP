package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.ta.helpers.Waiters.doSleep;

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


    public float getPriceOutFlight() {
        waitElementToBeClickable(driver, priceOutboundDaysWithAvailability.get(0), 20);
        return getPriceFromString(priceOutboundDaysWithAvailability.get(0).getText());
    }

    public float getPriceInFlight() {
        waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0), 20);
        return getPriceFromString(priceInboundDaysWithAvailability.get(0).getText());
    }

    public void selectOutboundFligh() {
        doSleep(2000); // need refactoring
        if (priceOutboundDaysWithAvailability.size() > 0) {
            priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            doSleep(2000); // need refactoring
            flightOutboundDaysWithAvailability.get(0).click(); // select first Out flight
            priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        }
    }

    public void selectInboundFlight() {
        if (priceInboundDaysWithAvailability.size() > 0) {
            new Actions(driver).moveToElement(inboundSection).perform();
            doSleep(3000); // need refactoring //waitElementToBeClickable
            priceInboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            new Actions(driver).moveToElement(inboundSection).perform();
            doSleep(3000); // need refactoring
            flightInboundDaysWithAvailability.get(0).click(); // select first Out flight
            priceInboundDaysWithAvailability.get(0).click(); //click on first price
        }
    }

    public ProductPage goToNext() {
        doSleep(3000); // need refactoring
        nextButton.click();
        return new ProductPage(driver);
    }
}
