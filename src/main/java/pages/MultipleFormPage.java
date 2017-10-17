package pages;

import static helper.Waiters.doSleep;
import static helper.Waiters.waitElementToBeClickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleFormPage extends PageObject {

    protected MultipleFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement h1;

    @FindBy(id = "openJawRouteSelection_DepartureStationOutbound-input")
    public WebElement fieldFromOutboundFlight;

    @FindBy(xpath = "//ol/li[1]")
    public WebElement firstValueFromOutboundFlight;

    @FindBy(id = "openJawRouteSelection_ArrivalStationOutbound-input")
    public WebElement fieldToOutboundFlight;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public WebElement firstValueToOutboundFlight;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public WebElement fieldDateOutboundFlight;

    @FindBy(id = "openJawRouteSelection_DepartureStationInbound-input")
    public WebElement fieldFromInboundFlight;

    @FindBy(xpath = "//ol/li[1]")
    public WebElement firstValueFromInboundFlight;

    @FindBy(id = "openJawRouteSelection_ArrivalStationInbound-input")
    public WebElement fieldToInboundFlight;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public WebElement firstValueToInboundFlight;

    @FindBy(id = "dateSelection_InboundDate-datepicker")
    public WebElement fieldDateInboundFlight;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/section/div[3]/div/button[2]")
    public WebElement buttonSearch;

    public void setOutboundFlight(String fromOutboundFlight, String toOutboundFlight, String dateOutboundFlight) {
        doSleep(5000); /* After document complete - page reloads for this reason need waits */
        waitElementToBeClickable(driver, fieldFromOutboundFlight, 10);
        fieldFromOutboundFlight.sendKeys(fromOutboundFlight);
        firstValueFromOutboundFlight.click();
        fieldToOutboundFlight.sendKeys(toOutboundFlight);
        firstValueToOutboundFlight.click();
        fieldDateOutboundFlight.clear();
        fieldDateOutboundFlight.sendKeys(dateOutboundFlight);
    }

    public void setInboundFlight(String fromInboundFlight, String toInboundFlight, String dateInboundFlight) {
        waitElementToBeClickable(driver, fieldFromInboundFlight, 10);
        fieldFromInboundFlight.sendKeys(fromInboundFlight);
        firstValueFromInboundFlight.click();
        fieldToInboundFlight.sendKeys(toInboundFlight);
        firstValueToInboundFlight.click();
        fieldDateInboundFlight.clear();
        fieldDateInboundFlight.sendKeys(dateInboundFlight);
        h1.click(); //quit from datapicker field
    }

    public MultipleFlightPage runSearch() {
        waitElementToBeClickable(driver, buttonSearch, 20);
        buttonSearch.click();
        return new MultipleFlightPage(driver);
    }
}
