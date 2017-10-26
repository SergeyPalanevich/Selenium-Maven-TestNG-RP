package com.epam.ta.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_RecordLocator']")
    public WebElement flightNumberField;

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_LastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_FlightDate-datepicker']")
    public WebElement flightDateField;

    public void setCredentials(String flightNumber, String lastName, String flightDate) {
        waitForJSLoadComplete();
        waitElementToBeClickable(driver, flightNumberField, 20);
        flightNumberField.sendKeys(flightNumber);
        lastNameField.sendKeys(lastName);
        flightDateField.sendKeys(flightDate);
    }

    public BookingPage viewBooking() {
        waitForJSLoadComplete();
        flightDateField.sendKeys(Keys.ENTER);
        return new BookingPage(driver);
    }
}
