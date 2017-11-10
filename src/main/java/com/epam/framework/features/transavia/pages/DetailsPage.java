package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends BasePage {
    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='booking-price-breakdown']")
    public WebElement divBookingPriceBreakdown;

    @FindBy(xpath = "//div[@class='details-list']//div[@class='amount']")
    public Element totalSum;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']")
    public WebElement totalGreenPanel;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']//div[@class='front']")
    public Element paymentAmount;


    public float getTotalSum() {
        waitElementToBeClickable(driver, divBookingPriceBreakdown);
        moveToMyElement(driver, divBookingPriceBreakdown);
        waitElementToBeClickable(driver, totalSum);
        waitForJSLoadComplete();
        return getPriceFromString(totalSum.getText());
    }

    public float getPaymentAmount() {
        waitElementToBeClickable(driver, totalGreenPanel);
        moveToMyElement(driver, totalGreenPanel);
        waitElementToBeClickable(driver, paymentAmount);
        waitForJSLoadComplete();
        return getPriceFromString(paymentAmount.getText());
    }
}
