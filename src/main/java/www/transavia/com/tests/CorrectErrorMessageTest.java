package www.transavia.com.tests;

import org.testng.annotations.Test;
import www.transavia.com.pages.ErrorPage;
import www.transavia.com.pages.HomePage;

import static org.testng.Assert.assertEquals;

public class CorrectErrorMessageTest extends BaseTest {

    private static final String DEPATURE_AIRPORT = "Dubai";
    private static final String ARRIVAL_AIRPORT = "Agadir, Morocco";
    private static final String ERROR_MESSAGE = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco."
            + " However, we do fly from Dubai, United Arab Emirates to other destinations."
            + " Please change your destination and try again.";
    private HomePage main;

    @Test(description = "This TC check the error message")
    public void checkErrorMessage() {
        main = new HomePage(driver);
        main.fillFromField(DEPATURE_AIRPORT);
        main.fillToField(ARRIVAL_AIRPORT);
        ErrorPage errorPage = new ErrorPage(main.runSearch());
        assertEquals(errorPage.getError(), ERROR_MESSAGE);
    }
}
