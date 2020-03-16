package org.ChameleonArch.interactions.actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.ChameleonArch.interactions.DriverModule;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindMethods<X extends WebElement> {

 
    
    public synchronized static WebElement findElement(DriverModule<?> driver, By by, Duration timeout) { 
        WebElement ele = null; 
        
        try { 
            if(by == null) { 
                throw new Exception("Element Locator is null");
            }
            try { 
                
            } catch (Exception f) { 
                ele = findElementWithCondition(new WebDriverWait(driver.getDriver(), timeout), ExpectedConditions.presenceOfElementLocated(by)); 
                if(ele == null) { 
                    throw new Exception("Unable to locate element within: " + timeout.getSeconds() + " seconds");
                }
            }
            Clapper.log(LogLevel.INFO, "Found element with locator: " + by);
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Unable to locate element with locator: " + by);
            Clapper.log(LogLevel.DEBUG, "Trace: " + e.getMessage());
        }
        return ele; 
    }
    
    public synchronized static List<WebElement> findElements(DriverModule<?> driver, By by, Duration timeout) { 
        List<WebElement> eles = null; 
        try { 
            eles = driver.getDriver().findElements(by);
            if(eles.isEmpty()) { 
                throw new Exception("Failed to locate elements with Default Strategy"); 
                
            }
                
            Clapper.log(LogLevel.INFO, "Found " + eles.size() + " elements with locator " + by);
        } catch (Exception e) { 
            eles = findElementsWithCondition(new WebDriverWait(driver.getDriver(), timeout), ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            if(eles.size() > 0) { 
                return eles; 
            }
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
        } catch (Exception e) { 
            Clapper.log(LogLevel.WARN, "Failed to locate elements with Condition" );
        }
        
        
        return eles; 
    }
    
    public synchronized static <V extends WebElement> V findElementWithCondition(WebDriverWait waiter, Function<? super WebDriver, V> condition) {
        WebElement eles = null; 
        try { 
            eles = waiter.until(condition);
        } catch (Exception e) { 
            Clapper.log(LogLevel.WARN, "Failed to locate element with Condition" );
        }
        
        
        return (V) eles; 
    }
    
}
