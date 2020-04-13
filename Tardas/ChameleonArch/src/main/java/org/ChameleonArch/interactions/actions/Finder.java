package org.ChameleonArch.interactions.actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.ChameleonArch.interactions.DriverModule;
import org.ChameleonArch.interactions.exceptions.FindException;
import org.ChameleonArch.interactions.exceptions.FindException.FindFailureType;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Finder<X extends WebElement> {

    private synchronized static void throwException(Object ele, String message, FindFailureType failType) throws FindException { 
        if (ele == null) { 
            if(failType == null) { 
                throwException(ele,message, FindFailureType.UNKNOWN);
            }
            switch (failType) {
            case ByIsNull:
                throw new FindException(message, failType, LogLevel.CRITICAL);
            case FluentWaitCondition:
                throw new FindException(message, failType, LogLevel.ERROR);
            case WebDriver:
                throw new FindException(message, failType, LogLevel.WARN);
            case UNKNOWN:
            default:
                throw new FindException(message, failType, LogLevel.ERROR);
            }
        }
    }
    
    private synchronized static void throwException(List<?> ele, String message, FindFailureType failType) throws FindException { 
        
        if ((null == ele) || ele.isEmpty()) { 
            if(failType == null) { 
                throwException(ele, message, FindFailureType.UNKNOWN);
            }
            switch (failType) {
            case ByIsNull:
                throw new FindException(message, failType, LogLevel.CRITICAL);
            case FluentWaitCondition:
                throw new FindException(message, failType, LogLevel.ERROR);
            
             
            case WebDriver:
                throw new FindException(message, failType, LogLevel.WARN);
            case UNKNOWN:
            default:
                throw new FindException(message, failType, LogLevel.ERROR);
            }
        }
    }
    
    public synchronized static WebElement findElement(DriverModule<?> driver, By by, Duration timeout) { 
        WebElement ele = null; 
        
        try { 
            throwException(by,"By variable is null", FindFailureType.ByIsNull);
            ele = driver.getDriver().findElement(by); 
            throwException(ele, "(WebDriver) unable to locate element",  
                    FindFailureType.WebDriver); 
            Clapper.log(LogLevel.INFO, "(WebDriver)Found "+ (null != ele ? ele.toString() : "null") + " with locator: " + by);
        } catch (FindException fe) { 
            if(fe.getFailureType().equals(FindFailureType.ByIsNull)) { 
                return ele; 
            }
            ele = findElementWithCondition(new WebDriverWait(driver.getDriver(), timeout)
                    , ExpectedConditions.presenceOfElementLocated(by)); 
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Unable to locate element with locator: " + by);
            Clapper.log(LogLevel.DEBUG, "Trace: " + e.getMessage());
        }
        return ele; 
    }
    
    public synchronized static List<WebElement> findElements(DriverModule<?> driver, By by, Duration timeout) { 
        List<WebElement> eles = null; 
        try { 
            throwException(by, "By variable is null", FindFailureType.ByIsNull); 
            eles = driver.getDriver().findElements(by);
            throwException(eles, "Failed to locate elements with Default Strategy"
                        , FindFailureType.WebDriver); 
            Clapper.log(LogLevel.INFO, "(WebDriver)Found #" + eles.size() + " elements with locator " + by + " using WebDriver");
        } catch (FindException fe) { 
            if(fe.getFailureType() == FindFailureType.WebDriver) { 
                eles = findElementsWithCondition(new WebDriverWait(driver.getDriver(), timeout), ExpectedConditions.presenceOfAllElementsLocatedBy(by));  
            }
        } catch (Exception e) {
            Clapper.log(LogLevel.DEBUG, e.getLocalizedMessage());
            Clapper.log(LogLevel.ERROR, "Failed to locate element with locator: " + by); 
        }
        return eles; 
    }
    
    @SuppressWarnings("unchecked")
    public synchronized static <V extends List<WebElement>> V findElementsWithCondition(WebDriverWait waiter, Function<? super WebDriver, V> condition) {
        V eles = (V) new ArrayList<WebElement>(); 
        try { 
            eles = waiter.until(condition);
            throwException(eles, "Failed to locate elements with condition"
                    , FindFailureType.FluentWaitCondition);
            Clapper.log(LogLevel.INFO, "(FluentWait)Found #" + eles.size() + " elements");
        }  catch (Exception e) { 
            Clapper.log(LogLevel.DEBUG, "Stack Trace:\n"+ e.getLocalizedMessage());
        }
        return eles; 
    }
    
    @SuppressWarnings("unchecked")
    public synchronized static <V extends WebElement> V findElementWithCondition(WebDriverWait waiter, Function<? super WebDriver, V> condition) {
        WebElement eles = null; 
        try { 
            eles = waiter.until(condition);
            throwException(eles, "Failed to find element with condition"
                    , FindFailureType.FluentWaitCondition);
            Clapper.log(LogLevel.INFO,  "(FluentWait)Found "+ (null != eles ? eles.toString() : "null") + " with condition");
        }  catch (Exception e) { 
            Clapper.log(LogLevel.WARN, "Failed to locate element with Condition" );
            Clapper.log(LogLevel.DEBUG,"Stack Trace:\n" + e.getLocalizedMessage());
        }
        return (V) eles; 
    }
    
}
