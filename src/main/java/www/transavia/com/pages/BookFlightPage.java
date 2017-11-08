package www.transavia.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookFlightPage extends BasePage {

    public BookFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='flight outbound']//div[@class='day day-with-availability']")
    public List<WebElement> flightOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight outbound']//button[@class='flight-result-button']")
    public List<WebElement> priceOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='day day-with-availability']")
    public List<WebElement> flightInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//button[@class='flight-result-button']")
    public List<WebElement> priceInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='tripadvisor-logo']")
    public WebElement inboundSection;

    @FindBy(xpath = "//button[@name='next_button']")
    public WebElement nextButton;

    @FindBy(xpath = "//section[@class='flight outbound']//div[@class='day day-with-availability is-selected']")
    public WebElement dayOutboundIsSelected;

    @FindBy(xpath = "//section[@class='flight inbound']//div[@class='day day-with-availability is-selected']")
    public WebElement dayInboundIsSelected;


    public float getPriceOutFlight() {
        waitElementIsPresenceOfLocated(driver, "//section[@class='flight outbound']//button[@class='flight-result-button']");
        return getPriceFromString(priceOutboundDaysWithAvailability.get(0).getText());
    }

    public float getPriceInFlight() {
        waitElementIsPresenceOfLocated(driver, "//section[@class='flight inbound']//button[@class='flight-result-button']");
        return getPriceFromString(priceInboundDaysWithAvailability.get(0).getText());
    }

    public void selectOutboundFligh() {
        if (dayOutboundIsSelected.isDisplayed()) {
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
        if (dayInboundIsSelected.isDisplayed()) {
            moveToMyElement(driver, inboundSection);
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0));
            priceInboundDaysWithAvailability.get(0).click();
        } else {
            moveToMyElement(driver, inboundSection);
            waitElementToBeClickable(driver, flightInboundDaysWithAvailability.get(0));
            flightInboundDaysWithAvailability.get(0).click();
            waitElementToBeClickable(driver, priceInboundDaysWithAvailability.get(0));
            priceInboundDaysWithAvailability.get(0).click();
        }
    }

    public ProductPage goToNext() {
        waitElementToBeClickable(driver, nextButton);
        nextButton.click();
        return new ProductPage(driver);
    }
}
