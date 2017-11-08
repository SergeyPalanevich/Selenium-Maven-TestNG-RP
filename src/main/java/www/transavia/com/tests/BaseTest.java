package www.transavia.com.tests;

import com.epam.core.exeptions.NoSuchWebDriverExeption;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.epam.core.drivers.DriverManager.*;
import static com.epam.core.drivers.DriverTypes.CHROME;

public class BaseTest {
    private static final String URL = "https://www.transavia.com/en-EU/home/";
    public static WebDriver driver;

    @BeforeClass()
    public void setUp() throws NoSuchWebDriverExeption {
        driver = getDriver(CHROME);
        driver.get(URL);
        driver = setCookie(driver);
    }

    @AfterClass()
    public void cleanUp(){
        closeDriver();
    }
}
