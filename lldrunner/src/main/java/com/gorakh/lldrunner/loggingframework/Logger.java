package com.gorakh.lldrunner.loggingframework;

public class Logger {
    private static final Logger instance = new Logger();
    private LogConfig config;
    private Logger() {
        // Private constructor to enforce singleton pattern
        config = new LogConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance() {
        return instance;
    }
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= config.getLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(level, message);
            config.getLogAppender().append(logMessage);
        }
    }

    public void info(String thisIsAnInformationMessage) {
        log(LogLevel.INFO,thisIsAnInformationMessage);
    }

    public void warning(String thisIsAWarningMessage) {
        log(LogLevel.WARN,thisIsAWarningMessage);
    }

    public void error(String thisIsAnErrorMessage) {
        log(LogLevel.ERROR,thisIsAnErrorMessage);
    }

    public void setConfig(LogConfig config) {
        this.config = config;
    }

    public void debug(String thisIsADebugMessage) {
        log(LogLevel.FETAL,thisIsADebugMessage);
    }
}
