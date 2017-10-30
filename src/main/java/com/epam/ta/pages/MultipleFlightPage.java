package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MultipleFlightPage extends AbstractPage {

    public MultipleFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='flight outbound']//div[@class='day day-with-availability']")
    public List<WebElement> flightOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='day day-with-availability']")
    public List<WebElement> flightInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight outbound']//button[@class='flight-result-button']")
    public List<WebElement> priceOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//button[@class='flight-result-button']")
    public List<WebElement> priceInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='day day-with-availability is-selected']")
    public WebElement dayInboundIsSelected;

    @FindBy(xpath = "//section[@class='flight outbound']//div[@class='day day-with-availability is-selected']")
    public WebElement dayOutboundIsSelected;


    @FindBy(xpath = "//div[@class='HV-gs-type-c--bp0']")
    public WebElement inboundSection;

    @FindBy(xpath = "//div[@class='grand-total__price-container']//div[@class='back']")
    public WebElement totalPrice;

    public void selectOutboundFlight() {

    boolean success = false;

        try {
            success = dayOutboundIsSelected.isDisplayed();
        } catch (Exception e) {
        }

        if (success){
            waitElementToBeClickable(driver, priceOutboundDaysWithAvailability.get(0));
            priceOutboundDaysWithAvailability.get(0).click();
        } else {
            waitElementToBeClickable(driver, flightOutboundDaysWithAvailability.get(0));
            flightOutboundDaysWithAvailability.get(0).click();
            waitElementToBeClickable(driver, priceOutboundDaysWithAvailability.get(0));
            priceOutboundDaysWithAvailability.get(0).click();
        }
    }

    public void selectInboundFlight() {
        moveToMyElement(driver, inboundSection);
        boolean success = false;

        try {
            success = dayInboundIsSelected.isDisplayed();
        } catch (Exception e) {
        }

        if (success) {
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0));
            priceInboundDaysWithAvailability.get(0).click();
        } else {
            waitElementToBeClickable(driver, flightInboundDaysWithAvailability.get(0));
            flightInboundDaysWithAvailability.get(0).click();
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0));
            priceInboundDaysWithAvailability.get(0).click();
        }
    }

    public float getTotalAmount() {
        waitElementToBeClickable(driver, totalPrice);
        return getPriceFromString(totalPrice.getText());
    }
}
