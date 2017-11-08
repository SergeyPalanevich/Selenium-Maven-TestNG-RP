package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.decorator.CustomWebElement;
import com.epam.framework.features.transavia.business_objects.MultiTrip;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleFormPage extends BasePage {

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

    @FindBy(xpath = "//*[@id='flights']//button[@class='button button-primary' and @type='submit']")
    public WebElement buttonSearch;

    public void setOutboundFlight(MultiTrip multiTrip) {
        waitElementToBeClickable(driver, fieldFromOutboundFlight);
        fieldFromOutboundFlight.sendKeys(multiTrip.getDepatureAirportFirst());
        firstValueFromOutboundFlight.click();
        fieldToOutboundFlight.sendKeys(multiTrip.getArrivalAirportFirst());
        firstValueToOutboundFlight.click();
        fieldDateOutboundFlight.sendKeys(multiTrip.getDateFlightFirst());
    }

    public void setInboundFlight(MultiTrip multiTrip) {
        waitElementToBeClickable(driver, fieldFromInboundFlight);
        fieldFromInboundFlight.sendKeys(multiTrip.getDepatureAirportSecond());
        firstValueFromInboundFlight.click();
        fieldToInboundFlight.sendKeys(multiTrip.getArrivalAirportSecond());
        firstValueToInboundFlight.click();
        fieldDateInboundFlight.sendKeys(multiTrip.getDateFlightSecond());
        h1.click(); //quit from datapicker field
    }

    public MultipleFlightPage runSearch() {
        waitElementToBeClickable(driver, buttonSearch);
        buttonSearch.click();
        return new MultipleFlightPage(driver);
    }
}
