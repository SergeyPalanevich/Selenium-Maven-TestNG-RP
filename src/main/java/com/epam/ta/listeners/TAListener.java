package com.epam.ta.listeners;

import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.epam.ta.tests.BaseTest.driver;
import static com.epam.ta.utilities.MakeScreenshot.getScreenFile;

public class TAListener implements ITestListener {
    private final String START = "Test suite has been started!";
    private final String RUNNING = " is running";
    private final String SUCCESS = " is SUCCESS";
    private final String FAILED = "is FAILED";
    private final String SKIPPED = "has been skipped";
    private final String TEST = "Test: ";
    private final String FINISH = "Test suite finished!";
    private static final Logger LOGGER = Logger.getLogger(TAListener.class);
    private final DateFormat FORMATTER = new SimpleDateFormat("mm-dd-yyyy HH:mm:ss:SSS");

    public void onTestStart(ITestResult result) {
        LOGGER.info(TEST + result.getMethod().getMethodName() + RUNNING + " at: " + FORMATTER.format(result.getStartMillis()));
    }

    public void onTestSuccess(ITestResult result) {
        LOGGER.info(TEST + result.getMethod().getMethodName() + " - " + SUCCESS);
    }


    public void onTestFailure(ITestResult result) {
        LOGGER.info(TEST + result.getMethod().getMethodName() + " - " + FAILED);
        ReportPortalMessage message = null;
        try {
            message = new ReportPortalMessage(getScreenFile(driver), "Screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info(message);

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
