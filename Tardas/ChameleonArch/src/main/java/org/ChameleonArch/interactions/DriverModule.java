package org.ChameleonArch.interactions;

import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.openqa.selenium.WebDriver;

/**
 * DriverModule is an abstraction that layers on some logging for internal use <br>
{@link Clapper#log(LogLevel, String)}
 * @author matth
 *
 * @param <X>
 */
public abstract class DriverModule<X extends WebDriver> implements IDriverModule<X> {

    X driver; 
    protected long implicitWait = 15; 
    public DriverModule(X driver) { 
        this.driver = driver; 
    }
    
    void log(LogLevel level, String message) {
        Clapper.log(level, message);
    }
    
    public void setImplicitWait(long timeout) { 
        implicitWait = timeout; 
    }
    
    public long implicitWait() { 
        return implicitWait; 
    }
    
    public void quit() { 
        driver.quit();
    }
}
