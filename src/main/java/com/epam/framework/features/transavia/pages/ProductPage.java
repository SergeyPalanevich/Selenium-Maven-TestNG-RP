package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//th[@data-product-class='B']")
    public Element product;

    @FindBy(xpath = "//div[@class='grand-total__price-container']//div[@class='back']")
    public Element totalPrice;


    public void selectPlusPackage() {
        waitElementToBeClickable(driver, product);
        product.click();
    }

    public float getPriceWithPlusPackage() {
        waitElementIsPresenceOfLocated(driver, "//div[@class='grand-total__price-container']//div[@class='back']");
        return getPriceFromString(totalPrice.getText());
    }

    public Boolean isTotalPriceCorrect(float priceOutboundAfterRegex, float priceInboundAfterRegex, float totalPrice) {
        float outPrice = (priceOutboundAfterRegex * 3);
        float inPrice = (priceInboundAfterRegex * 3);
        float baggage = 42;
        float count = outPrice + inPrice + (baggage * 3);
        return count == totalPrice;
    }
}
