package org.ChameleonArch.interactions.actions;

import java.time.Duration;

import org.ChameleonArch.interactions.DriverModule;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementState {

    public static synchronized Boolean isDisplayed(DriverModule<?> driver, Duration timeout, By by) {
        Boolean retVal = false;

        WebElement ele = Finder.findElement(driver,by,timeout); 
        try { 
            retVal = isDisplayed(ele); 
            Clapper.log(LogLevel.INFO, "Element is Displayed in View Port?: "+ retVal);
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Failed to determine element visibility, returning false");
            Clapper.log(LogLevel.DEBUG, "Trace\n" + e.getLocalizedMessage());
        }
        return retVal; 
    }

    public static synchronized Boolean isDisplayed(DriverModule<?> driver, By by )  {
        return isDisplayed(driver, Duration.ofSeconds(driver.implicitWait()), by); 
    }

    static synchronized Boolean isDisplayed(WebElement ele) throws Exception { 
        if(ele == null) { 
            throw new Exception("Element is null");
            
        }
        try { 
            return ele.isDisplayed();
        } catch (Exception e) { 
            throw e; 
        }
    }

    public static synchronized Boolean isSelected(DriverModule<?> driver, Duration timeout, By by) {
        Boolean retVal = false;

        WebElement ele = Finder.findElement(driver,by,timeout); 
        try { 
            retVal = isSelected(ele); 
            Clapper.log(LogLevel.INFO, "Element is Selected: "+ retVal);
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Failed to determine element selection state, returning false");
            Clapper.log(LogLevel.DEBUG, "Trace\n" + e.getLocalizedMessage());
        }
        return retVal; 
    }

    public static synchronized Boolean isSelected(DriverModule<?> driver, By by )  {
        return isSelected(driver, Duration.ofSeconds(driver.implicitWait()), by); 
    }

    static synchronized Boolean isSelected(WebElement ele) throws Exception { 
        try { 
            if(ele == null) { 
                throw new Exception("Element is null"); 
            }
            return ele.isSelected();
        } catch (Exception e) { 
            throw e; 
        }
    }

    public static synchronized Boolean isEnabled(DriverModule<?> driver, Duration timeout, By by) {
        Boolean retVal = false;

        WebElement ele = Finder.findElement(driver, by, timeout); 
        try { 
            retVal = isEnabled(ele); 
            Clapper.log(LogLevel.INFO, "Element is Selected: "+ retVal);
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Failed to determine element selection state, returning false");
            Clapper.log(LogLevel.DEBUG, "Trace\n" + e.getLocalizedMessage());
        }
        return retVal; 
    }

    public static synchronized Boolean isEnabled(DriverModule<?> driver, By by )  {
        return isEnabled(driver, Duration.ofSeconds(driver.implicitWait()), by); 
    }

    static synchronized Boolean isEnabled(WebElement ele) throws Exception { 
        if(ele == null) { 
            throw new Exception("Element is null"); 
        }
        try { 
            return ele.isSelected();
        } catch (Exception e) { 
            throw e; 
        }
    }


    public static synchronized Boolean isVisible(DriverModule<?> driver, By by) { 
        return isVisible(driver, by, Duration.ofSeconds(driver.implicitWait())); 
    }

    public static synchronized Boolean isVisible(DriverModule<?> driver, By by, Duration timeout) { 
        Boolean retVal = false; 
        WebElement ele = Finder.findElement(driver, by, timeout);

        try { 
            retVal = isVisible(new WebDriverWait(driver, timeout), ele);
        } catch (Exception e) { 

        }



        return retVal; 
    }

    public static synchronized Boolean isVisible(WebDriverWait waiter, WebElement ele) throws Exception { 
        Boolean retVal = false; 

        if( ele == null) { 
            throw new Exception("Element is null"); 
        }
        try { 
            WebElement isVisible = Finder.findElementWithCondition(waiter, ExpectedConditions.visibilityOf(ele));
            if(isVisible != null) { 
                retVal = true; 
            }
        } catch (Exception e) { 

        }

        return retVal; 
    }

}
