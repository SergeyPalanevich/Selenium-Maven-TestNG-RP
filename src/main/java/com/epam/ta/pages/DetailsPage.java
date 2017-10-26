package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends AbstractPage {
    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='booking-price-breakdown']")
    public WebElement divBookingPriceBreakdown;

    @FindBy(xpath = "//div[@class='details-list']//div[@class='amount']")
    public WebElement totalSum;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']")
    public WebElement totalGreenPanel;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']//div[@class='front']")
    public WebElement paymentAmount;


    public float getTotalSum() {
        waitElementToBeClickable(driver, divBookingPriceBreakdown, 20);
        moveToMyElement(driver, divBookingPriceBreakdown);
        waitElementToBeClickable(driver, totalSum, 20);
        waitForJSLoadComplete();
        return getPriceFromString(totalSum.getText());
    }

    public float getPaymentAmount() {
        waitElementToBeClickable(driver, totalGreenPanel, 20);
        moveToMyElement(driver, totalGreenPanel);
        waitElementToBeClickable(driver, paymentAmount, 20);
        waitForJSLoadComplete();
        return getPriceFromString(paymentAmount.getText());
    }
}
