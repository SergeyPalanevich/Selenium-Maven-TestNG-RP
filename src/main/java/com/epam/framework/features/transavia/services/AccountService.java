package com.epam.framework.features.transavia.services;

import com.epam.framework.core.drivers.DriverTypes;
import com.epam.framework.features.transavia.business_objects.Booking;
import com.epam.framework.features.transavia.pages.BookingPage;
import com.epam.framework.features.transavia.pages.DetailsPage;
import com.epam.framework.features.transavia.pages.HomePage;
import com.epam.framework.features.transavia.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static com.epam.framework.core.drivers.DriverManager.getDriver;

public class AccountService {
    public  BookingPage loginToAccount(Booking booking){
        WebDriver driver = getDriver(DriverTypes.CHROME);
        HomePage home = new HomePage(driver);
        LoginPage loginPage = home.goToLoginPage();
        loginPage.setCredentials(booking);
        BookingPage bookingPage = loginPage.viewBooking();
        return bookingPage;
    }
    public String getTimeArrival(Booking booking) {
        return loginToAccount(booking).getTimeArrival();
    }

    public Boolean comparePriceQuality(Booking booking){
        WebDriver driver = getDriver(DriverTypes.CHROME);
        HomePage home = new HomePage(driver);
        LoginPage loginPage = home.goToLoginPage();
        loginPage.setCredentials(booking);
        BookingPage bookingPage = loginPage.viewBooking();
        DetailsPage details = bookingPage.goToBookingDetails();
        return details.getTotalSum() == details.getPaymentAmount();
    }
}
