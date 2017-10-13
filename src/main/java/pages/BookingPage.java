package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends PageObject {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//p[@class='flight-info_value']//em//time)[2]")
    public WebElement arrival;

    @FindBy(xpath = "(//span[@class='nowrap'])[1]")
    public WebElement depatureAirport;

    @FindBy(xpath = "(//span[@class='nowrap'])[2]")
    public WebElement arrivalAirport;


    public String getTimeArrival() {
        return arrival.getAttribute("datetime");
    }

    public String getDepatureAirport() {
        return depatureAirport.getText();
    }

    public String getArrivalAirport() {
        return arrivalAirport.getText();
    }
}
