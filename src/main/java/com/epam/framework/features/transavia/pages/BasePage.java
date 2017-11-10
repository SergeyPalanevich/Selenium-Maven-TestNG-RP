package com.epam.framework.features.transavia.pages;

import com.epam.framework.core.ui.CustomFieldDecorator;
import com.epam.framework.core.ui.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage {

    protected WebDriver driver;

    public static final long DRIVER_TIMEOUT = 25;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver),this);
        waitForJSLoadComplete();
    }

    @FindBy(xpath = "//h1")
    protected Element h1;

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

    protected void waitElementToBeClickable(WebDriver driver, WebElement element) {
        waitForJSLoadComplete();
        (new WebDriverWait(driver, getDriverTimeout()))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitElementIsPresenceOfLocated(WebDriver driver, String path) {
        waitForJSLoadComplete();
        (new WebDriverWait(driver, getDriverTimeout()))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
    }


    protected void moveToMyElement(WebDriver driver, WebElement element) {
        waitForJSLoadComplete();
        new Actions(driver).moveToElement(element).perform();
    }

    protected JavascriptExecutor getJSExecutor(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    protected long getDriverTimeout() {
        return DRIVER_TIMEOUT;
    }

    protected boolean isElementPresent(String xpath){
       return !driver.findElements(By.xpath(xpath)).isEmpty();
    }
}
