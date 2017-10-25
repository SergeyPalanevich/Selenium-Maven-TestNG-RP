package helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
    private  Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public  void error(String message) {
        logger.error(message);
    }

    public  void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public  void info(String message) {
        logger.info(message);
    }

    public  void debug(String message) {
        logger.info(message);
    }
}
