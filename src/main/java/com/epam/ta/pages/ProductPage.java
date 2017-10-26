package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends AbstractPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//th[@data-product-class='B']")
    public WebElement product;

    @FindBy(xpath = "//div[@class='grand-total__price-container']//div[@class='back']")
    public WebElement totalPrice;


    public void selectPlusPackage() {
        product.click();
    }

    public float getPriceWithPlusPackage() {
        waitElementToBeClickable(driver, totalPrice, 20);
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
