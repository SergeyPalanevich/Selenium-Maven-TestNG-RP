package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends PageObject{

    public ProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//th[@data-product-class='B']")
    public WebElement product;

    @FindBy(xpath = "//div[@class='grand-total__price-container']//div[@class='back']")
    public WebElement totalPrice;


}
