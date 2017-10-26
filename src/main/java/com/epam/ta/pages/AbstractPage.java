package com.epam.ta.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.ta.helpers.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;

public class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        waitForJSLoadComplete();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1")
    protected WebElement h1;

    protected boolean waitForJSLoadComplete() {
        WebDriverWait wait = new WebDriverWait(driver, getDriverTimeout());

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) (getJSExecutor(driver)).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (getJSExecutor(driver)).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        boolean jQuery = wait.until(jQueryLoad);
        boolean js = wait.until(jsLoad);
        return jQuery && js;
    }

    protected float getPriceFromString(String argStr) {
        String subString = "";
        float price;
        Pattern p1 = Pattern.compile("[€|Ç].\\d*.\\d*");
        Matcher m = p1.matcher(argStr);
        while (m.find()) {
            subString = argStr.substring(m.start(0));
        }
        String numberPart = subString.replaceAll("[^0-9.]", "");
        price = Float.valueOf(numberPart);
        return price;
    }

    protected void waitElementToBeClickable(WebDriver driver, WebElement element, int time) {
        (new WebDriverWait(driver, time))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected long getDriverTimeout() {
        return 20;
    }

    protected JavascriptExecutor getJSExecutor(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    protected void moveToMyElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }


}
