package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import com.epam.framework.features.transavia.business_objects.MultiTrip;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MultipleFormPage extends BasePage {

    protected MultipleFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "openJawRouteSelection_DepartureStationOutbound-input")
    public Element fieldFromOutboundFlight;

    @FindBy(xpath = "//ol/li[1]")
    public Element firstValueFromOutboundFlight;

    @FindBy(id = "openJawRouteSelection_ArrivalStationOutbound-input")
    public Element fieldToOutboundFlight;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public Element firstValueToOutboundFlight;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public Element fieldDateOutboundFlight;

    @FindBy(id = "openJawRouteSelection_DepartureStationInbound-input")
    public Element fieldFromInboundFlight;

    @FindBy(xpath = "//ol/li[1]")
    public Element firstValueFromInboundFlight;

    @FindBy(id = "openJawRouteSelection_ArrivalStationInbound-input")
    public Element fieldToInboundFlight;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public Element firstValueToInboundFlight;

    @FindBy(id = "dateSelection_InboundDate-datepicker")
    public Element fieldDateInboundFlight;

    @FindBy(xpath = "//*[@id='flights']//button[@class='button button-primary' and @type='submit']")
    public Element buttonSearch;

    public void setOutboundFlight(MultiTrip multiTrip) {
        fieldFromOutboundFlight.sendKeys(multiTrip.getDepatureAirportFirst());
        firstValueFromOutboundFlight.click();
        fieldToOutboundFlight.sendKeys(multiTrip.getArrivalAirportFirst());
        firstValueToOutboundFlight.click();
        fieldDateOutboundFlight.sendKeys(multiTrip.getDateFlightFirst());
    }

    public void setInboundFlight(MultiTrip multiTrip) {
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
