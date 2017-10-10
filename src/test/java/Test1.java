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

    @Test(priority=1)
    public void checkTitleOnMainPage(){
        driver.get("https://www.transavia.com/en-EU/home/");
        mainPage = new MainPage(driver);
        assertEquals(mainPage.h1Title.getText(), "Where do you want to go?");
    }

    @Test(priority=2)
    public void checkSelectFromDropDown(){
        mainPage.fromField.sendKeys("Palma de Mallorca");
        assertEquals(true, driver.findElement(By.xpath("//ol[@class='results']")).isDisplayed());
        driver.findElement(By.xpath("//ol/li[1]")).click();
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"desktop\"]/section/div[2]/div[1]/div[1]/div/div/div/div[2]/span[1]")).getText(), "Palma de Mallorca, Spain");
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }

}
