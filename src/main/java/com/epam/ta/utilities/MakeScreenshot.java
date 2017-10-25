package com.epam.ta.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class MakeScreenshot {

    public static File getScreenFile(WebDriver browser) {

       return ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);

    }
}
