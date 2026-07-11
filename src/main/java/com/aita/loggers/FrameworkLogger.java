package com.aita.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrameworkLogger {

    public static final Logger logger = LogManager.getLogger(FrameworkLogger.class);
    private FrameworkLogger() {
    }
    public static void info(String message){
        logger.info(message);
        LogCollector.add(message);
    }

    public static void error(String message) {
        logger.error(message);
        LogCollector.add(message);
    }

    public static void warn(String message) {
        logger.warn(message);
        LogCollector.add(message);
    }

    public static void debug(String message){
        logger.debug(message);
        LogCollector.add(message);
    }
}
