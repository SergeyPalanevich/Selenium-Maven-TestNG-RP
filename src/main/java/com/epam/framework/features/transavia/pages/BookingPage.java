package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends BasePage {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[contains(text(), 'Arrival')]/following-sibling::p/em/time")
    public Element arrival;

    @FindBy(xpath = "//a[@href='/en-EU/my-transavia/booking/booking-details/']")
    public Element detailsLink;

    public String getTimeArrival() {
        return arrival.getAttribute("datetime");
    }

    public DetailsPage goToBookingDetails() {
        waitElementToBeClickable(driver, detailsLink);
        detailsLink.click();
        return new DetailsPage(driver);
    }
}
