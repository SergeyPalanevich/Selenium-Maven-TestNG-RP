package com.epam.ta.pages;

import com.epam.ta.decorator.CustomWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleFormPage extends AbstractPage {

    protected MultipleFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "openJawRouteSelection_DepartureStationOutbound-input")
    public CustomWebElement fieldFromOutboundFlight;

    @FindBy(xpath = "//ol/li[1]")
    public WebElement firstValueFromOutboundFlight;

    @FindBy(id = "openJawRouteSelection_ArrivalStationOutbound-input")
    public CustomWebElement fieldToOutboundFlight;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public WebElement firstValueToOutboundFlight;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public CustomWebElement fieldDateOutboundFlight;

    @FindBy(id = "openJawRouteSelection_DepartureStationInbound-input")
    public CustomWebElement fieldFromInboundFlight;

    @FindBy(xpath = "//ol/li[1]")
    public WebElement firstValueFromInboundFlight;

    @FindBy(id = "openJawRouteSelection_ArrivalStationInbound-input")
    public CustomWebElement fieldToInboundFlight;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public WebElement firstValueToInboundFlight;

    @FindBy(id = "dateSelection_InboundDate-datepicker")
    public CustomWebElement fieldDateInboundFlight;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/section/div[3]/div/button[2]")
    public WebElement buttonSearch;

    public void setOutboundFlight(String fromOutboundFlight, String toOutboundFlight, String dateOutboundFlight) {
        waitElementToBeClickable(driver, fieldFromOutboundFlight);
        fieldFromOutboundFlight.sendKeys(fromOutboundFlight);
        firstValueFromOutboundFlight.click();
        fieldToOutboundFlight.sendKeys(toOutboundFlight);
        firstValueToOutboundFlight.click();
        fieldDateOutboundFlight.sendKeys(dateOutboundFlight);
    }

    public void setInboundFlight(String fromInboundFlight, String toInboundFlight, String dateInboundFlight) {
        waitElementToBeClickable(driver, fieldFromInboundFlight);
        fieldFromInboundFlight.sendKeys(fromInboundFlight);
        firstValueFromInboundFlight.click();
        fieldToInboundFlight.sendKeys(toInboundFlight);
        firstValueToInboundFlight.click();
        fieldDateInboundFlight.sendKeys(dateInboundFlight);
        h1.click(); //quit from datapicker field
    }

    public MultipleFlightPage runSearch() {
        waitElementToBeClickable(driver, buttonSearch);
        buttonSearch.click();
        return new MultipleFlightPage(driver);
    }
}
