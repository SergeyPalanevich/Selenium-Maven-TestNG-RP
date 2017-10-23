package helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
    public static Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.info(message);
    }
}
