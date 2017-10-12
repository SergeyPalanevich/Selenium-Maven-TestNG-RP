package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookFlightPage extends PageObject {

    public BookFlightPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement titleH1;

    @FindBy(xpath = "//section[@class=\"flight outbound\"]//span[@class=\"message\" and text()='No flights available']")
    public WebElement messageNoFlightsAvailable;

    @FindBy(xpath = "//section[@class=\"flight outbound\"]//div[@class='day day-with-availability']")
    public List<WebElement> flightOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight outbound\"]//button[@class=\"flight-result-button\"]")
    public List<WebElement> priceOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight inbound\"]//div[@class='day day-with-availability']")
    public List<WebElement> flightInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight inbound\"]//button[@class=\"flight-result-button\"]")
    public List<WebElement> priceInboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight inbound\"]//div[@class='tripadvisor-logo']")
    public WebElement inboundSection;
}
