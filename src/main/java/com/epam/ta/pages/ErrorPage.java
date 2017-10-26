package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorPage extends AbstractPage {

    public ErrorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='notification-message notification-inline notification-error']//p")
    public WebElement notificationMessage;

    public String getError() {
        waitElementToBeClickable(driver, notificationMessage, 20);
        return notificationMessage.getText();
    }
}
