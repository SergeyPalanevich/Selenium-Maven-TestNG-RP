package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helper.Waiters.waitDocumentIsReady;
import static helper.Waiters.waitElementToBeClickable;

public class LoginPage extends PageObject {

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
        waitDocumentIsReady(driver);
        waitElementToBeClickable(driver, flightNumberField, 20);
        flightNumberField.sendKeys(flightNumber);
        lastNameField.sendKeys(lastName);
        flightDateField.sendKeys(flightDate);
    }

    public BookingPage viewBooking() {
        waitDocumentIsReady(driver);
        flightDateField.sendKeys(Keys.ENTER);
        return new BookingPage(driver);
    }
}
