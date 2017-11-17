package com.epam.framework.core.listeners;

import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.epam.framework.core.drivers.DriverManager.takeScreenshot;

public class TAListener implements ITestListener {
    private static final String START = "Test suite has been started!";
    private static final String RUNNING = " is running at: ";
    private static final String SUCCESS = "- is SUCCESS";
    private static final String FAILED = "- is FAILED";
    private static final String SKIPPED = "has been skipped";
    private static final String TEST = "Test: ";
    private static final String FINISH = "Test suite finished!";
    private static final Logger LOGGER = Logger.getLogger(TAListener.class);
    public static final DateFormat FORMATTER = new SimpleDateFormat("mm-dd-yyyy HH:mm:ss:SSS");

    public void onTestStart(ITestResult result) {
        LOGGER.info(TEST + result.getMethod().getMethodName() + RUNNING + FORMATTER.format(result.getStartMillis()));
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.info(TEST + result.getMethod().getMethodName() + SUCCESS);
        File screen = takeScreenshot();
        try {
            ReportPortalMessage message = new ReportPortalMessage(screen, FORMATTER.format(result.getStartMillis()));
            LOGGER.info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onTestFailure(ITestResult result) {
        LOGGER.info(TEST + result.getMethod().getMethodName() + FAILED);
        File screen = takeScreenshot();
        try {
            ReportPortalMessage message = new ReportPortalMessage(screen, FORMATTER.format(result.getStartMillis()));
            LOGGER.info(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        LOGGER.info(TEST + result.getMethod().getMethodName() + SKIPPED);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        LOGGER.info(START);
    }

    public void onFinish(ITestContext context) {
        LOGGER.info(FINISH);
    }
}
