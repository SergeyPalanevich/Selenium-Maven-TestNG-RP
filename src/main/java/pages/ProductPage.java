package pages;

import static helper.Helpers.getPriceFromString;
import static helper.Waiters.doSleep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends PageObject {

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

    public int getPriceWithPlusPackage() {
        doSleep(3000); // need refactoring
        return getPriceFromString(totalPrice.getText());
    }

    public Boolean isTotalPriceCorrect(int priceOutboundAfterRegex, int priceInboundAfterRegex, int totalPrice) {
        int outPrice = (priceOutboundAfterRegex * 3);
        int inPrice = (priceInboundAfterRegex * 3);
        int baggage = 42;
        int count = outPrice + inPrice + (baggage * 3);
        return count == totalPrice;
    }
}
