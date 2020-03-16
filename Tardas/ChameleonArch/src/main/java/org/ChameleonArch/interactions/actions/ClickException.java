package org.ChameleonArch.interactions.actions;

import org.CloisterBell.enumTypes.LogLevel;

public class ClickException extends Exception {

    public enum ClickFailureType { 
        WEBELEMENT, ACTIONS, JITTERCLICK, UNKNOWN;
    }
    /**
     * 
     */
    private static final long serialVersionUID = 8734921907026678924L;
    private String message; 
    private ClickFailureType failType; 
    private LogLevel level; 
    public ClickException(String message_) { 
       this(message_, ClickFailureType.UNKNOWN, LogLevel.ERROR); 
    }
    public ClickException(String message_, ClickFailureType type, LogLevel logLevel) { 
        message = message_; 
        failType = type; 
        level = logLevel;
    }
    public LogLevel getLogLevel() { 
        return level;
    }
    public String getClickExceptionMessage() { 
        return message; 
    }
    
    public ClickFailureType getFailureType() { 
        return failType; 
    }
}
