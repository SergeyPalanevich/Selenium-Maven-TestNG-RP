package www.transavia.com.pages;

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
    public WebElement totalSum;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']")
    public WebElement totalGreenPanel;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']//div[@class='front']")
    public WebElement paymentAmount;


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
