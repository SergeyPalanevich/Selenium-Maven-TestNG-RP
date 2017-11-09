package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MultipleFlightPage extends BasePage {

    public MultipleFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='flight outbound']//div[@class='day day-with-availability']")
    public List<Element> flightOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='day day-with-availability']")
    public List<Element> flightInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight outbound']//button[@class='flight-result-button']")
    public List<Element> priceOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//button[@class='flight-result-button']")
    public List<Element> priceInboundDaysWithAvailability;

    @FindBy(xpath = "//div[@class='HV-gs-type-c--bp0']")
    public Element inboundSection;

    @FindBy(xpath = "//div[@class='grand-total__price-container']//div[@class='back']")
    public Element totalPrice;

    public void selectOutboundFlight() {

        if (isElementPresent("//section[@class='flight outbound']//div[@class='day day-with-availability is-selected']")){
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

        if (isElementPresent("//section[@class='flight inbound']//div[@class='day day-with-availability is-selected']")) {
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
