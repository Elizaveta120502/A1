package com.A1.task3.logger;

import com.A1.task3.reader.ReadFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerProvider {
    private static final Logger LOGGER = LogManager.getLogger(ReadFile.class);

    public LoggerProvider() {
    }

    public static Logger getLOG() {
        return LOGGER;
    }
}
