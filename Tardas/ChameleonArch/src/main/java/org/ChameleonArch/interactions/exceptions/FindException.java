package org.ChameleonArch.interactions.exceptions;

import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;

public class FindException extends Exception {

    /**
     * Serial UUID
     */
    private static final long serialVersionUID = 1002837382116057139L;

    public enum FindFailureType { 
        WebDriver, FluentWaitCondition, ByIsNull, UNKNOWN
    }
   private String message; 
    private FindFailureType failType; 
    private LogLevel logLevel; 
    public FindException(String message_) { 
        this(message_, FindFailureType.UNKNOWN, LogLevel.ERROR); 
    }
    
    public FindException(String message_, FindFailureType type, LogLevel level) { 
        message = message_; 
        failType = type; 
        logLevel = level; 
        Clapper.log(logLevel, failType +" : " +message_);
    }
    
    public LogLevel getLogLevel() { 
        return logLevel; 
    }
    
    public String getFindExceptionMessage() { 
        return message; 
    }
    
    public FindFailureType getFailureType() { 
        return failType; 
    }
    

}
