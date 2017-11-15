package com.epam.framework.core.listeners;

import org.apache.log4j.Logger;

public class TALogger {
    public static Logger logger = Logger.getLogger(TALogger.class);
    public static void error(String string){
        logger.error(string);
    }
    public static void error(String string, Throwable throwable){
        logger.error(string);
        logger.error(string, throwable);
    }
    public static void info(String string){
        logger.info(string);
    }
    public static void debug(String string){
        logger.debug(string);
    }
}
