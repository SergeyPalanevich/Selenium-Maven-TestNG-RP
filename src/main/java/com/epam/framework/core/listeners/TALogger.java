package com.epam.framework.core.listeners;


import static org.apache.log4j.LogManager.getLogger;

public class TALogger {
    private static org.apache.log4j.Logger logger =  getLogger(TALogger.class);

    private TALogger(){}

    public static void error(String string) {
        logger.error(string);
    }

    public static void error(String string, Throwable throwable) {
        logger.error(string);
        logger.error(string, throwable);
    }

    public static void info(Object message) {
        logger.info(message);
    }

    public static void debug(String string) {
        logger.debug(string);
    }
}
