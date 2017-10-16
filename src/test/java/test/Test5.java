package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ErrorPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Test5 {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void terrDown() {
        driver.close();
    }

    @Test
    public void checkErrorMessage() {
        String url = "https://www.transavia.com/en-EU/home/";
        String from = "Dubai";
        String to = "Agadir, Morocco";
        String error = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco."
                       + " However, we do fly from Dubai, United Arab Emirates to other destinations. Please change your destination and try again.";

        driver.get(url);
        MainPage main = new MainPage(driver);
        main.fillFromField(from);
        main.fillToField(to);
        ErrorPage errorPage = new ErrorPage(main.runSearch());
        assertEquals(errorPage.getError(), error);
    }

}
