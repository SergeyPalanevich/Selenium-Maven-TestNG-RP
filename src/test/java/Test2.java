import static helper.GetPriceFromRegex.getPrice;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookFlightPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Test2 {

    private WebDriver driver;
    private MainPage mainPage;
    private BookFlightPage bookPage;
    private int priceOutboundAfterRegex;
    private int priceInboundAfterRegex;

    @BeforeClass
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }// need refactoring
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // need refactoring

        if (bookPage.priceOutboundDaysWithAvailability.get(0).isDisplayed()) {
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        } else {
            bookPage.flightOutboundDaysWithAvailability.get(0).click(); // select first Out flight
            bookPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        }

        priceOutboundAfterRegex = getPrice(bookPage.priceOutboundDaysWithAvailability.get(0).getText());
    }

//    @Test(priority = 6)
//    public void selectInboundFlight() {
//
//        if (bookPage.priceInboundDaysWithAvailability.get(0).isDisplayed()) {
//            bookPage.priceInboundDaysWithAvailability.get(0).click();
//        } else {
//            bookPage.flightInboundDaysWithAvailability.get(0).click();
//            bookPage.priceInboundDaysWithAvailability.get(0).click();
//        }
//        priceInboundAfterRegex = getPrice(bookPage.priceInboundDaysWithAvailability.get(0).getText());
//    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        // move to BaseTest
    }
}

