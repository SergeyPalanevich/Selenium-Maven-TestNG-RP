package test;

import static helper.Helpers.getCurrentDayPlusSomeDaysWithDateTimeFormat;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.MainPage;

public class TestCase1 extends BaseTest{

    private MainPage mainPage;


    @Test(priority = 1)
    public void checkTitleOnMainPage() {
        String url = "https://www.transavia.com/en-EU/home/";
        driver.get(url);
        mainPage = new MainPage(driver);
        assertEquals(mainPage.titleH1.getText(), "Where do you want to go?");
    }

    @Test(priority = 2)
    public void checkFromField() {
        String criteria = "Palma de Mallorca, Spain";
        mainPage.fieldFrom.sendKeys(criteria);
        assertEquals(mainPage.result.isDisplayed(), true);
        mainPage.firstValueFromListFrom.click();
        assertEquals(
            driver.findElement(By.xpath("//div[@class='container']/span[text() = '" + criteria + "']")).isEnabled(),
            true);
    }

    @Test(priority = 3)
    public void checkToField() {
        String criteria = "Munich, Germany";
        mainPage.fieldTo.sendKeys(criteria);
        assertEquals(mainPage.result.isDisplayed(), true);
        mainPage.firstValueFromListTo.click();
        assertEquals(
            driver.findElement(By.xpath("//div[@class='container']/span[text() = '" + criteria + "']")).isEnabled(),
            true);
    }

    @Test(priority = 4)
    public void checkDatepickerDepart() {
        mainPage.datepickerDepart.click();
        assertEquals(mainPage.datepicker.isEnabled(), true);
        mainPage.fieldOtboundDate.clear();
        mainPage.fieldOtboundDate.sendKeys(getCurrentDayPlusSomeDaysWithDateTimeFormat(2));
    }

    @Test(priority = 5)
    public void uncheckReturnOn() {
        String placeholder = "Single flight";
        mainPage.labelReturnOn.click();
        assertEquals(mainPage.fieldIsReturnDate.getAttribute("placeholder"), placeholder);
    }

    @Test(priority = 6)
    public void checkCountOfPassengers() {
        String countPassengers = "1 Adult";
        mainPage.fieldBookingPassengers.click();
        assertEquals(mainPage.passengersClass.isEnabled(), true);
        mainPage.buttonSavePassengers.click();
        assertEquals(driver.findElement(
            By.xpath("//div[@class='passengers-input-container']/div[text()='" + countPassengers + "']")).isEnabled(),
                     true);
    }

    @Test(priority = 7)
    public void searchFlights() {
        mainPage.searchButton.click();
        assertEquals(mainPage.priceClass.isEnabled(), true);
    }

}