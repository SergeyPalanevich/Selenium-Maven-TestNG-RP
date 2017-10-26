package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends AbstractPage {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//p[@class='flight-info_value']//em//time)[2]")
    public WebElement arrival;

    @FindBy(xpath = "//a[@href=\"/en-EU/my-transavia/booking/booking-details/\"]")
    public WebElement detailsLink;

    public String getTimeArrival() {
        return arrival.getAttribute("datetime");
    }

    public DetailsPage goToBookingDetails() {
        waitElementToBeClickable(driver, detailsLink, 20);
        detailsLink.click();
        return new DetailsPage(driver);
    }
}
