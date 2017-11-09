package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import com.epam.framework.features.transavia.business_objects.Booking;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_RecordLocator']")
    public Element flightNumberField;

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_LastName']")
    public Element lastNameField;

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_FlightDate-datepicker']")
    public WebElement flightDateField; // in this case we use sendKeys(Keys.ENTER) for this reason we need use basic WebElement without clear()

    public void setCredentials(Booking booking) {
        waitElementToBeClickable(driver, flightNumberField);
        flightNumberField.sendKeys(booking.getFlightNumber());
        lastNameField.sendKeys(booking.getLastName());
        waitElementToBeClickable(driver, flightDateField);
        flightDateField.sendKeys(booking.getFlightDate());
    }

    public BookingPage viewBooking() {
        waitElementToBeClickable(driver, flightDateField);
        flightDateField.sendKeys(Keys.ENTER); // in this case we use sendKeys(Keys.ENTER) for this reason we need use basic WebElement without clear()
        return new BookingPage(driver);
    }
}
