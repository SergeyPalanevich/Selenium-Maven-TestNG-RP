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

    public String getTimeArrival() {
        System.out.println(arrival);
        return arrival.getAttribute("datetime");
    }
}
