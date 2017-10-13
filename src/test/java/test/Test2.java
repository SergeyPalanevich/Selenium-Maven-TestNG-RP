package test;

import static helper.GetPriceFromRegex.getPrice;
import static helper.MySleep.mySleep;
import static helper.TotalPrice.calcTotalPrice;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookFlightPage;
import pages.MainPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class Test2 {

    private WebDriver driver;
    private MainPage mainPage;
    private BookFlightPage bookPage;
    private ProductPage productPage;
    int priceOutboundAfterRegex;
    int priceInboundAfterRegex;
    int totalPrice;

    @BeforeClass
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void checkTitleOnMainPage() {
        String url = "https://www.transavia.com/en-EU/home/";
        String title = "Where do you want to go?";
        driver.get(url);
        mainPage = new MainPage(driver);
        assertEquals(mainPage.titleH1.getText(), title);
    }

    @Test(priority = 2)
    public void fillFromField() {
        String criteria = "Madrid";
        mainPage.fieldFrom.sendKeys(criteria);
        mainPage.firstValueFromListFrom.click();
    }

    @Test(priority = 3)
    public void fillToField() {
        String criteria = "Paris";
        mainPage.fieldTo.sendKeys(criteria);
        mainPage.firstValueFromListTo.click();
        mySleep(2000); // need refactoring
    }

    @Test(priority = 4)
    public void setWhoWillBeTravelling() throws InterruptedException {
        String title = "Book a flight";
        mainPage.fieldPassenger.click();
        (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(mainPage.buttonPlusAdults));
        // move to Waits
        mainPage.buttonPlusAdults.click();
        (new WebDriverWait(driver, 20))
            .until(ExpectedConditions.visibilityOf(mainPage.buttonPlusChildren));
        // move to Waits
        mainPage.buttonPlusChildren.click();
        mainPage.buttonSavePassengers.click();
        mainPage.searchButton.click();
        bookPage = new BookFlightPage(driver);
        assertEquals(bookPage.titleH1.getText(), title);
    }

    @Test(priority = 5)
    public void selectOutboundFligh() {
        mySleep(2000); // need refactoring

        if (bookPage.priceOutboundDaysWithAvailability.get(0).isEnabled()) {
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            bookPage.flightOutboundDaysWithAvailability.get(0).click(); // select first Out flight
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        }

        priceOutboundAfterRegex = getPrice(bookPage.priceOutboundDaysWithAvailability.get(0).getText());
    }

    @Test(priority = 6)
    public void selectInboundFlight() {

        if (bookPage.priceInboundDaysWithAvailability.get(0).isEnabled()) {
            new Actions(driver).moveToElement(bookPage.inboundSection).perform();
            mySleep(3000); // need refactoring
            bookPage.priceInboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            new Actions(driver).moveToElement(bookPage.inboundSection).perform();
            mySleep(3000); // need refactoring
            bookPage.flightOutboundDaysWithAvailability.get(0).click(); // select first Out flight
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        }
        priceInboundAfterRegex = getPrice(bookPage.priceInboundDaysWithAvailability.get(0).getText());

        mySleep(3000); // need refactoring
        bookPage.nextButton.click();
    }

    @Test(priority = 7)
    public void selectPlusPackage() {
        productPage = new ProductPage(driver);
        productPage.product.click();
        mySleep(3000); // need refactoring
        totalPrice = getPrice(productPage.totalPrice.getText()); // new page

    }

    @Test(priority = 8)
    public void checkTotalAmount() {
        assertEquals(calcTotalPrice(priceOutboundAfterRegex, priceInboundAfterRegex), totalPrice);
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        // move to BaseTest
    }
}