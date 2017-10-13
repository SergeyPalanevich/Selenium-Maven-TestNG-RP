package pages;

import static helper.ReadyState.checkPageIsReady;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject{

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
        checkPageIsReady(driver);
        (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='retrieveBookingByLastname_RecordLocator']")));
        flightNumberField.sendKeys(flightNumber);
        lastNameField.sendKeys(lastName);
        flightDateField.sendKeys(flightDate);
    }

    public BookingPage viewBooking() {
        checkPageIsReady(driver);
        flightDateField.sendKeys(Keys.ENTER);
        return new BookingPage(driver);
    }
}
