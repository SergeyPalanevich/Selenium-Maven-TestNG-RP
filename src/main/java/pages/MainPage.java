package pages;

import static helper.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static helper.Waiters.waitElementToBeClickable;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement titleH1;

    @FindBy(xpath = "//ol[@class='results']")
    public WebElement result;

    @FindBy(id = "ui-datepicker-div")
    public WebElement datepicker;

    @FindBy(xpath = "//div[@class='passengers']")
    public WebElement passengersClass;

    @FindBy(xpath = "//div[@class='price']")
    public WebElement priceClass;

    @FindBy(id = "routeSelection_DepartureStation-input")
    public WebElement fieldFrom;

    @FindBy(xpath = "//ol/li[1]")
    public WebElement firstValueFromListFrom;

    @FindBy(id = "routeSelection_ArrivalStation-input")
    public WebElement fieldTo;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public WebElement firstValueFromListTo;

    @FindBy(xpath = "//div[@data-date-picker='outbound']/div/span[@class='datepicker-trigger icon-font icon-calendar']")
    public WebElement datepickerDepart;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public WebElement fieldOtboundDate;

    @FindBy(xpath = "//label[@for='dateSelection_IsReturnFlight']")
    public WebElement labelReturnOn;

    @FindBy(id = "booking-passengers-input")
    public WebElement fieldBookingPassengers;

    @FindBy(id = "dateSelection_IsReturnFlight-datepicker")
    public WebElement fieldIsReturnDate;

    @FindBy(xpath = "//button[@class='button button-secondary close']")
    public WebElement buttonSavePassengers;

    @FindBy(xpath = "//*[@id='desktop']/section/div[3]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield adults']//button[2]")
    public WebElement buttonPlusAdults;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield children']//button[2]")
    public WebElement buttonPlusChildren;

    @FindBy(xpath = "//div[@class='c-passengers-form-component']")
    public WebElement fieldPassenger;

    @FindBy(xpath = "//a[@href='/en-EU/my-transavia/booking/booking-overview/']")
    public WebElement manageYourBookinglink;

    @FindBy(xpath = "//*[@id='horizontal-sub-navigation-manageyourbooking']/div/div[2]/div/div[1]/div/ul/li[2]/a/div/span[2]")
    public WebElement viewYourBookinglink;


    @FindBy(xpath = "//a[@href='/en-EU/book-a-flight/flights/Deeplink/?m=combi&s=false&v=false']")
    public WebElement linkAddMultipleDestinations;

    public LoginPage goToLoginPage() {
        waitElementToBeClickable(driver, manageYourBookinglink, 20);
        manageYourBookinglink.click();
        waitElementToBeClickable(driver, viewYourBookinglink, 20);
        viewYourBookinglink.click();
        return new LoginPage(driver);
    }

    public void fillFromField(String from) {
        waitElementToBeClickable(driver, fieldFrom, 20);
        fieldFrom.sendKeys(from);
        waitElementToBeClickable(driver, firstValueFromListFrom, 20);
        firstValueFromListFrom.click();
    }

    public void fillToField(String to) {
        waitElementToBeClickable(driver, fieldTo, 20);
        fieldTo.sendKeys(to);
        waitElementToBeClickable(driver, firstValueFromListTo, 20);
        firstValueFromListTo.click();
    }

    public WebDriver runSearch() {
        waitElementToBeClickable(driver, searchButton, 20);
        searchButton.click();
        return driver;
    }

    public MultipleFormPage addMultipleDestinations() {
        waitElementToBeClickable(driver, linkAddMultipleDestinations, 20);
        linkAddMultipleDestinations.click();
        return new MultipleFormPage(driver);
    }

    public boolean isAirportDisplayedInFromField(String airportName) {
        return driver.findElement(By.xpath("//div[@class='container']/span[text() = '" + airportName + "']")).isEnabled();
    }

    public void setAirportFrom(String airportName) {
        fieldFrom.sendKeys(airportName);
        firstValueFromListFrom.click();
    }

    public void setAirportTo(String airportName) {
        fieldTo.sendKeys(airportName);
        firstValueFromListTo.click();
    }

    public boolean isAirportDisplayedInToField(String airportName) {
        return driver.findElement(By.xpath("//div[@class='container']/span[text() = '" + airportName + "']")).isEnabled();
    }

    public void selectDatepickerDepart() {
        datepickerDepart.click();
    }

    public boolean isDatepickerDisplayed() {
        return datepicker.isEnabled();
    }

    public void setOutboundDate(String currentDayPlusSomeDaysWithDateTimeFormat) {
        fieldOtboundDate.clear();
        fieldOtboundDate.sendKeys(currentDayPlusSomeDaysWithDateTimeFormat);
    }

    public void uncheckReturnOnCheckBox() {
        labelReturnOn.click();
    }

    public void setCountOfPassengers() {
        fieldBookingPassengers.click();
        buttonSavePassengers.click();
    }

    public boolean isCountOfPassengersDisplayed(String countPassengers) {
       return driver.findElement(
            By.xpath("//div[@class='passengers-input-container']/div[text()='" + countPassengers + "']")).isEnabled();
    }

    public boolean isPriceEnabled() {
        waitElementToBeClickable(driver, priceClass, 20);
        return priceClass.isEnabled();
    }

    public boolean isTitleCorrect(String title) {
        return titleH1.getText().equals(title);

    }

    public BookFlightPage setWhoWillBeTravelling() {
        fieldPassenger.click();
        waitElementToBeClickable(driver, buttonPlusAdults, 20);
        buttonPlusAdults.click();
        waitElementToBeClickable(driver, buttonPlusChildren, 20);
        buttonPlusChildren.click();
        buttonSavePassengers.click();
        searchButton.click();

        return new BookFlightPage(driver);

    }
}
