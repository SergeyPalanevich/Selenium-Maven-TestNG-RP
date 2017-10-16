package test;

import static helper.Helpers.doSleep;
import static helper.Waiters.ignoreCookieDiv;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.ErrorPage;
import pages.MainPage;

public class TestCase8 extends BaseTest{

    @Test
    public void checkErrorMessage() {
        String url = "https://www.transavia.com/en-EU/home/";
        String from = "Dubai";
        String to = "Agadir, Morocco";
        String error = "Unfortunately we do not fly from Dubai, United Arab Emirates to Agadir, Morocco."
                       + " However, we do fly from Dubai, United Arab Emirates to other destinations. Please change your destination and try again.";

        driver.get(url);
        doSleep(2000); /* After document complete - page reloads for this reason need waits */
        MainPage main = new MainPage(driver);
        main.fillFromField(from);
        main.fillToField(to);
        ErrorPage errorPage = new ErrorPage(main.runSearch());
        assertEquals(errorPage.getError(), error);
    }

}
