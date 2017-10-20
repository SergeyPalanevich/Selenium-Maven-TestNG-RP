package pages;

import static helper.Helpers.moveToMyElement;
import static helper.Waiters.waitElementToBeClickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends PageObject {
    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement h1;

    @FindBy(xpath = "//div[@class='booking-price-breakdown']")
    public WebElement divBookingPriceBreakdown;

    @FindBy(xpath = "//div[@class='details-list']//div[@class='amount']")
    public WebElement totalSum;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']")
    public WebElement totalGreenPanel;

    @FindBy(xpath = "//div[@class='panel_section panel_section--green']//div[@class='front']")
    public WebElement paymentAmount;


    public String getTotalSum() {
        moveToMyElement(driver, divBookingPriceBreakdown);
        waitElementToBeClickable(driver, totalSum, 20);
        return totalSum.getText();
    }

    public String getPaymentAmount() {
        moveToMyElement(driver, totalGreenPanel);
        waitElementToBeClickable(driver, paymentAmount, 20);
        return paymentAmount.getText();
    }
}
