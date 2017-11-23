package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import com.epam.framework.features.transavia.business_objects.Trip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(), 'Yes, I understand')]")
    public Element cookie;

    @FindBy(id = "ui-datepicker-div")
    public Element datepicker;

    @FindBy(xpath = "//div[@class='price']")
    public Element priceClass;

    @FindBy(id = "routeSelection_DepartureStation-input")
    public Element fieldFrom;

    @FindBy(xpath = "//ol/li[1]")
    public Element firstValueFromListFrom;

    @FindBy(id = "routeSelection_ArrivalStation-input")
    public Element fieldTo;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public Element firstValueFromListTo;

    @FindBy(xpath = "//div[@data-date-picker='outbound']/div/span[@class='datepicker-trigger icon-font icon-calendar']")
    public Element datepickerDepart;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public Element fieldOtboundDate;

    @FindBy(xpath = "//label[@for='dateSelection_IsReturnFlight']")
    public Element labelReturnOn;

    @FindBy(id = "booking-passengers-input")
    public Element fieldBookingPassengers;

    @FindBy(xpath = "//button[@class='button button-secondary close']")
    public Element buttonSavePassengers;

    @FindBy(xpath = "//div[@class='HV-gc']//section[@data-package='search']//div[@class='panel_section panel_section--button']//div//button")
    public Element searchButton;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield adults']//button[@class='button button-secondary increase']")
    public Element buttonPlusAdults;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield children']//button[@class='button button-secondary increase']")
    public Element buttonPlusChildren;

    @FindBy(xpath = "//div[@class='c-passengers-form-component']")
    public Element fieldPassenger;

    @FindBy(xpath = "//a[@href='/en-EU/my-transavia/booking/booking-overview/']")
    public Element manageYourBookinglink;

    @FindBy(xpath = "//*[@id='horizontal-sub-navigation-manageyourbooking']//span[contains(text(), 'View your booking')]")
    public Element viewYourBookinglink;

    @FindBy(xpath = "//a[@href='/en-EU/book-a-flight/flights/Deeplink/?m=combi&s=false&v=false']")
    public Element linkAddMultipleDestinations;

    public LoginPage goToLoginPage() {
        waitElementToBeClickable(driver, manageYourBookinglink);
        manageYourBookinglink.click();
        waitElementToBeClickable(driver, viewYourBookinglink);
        viewYourBookinglink.click();
        return new LoginPage(driver);
    }

    public void confirmCookies() {
        waitElementToBeClickable(driver, cookie);
        cookie.click();
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

    public void fillForm(Trip trip) {
        fillFromField(trip.getDepatureAirport());
        fillToField(trip.getArrivalAirport());
    }
}
