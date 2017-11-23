package com.epam.framework.core.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.epam.framework.core.drivers.DriverManager.takeScreenshot;
import static com.epam.framework.core.utils.LoggerUtils.log;

public class TAListener implements ITestListener {
    private static final String START = "Test suite has been started!";
    private static final String RUNNING = " running at: ";
    private static final String SUCCESS = "- SUCCESS";
    private static final String FAILED = "- FAILED";
    private static final String SKIPPED = "has been skipped";
    private static final String FINISH = "Test suite finished!";
    private static final DateFormat FORMATTER = new SimpleDateFormat("HH:mm:ss:SSS");
    private static final String SUCCESS_PERCENTAGE = "Test is Failed but with in success percentage";
    private static final String TEST_MSG = "Test %s is ";

    public void onTestStart(ITestResult result) {
        log(String.format(TEST_MSG, result.getMethod().getMethodName()) + RUNNING + FORMATTER.format(result.getStartMillis()));
    }

    public void onTestSuccess(ITestResult result) {
        log(String.format(TEST_MSG, result.getMethod().getMethodName()) + SUCCESS);
        File screen = takeScreenshot();
        String message = FORMATTER.format(result.getStartMillis());
        log(screen, message);
    }

    public void onTestFailure(ITestResult result) {
        log(String.format(TEST_MSG, result.getMethod().getMethodName()) + FAILED);
        File screen = takeScreenshot();
        String message = FORMATTER.format(result.getStartMillis());
        log(screen, message);
    }

    public void onTestSkipped(ITestResult result) {
        log(String.format(TEST_MSG, result.getMethod().getMethodName()) + SKIPPED);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log(SUCCESS_PERCENTAGE);
    }

    public void onStart(ITestContext context) {
        log(START);
    }

    public void onFinish(ITestContext context) {
        log(FINISH);
    }
}
