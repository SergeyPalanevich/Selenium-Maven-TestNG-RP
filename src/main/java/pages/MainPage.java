package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageObject{
    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement titleH1;

    @FindBy(id = "routeSelection_DepartureStation-input")
    public WebElement fieldFrom;

    @FindBy(id = "routeSelection_ArrivalStation-input")
    public WebElement fieldTo;

    @FindBy(xpath = "//div[@data-date-picker='outbound']/div/span[@class='datepicker-trigger icon-font icon-calendar']")
    public WebElement datepickerDepart;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public WebElement fieldOtboundDate;

    @FindBy(xpath = "//label[@for='dateSelection_IsReturnFlight']")
    public WebElement labelReturnOn;

    @FindBy(id ="booking-passengers-input")
    public WebElement fieldBookingPassengers;

    @FindBy(id = "dateSelection_IsReturnFlight-datepicker")
    public WebElement fieldIsReturnDate;

    @FindBy(xpath = "//button[@class='button button-secondary close']")
    public WebElement buttonSavePassengers;

    @FindBy(xpath = "//*[@id='desktop']/section/div[3]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/button[2]")
    public WebElement buttonPlusAdults;

    @FindBy(xpath = "//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/div/button[2]")
    public WebElement buttonPlusChildren;

    @FindBy(xpath = "//section[@class=\"flight outbound\"]//div[@class='day day-with-availability']")
    public List<WebElement> flightOutboundDaysWithAvailability;

    @FindBy(xpath = "//section[@class=\"flight outbound\"]//button[@class=\"flight-result-button\"]")
    public List<WebElement> priceOutboundDaysWithAvailability;


}
