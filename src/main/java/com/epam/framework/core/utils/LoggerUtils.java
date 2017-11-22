package com.epam.framework.core.utils;

import com.epam.reportportal.message.ReportPortalMessage;

import java.io.File;
import java.io.IOException;

import static org.apache.log4j.LogManager.getLogger;

public class LoggerUtils {
    private static final org.apache.log4j.Logger LOGGER = getLogger(LoggerUtils.class);
    private static final org.apache.log4j.Logger LOG_RP = getLogger("report_portal_logger");

    private LoggerUtils(){}

    public static void error(String string) {
        LOGGER.error(string);
    }

    public static void error(String string, Throwable throwable) {
        LOGGER.error(string);
        LOGGER.error(string, throwable);
    }

    public static void info(Object message) {
        LOGGER.info(message);
    }
    public static void debug(String string) {
        LOGGER.debug(string);
    }

   public static void logRP(File file, String message) {
       try {
           ReportPortalMessage msg = new ReportPortalMessage(file, message);
           LOG_RP.info(msg);
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}
