package com.epam.ta.pages;

import com.epam.ta.decorator.CustomWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ui-datepicker-div")
    public WebElement datepicker;

    @FindBy(xpath = "//div[@class='price']")
    public WebElement priceClass;

    @FindBy(id = "routeSelection_DepartureStation-input")
    public CustomWebElement fieldFrom;

    @FindBy(xpath = "//ol/li[1]")
    public WebElement firstValueFromListFrom;

    @FindBy(id = "routeSelection_ArrivalStation-input")
    public CustomWebElement fieldTo;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public WebElement firstValueFromListTo;

    @FindBy(xpath = "//div[@data-date-picker='outbound']/div/span[@class='datepicker-trigger icon-font icon-calendar']")
    public WebElement datepickerDepart;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public CustomWebElement fieldOtboundDate;

    @FindBy(xpath = "//label[@for='dateSelection_IsReturnFlight']")
    public WebElement labelReturnOn;

    @FindBy(id = "booking-passengers-input")
    public CustomWebElement fieldBookingPassengers;

    @FindBy(xpath = "//button[@class='button button-secondary close']")
    public WebElement buttonSavePassengers;

    @FindBy(xpath = "//*[@id='desktop']/section/div[3]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield adults']//button[2]")
    public WebElement buttonPlusAdults;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield children']//button[2]")
    public WebElement buttonPlusChildren;

    @FindBy(xpath = "//div[@class='c-passengers-form-component']")
    public CustomWebElement fieldPassenger;

    @FindBy(xpath = "//a[@href='/en-EU/my-transavia/booking/booking-overview/']")
    public WebElement manageYourBookinglink;

    @FindBy(xpath = "//*[@id='horizontal-sub-navigation-manageyourbooking']/div/div[2]/div/div[1]/div/ul/li[2]/a/div/span[2]")
    public WebElement viewYourBookinglink;

    @FindBy(xpath = "//a[@href='/en-EU/book-a-flight/flights/Deeplink/?m=combi&s=false&v=false']")
    public WebElement linkAddMultipleDestinations;

    public LoginPage goToLoginPage() {
        waitElementToBeClickable(driver, manageYourBookinglink);
        manageYourBookinglink.click();
        waitElementToBeClickable(driver, viewYourBookinglink);
        viewYourBookinglink.click();
        return new LoginPage(driver);
    }

    public void fillFromField(String from) {
        waitElementToBeClickable(driver, fieldFrom);
        fieldFrom.sendKeys(from);
        waitElementToBeClickable(driver, firstValueFromListFrom);
        firstValueFromListFrom.click();
    }

    public void fillToField(String to) {
        waitElementToBeClickable(driver, fieldTo);
        fieldTo.sendKeys(to);
        waitElementToBeClickable(driver, firstValueFromListTo);
        firstValueFromListTo.click();
    }

    public WebDriver runSearch() {
        waitElementToBeClickable(driver, searchButton);
        searchButton.click();
        return driver;
    }

    public MultipleFormPage addMultipleDestinations() {
        waitElementToBeClickable(driver, linkAddMultipleDestinations);
        linkAddMultipleDestinations.click();
        return new MultipleFormPage(driver);
    }

    public boolean isAirportDisplayedInFromField(String airportName) {
        String xpath = "//div[@class='container']/span[text() = '" + airportName + "']";
        return driver.findElement(By.xpath(xpath)).isEnabled();
    }

    public void setAirportFrom(String airportName) {
        waitElementToBeClickable(driver, fieldFrom);
        fieldFrom.sendKeys(airportName);
        firstValueFromListFrom.click();
    }

    public void setAirportTo(String airportName) {
        fieldTo.sendKeys(airportName);
        firstValueFromListTo.click();
    }

    public boolean isAirportDisplayedInToField(String airportName) {
        String xpath = "//div[@class='container']/span[text() = '" + airportName + "']";
        return driver.findElement(By.xpath(xpath)).isEnabled();
    }

    public void selectDatepickerDepart() {
        datepickerDepart.click();
    }

    public boolean isDatepickerDisplayed() {
        return datepicker.isEnabled();
    }

    public void setOutboundDate(String currentDayPlusSomeDaysWithDateTimeFormat) {
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
        String xpath = "//div[@class='passengers-input-container']/div[text()='" + countPassengers + "']";
        return driver.findElement(By.xpath(xpath)).isEnabled();
    }

    public boolean isPriceEnabled() {
       waitForJSLoadComplete();
       return priceClass.isEnabled();
    }

    public BookFlightPage setWhoWillBeTravelling() {
        waitElementToBeClickable(driver, fieldPassenger);
        fieldPassenger.click();
        waitElementToBeClickable(driver, buttonPlusAdults);
        buttonPlusAdults.click();
        waitElementToBeClickable(driver, buttonPlusChildren);
        buttonPlusChildren.click();
        waitElementToBeClickable(driver, buttonSavePassengers);
        buttonSavePassengers.click();
        waitElementToBeClickable(driver, searchButton);
        searchButton.click();
        return new BookFlightPage(driver);
    }
}
