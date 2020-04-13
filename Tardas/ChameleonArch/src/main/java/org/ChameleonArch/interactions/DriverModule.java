package org.ChameleonArch.interactions;

import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * DriverModule is an abstraction that layers on some logging for internal use <br>
{@link Clapper#log(LogLevel, String)}
 * @author matth
 *
 * @param <X>
 */
public abstract class DriverModule<X extends WebElement> implements IDriverModule<X> {

    WebDriver driver; 
    protected long implicitWait = 15; 
    public DriverModule(WebDriver driver) { 
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
