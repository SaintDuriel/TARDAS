package org.CloisterBell;

import org.CloisterBell.enumTypes.LogLevel;

public class Clapper {

    private static LogLevel localLogLevel = LogLevel.valueOf(System.getProperty("logLevel", "DEBUG").toUpperCase());
    public static void ring() { 
        System.out.println("Cloister Bell has been rung by the clapper");
    }

    public static void setLogLevel(LogLevel level_) { 
        localLogLevel = level_; 
        printMessage(LogLevel.DEBUG, "Set logging level to LogLevel."+localLogLevel.toString());
    }

    public static void log(LogLevel level, String message) { 
        printMessage(level, message); 
    }

    private static void printMessage(LogLevel logLevel, String message) { 
       if( logLevel.level() <= localLogLevel.level() ) { 
           System.out.println(logLevel.toString() + " : " + message);
       }
    }
  
}
