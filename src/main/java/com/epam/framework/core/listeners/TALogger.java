package com.epam.framework.core.listeners;

import com.epam.reportportal.message.ReportPortalMessage;

import static org.apache.log4j.Logger.getLogger;


public class TALogger {
    public static org.apache.log4j.Logger logger = getLogger(TAListener.class);

    public static void error(String string) {
        logger.error(string);
    }

    public static void error(String string, Throwable throwable) {
        logger.error(string);
        logger.error(string, throwable);
    }

    public static void info(String string) {
        logger.info(string);
    }

    public static void info(ReportPortalMessage message) {
        logger.info(message);
    }

    public static void debug(String string) {
        logger.debug(string);
    }
}
