import static helper.MyWaits.waitLoadPage;
import static helper.MyWaits.waitSripts;
import static helper.MyWaits.waitUntilToBeClickable;
import static helper.MyWaits.waitUntilToBePresence;
import static helper.MyWaits.waitUntilToBeVisOfElement;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Test2 {
    private WebDriver driver;
    private MainPage mainPage;
    private String priceOutbound;

    @BeforeClass
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test(priority = 1)
    public void checkTitleOnMainPage(){
        String url = "https://www.transavia.com/en-EU/home/";
        driver.get(url);
        mainPage = new MainPage(driver);
        assertEquals(mainPage.titleH1.getText(), "Where do you want to go?"); //check title
    }

    @Test(priority = 2)
    public void fillFromField() {
        String criteria = "Madrid";
        mainPage.fieldFrom.sendKeys(criteria);
        driver.findElement(By.xpath("//ol/li[1]")).click(); //select first element from drop-down
    }

    @Test(priority = 3)
    public void fillToField() {
        String criteria = "Paris";
        mainPage.fieldTo.sendKeys(criteria);
        waitUntilToBePresence(driver, "//ol/li/ol/li[1]");
        driver.findElement(By.xpath("//ol/li/ol/li[1]")).click(); //select first element from drop-down
        waitSripts(driver);
    }

    @Test(priority = 4)
    public void setWhoWillBeTravelling() {
        mainPage.fieldBookingPassengers.click();
        waitSripts(driver);
        waitUntilToBePresence(driver, "//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/div/button[2]");
        mainPage.buttonPlusAdults.click();
        waitSripts(driver);
        waitUntilToBePresence(driver, "//*[@id='desktop']/section/div[2]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/div/button[2]");
        mainPage.buttonPlusChildren.click();
        waitSripts(driver);
        waitUntilToBePresence(driver, "//button[@class='button button-secondary close']");
        mainPage.buttonSavePassengers.click();
        waitSripts(driver);
        waitUntilToBePresence(driver, "//*[@id='desktop']/section/div[3]/div/button");
        mainPage.searchButton.click();
        waitSripts(driver);
        assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Book a flight");
    }


    @Test(priority = 5)
    public void selectOutboundFligh() {
        mainPage.flightOutboundDaysWithAvailability.get(0).click(); //clicl on first available flight
        waitSripts(driver);
        mainPage.priceOutboundDaysWithAvailability.get(0).click(); //click on first price
        waitSripts(driver);
     //   priceOutbound = mainPage.priceOutbound.get(0).getText();
        System.out.println(priceOutbound);
    }

    @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

