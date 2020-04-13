package org.CloisterBell.enumTypes;

public enum LogLevel {
    INFO(0), REPORT(0), WARN(1), ERROR(2),CRITICAL(3), DEBUG(5);
    
    int level; 
    LogLevel(int val) { 
        level = val; 
    }
    public int level() {
        return level; 
    }
    
    public boolean isWarning() {
        return this.level < LogLevel.WARN.level(); 
    }
    
    public boolean isInfo() { 
        return this == LogLevel.INFO; 
    }
    
    public boolean isReport() { 
        return this == LogLevel.REPORT;
    }
}
