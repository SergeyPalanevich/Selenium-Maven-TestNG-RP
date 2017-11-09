package com.epam.framework.features.transavia.services;

import com.epam.framework.features.transavia.business_objects.Booking;
import com.epam.framework.features.transavia.pages.BookingPage;
import com.epam.framework.features.transavia.pages.HomePage;
import com.epam.framework.features.transavia.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Account {
    public static BookingPage loginToAccount(WebDriver driver, Booking booking){
        HomePage home = new HomePage(driver);
        LoginPage loginPage = home.goToLoginPage();
        loginPage.setCredentials(booking);
        BookingPage bookingPage = loginPage.viewBooking();
        return bookingPage;
    }
}
