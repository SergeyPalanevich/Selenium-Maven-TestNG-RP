package listener;

import helper.MyLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MakeScreenshotOnFailedTest extends TestListenerAdapter {

    Logger logger = LoggerFactory.getLogger(MyLogger.class);

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }
}
