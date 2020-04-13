package org.ChameleonArch.interactions.actions;

import java.time.Duration;

import org.ChameleonArch.interactions.DriverModule;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Getter {

    private static long implicitWait = 30; 
    public static String getText(DriverModule<?> driver, By by, Duration timeout) { 
        String retVal = null; 
        WebElement ele = Finder.findElement(driver,by,timeout); 
        try { 
            retVal = getText(ele); 
            Clapper.log(LogLevel.INFO, "Retrieved Element Text: "+ retVal);
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Failed to retrieve Element Text.");
            Clapper.log(LogLevel.DEBUG, "Trace\n" + e.getLocalizedMessage());
        }
        return retVal;
    }
    
    public static synchronized String getText(WebElement ele) throws Exception { 
        if(null == ele) { 
            throw new Exception("Element is null"); 
        }
        try { 
            return ele.getText();
        } catch (Exception e) { 
            throw e; 
        }
    }
    
    public static synchronized String getCSSValue(DriverModule<?> driver, By by, Duration timeout, String cssName) { 
        String retVal = null; 
        WebElement ele = Finder.findElement(driver, by, timeout);
        try { 
            retVal = getCSSValue(ele, cssName);
            Clapper.log(LogLevel.INFO, "\nFetched Element Attribute(name:value) " + cssName+":"+retVal); 
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Failed to fetch CSS Value " + cssName);
            Clapper.log(LogLevel.DEBUG, "Trace\n" + e.getLocalizedMessage());
        }
        return retVal;
    }
    
    public static synchronized String getCSSValue(WebElement ele, String cssName) throws Exception { 
        if(null == ele) { 
            throw new Exception("Element is null"); 
        }
        try { 
            return ele.getCssValue(cssName);
        } catch(Exception e) { 
            throw e; 
        }
    }
    public static String getAttribute(DriverModule<?> driver, By by, Duration timeout, String attribute) { 
        String returnVal = null; 
        WebElement ele = Finder.findElement(driver, by, timeout);
        try { 
            returnVal = getAttribute(ele, attribute);
            Clapper.log(LogLevel.INFO, "\nRetrieved Element Attribute(name:value): " + attribute+":" + returnVal);
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Failed to fetch attribute " + attribute);
            Clapper.log(LogLevel.DEBUG, "Trace\n" + e.getLocalizedMessage());
        }
        
        return returnVal; 
    }
  
    public static synchronized String getAttribute(WebElement ele, String name) throws Exception { 
        if(null == ele) { 
            throw new Exception("Element is null"); 
        }
        try { 
            return ele.getAttribute(name);
        } catch (Exception e) { 
            throw e; 
        }
       
    }
}
