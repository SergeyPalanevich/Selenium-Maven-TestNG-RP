package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ErrorPage extends BasePage {

    public ErrorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='notification-message notification-inline notification-error']//p")
    public Element notificationMessage;

    public String getError() {
        waitElementToBeClickable(driver, notificationMessage);
        return notificationMessage.getText();
    }
}
