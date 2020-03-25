package org.CloisterBell.enumTypes;

public enum LogLevel {
    INFO(0), WARN(1), ERROR(2),CRITICAL(3), DEBUG(5);
    
    int level; 
    LogLevel(int val) { 
        level = val; 
    }
    public int level() {
        return level; 
    }
}
