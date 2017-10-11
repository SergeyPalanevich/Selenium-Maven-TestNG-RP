import static helper.MyDateFormat.currentDatePlusDays;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.concurrent.TimeUnit;

public class Test1 {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void prepare(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe" );
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
    public void checkFromField(){
        String criteria = "Palma de Mallorca, Spain";
        mainPage.fieldFrom.sendKeys(criteria);
        assertEquals( driver.findElement(By.xpath("//ol[@class='results']")).isDisplayed(), true);
        driver.findElement(By.xpath("//ol/li[1]")).click(); //select first element from drop-down
        assertEquals(driver.findElement(By.xpath("//div[@class='container']/span[text() = '" + criteria + "']")).isEnabled(), true);
    }

    @Test(priority = 3)
    public void checkToField(){
        String criteria = "Munich, Germany";
        mainPage.fieldTo.sendKeys(criteria);
        assertEquals( driver.findElement(By.xpath("//ol[@class='results']")).isDisplayed(), true);
        driver.findElement(By.xpath("//ol/li/ol/li[1]")).click(); //select first element from drop-down
        assertEquals(driver.findElement(By.xpath("//div[@class='container']/span[text() = '" + criteria + "']")).isEnabled(), true);
    }

    @Test(priority = 4)
    public void checkDatepickerDepart(){
        mainPage.datepickerDepart.click();
        assertEquals(driver.findElement(By.id("ui-datepicker-div")).isEnabled(), true);
        mainPage.fieldOtboundDate.clear();
        mainPage.fieldOtboundDate.sendKeys(currentDatePlusDays(2));
    }

    @Test(priority = 5)
    public void uncheckReturnOn(){
        String placeholder = "Single flight";
        mainPage.labelReturnOn.click();
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        assertEquals(mainPage.fieldIsReturnDate.getAttribute("placeholder"), placeholder);
    }

    @Test(priority = 6)
    public void checkCountOfPassengers(){
        String countPassengers = "1 Adult";
        mainPage.fieldBookingPassengers.click();
        assertEquals(driver.findElement(By.xpath("//div[@class='passengers']")).isEnabled(), true);
        mainPage.buttonSavePassengers.click();
        assertEquals(driver.findElement(By.xpath("//div[@class='passengers-input-container']/div[text()='" +countPassengers + "']")).isEnabled(), true);
    }

    @Test(priority = 7)
    public void serachFlights(){
        mainPage.searchButton.click();
        assertEquals(driver.findElement(By.xpath("//span[@class='price']")).isEnabled(), true);
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}