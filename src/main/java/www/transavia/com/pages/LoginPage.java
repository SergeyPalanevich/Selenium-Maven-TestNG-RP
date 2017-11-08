package www.transavia.com.pages;

import com.epam.core.decorator.CustomWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_RecordLocator']")
    public CustomWebElement flightNumberField;

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_LastName']")
    public CustomWebElement lastNameField;

    @FindBy(xpath = "//input[@id='retrieveBookingByLastname_FlightDate-datepicker']")
    public WebElement flightDateField;

    public void setCredentials(String flightNumber, String lastName, String flightDate) {
        waitElementToBeClickable(driver, flightNumberField);
        flightNumberField.sendKeys(flightNumber);
        lastNameField.sendKeys(lastName);
        flightDateField.clear();
        flightDateField.sendKeys(flightDate);
    }

    public BookingPage viewBooking() {
        waitElementToBeClickable(driver, flightDateField);
        flightDateField.sendKeys(Keys.ENTER);
        return new BookingPage(driver);
    }
}
