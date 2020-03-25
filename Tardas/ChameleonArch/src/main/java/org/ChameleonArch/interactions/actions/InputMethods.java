package org.ChameleonArch.interactions.actions;

import java.time.Duration;

import org.ChameleonArch.enums.ClickSuccessType;
import org.ChameleonArch.interactions.DriverModule;
import org.ChameleonArch.interactions.exceptions.ClickException;
import org.ChameleonArch.interactions.exceptions.ClickException.ClickFailureType;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.Library.RandomMath;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputMethods {


    public synchronized static void sendKeys(DriverModule<?> driver, Duration timeout, By by, String keysToSend) {
        WebElement ele = driver.findElement(by, timeout);
        try { 
            sendKeys(ele, keysToSend); 
            Clapper.log(LogLevel.INFO, "Sent value: " + keysToSend);
        } catch (Exception e) { 
            Clapper.log(LogLevel.ERROR, "Failed to send keys to element");
            Clapper.log(LogLevel.DEBUG, e.getLocalizedMessage());
        }
    }
    
    public synchronized static void sendKeys(WebElement ele, String keysToSend) throws Exception { 
        if(null == ele) { 
            throw new Exception("Element is null"); 
        }
        try { 
            ele.clear();
            if(GetMethods.getAttribute(ele, "value").isEmpty()) {
                ele.sendKeys(keysToSend);
                return;
            }
            
        } catch (Exception e) {
            throw e; 
        }
    }
    
    public synchronized static void clear(DriverModule<?> driver, Duration timeout, By by) { 
        WebElement ele = driver.findElement(by, timeout);
       try { 
           clear(ele); 
       } catch (Exception e) { 
           
       }
        
    }
    public synchronized static void clear(WebElement ele) throws Exception { 
        if(null == ele) 
        {
            throw new Exception("Element is null");
        }
        try { 
            if(GetMethods.getAttribute(ele, "value").isEmpty()) {
                return;
            }
            ele.clear();
        } catch (Exception e) { 
            throw e; 
        }
    }
    
    public synchronized static ClickSuccessType click(DriverModule<?> driver, By by, Duration timeout) { 
        WebElement ele = FindMethods.findElementWithCondition(new WebDriverWait(driver.getDriver(), timeout),ExpectedConditions.elementToBeClickable(by)); 
        Rectangle loc = new Rectangle(0, 0, 0, 0);
        ClickSuccessType successStrategy =  ClickSuccessType.WEBELEMENT;
        try { 
            loc = ele.getRect();
            successStrategy = click(driver, ele); 
        } catch(ClickException ce) { 
            Clapper.log(ce.getLogLevel(), ce.getClickExceptionMessage());
        } catch (Exception e) { 
            Clapper.log(LogLevel.DEBUG, "Unknown Error Occurred during click\n"+e.getLocalizedMessage());
        }
        Clapper.log(LogLevel.INFO, "\nClicked element at: ("+loc.getX()+","+loc.getY()+") \nWith locator " + by + " \nWith Strategy: " + successStrategy);
        return successStrategy; 
    }

    public synchronized static ClickSuccessType click(DriverModule<?> driver, WebElement ele) throws ClickException { 
        try { 
            if(ele == null) { 
                throw new ClickException("Element is null, unable to click null element.", ClickFailureType.WEBELEMENT, LogLevel.ERROR );
            }
            ele.click(); 
            return ClickSuccessType.WEBELEMENT;
        } catch (Exception e) { 
            try { 
                return actionClick(driver, ele); 
            }catch(ClickException ce) { 
                throw ce; 
            } 
        }
    }

    synchronized static ClickSuccessType actionClick(DriverModule<?> driver, WebElement ele) throws ClickException {
        try { 
            driver.getActions().moveToElement(ele).click().perform();
            return ClickSuccessType.ACTIONS;
        } catch (Exception e) { 
            try {
                return jitterClick(driver, ele); 
            } catch(ClickException ce) { 
                throw ce; 
            } 
        }
    }

    synchronized static ClickSuccessType jitterClick(DriverModule<?> driver, WebElement ele) throws ClickException {
        //Calculate some random movement in the mouse from center of element. 
        Rectangle loc = ele.getRect();
        int height = loc.height; 
        int width = loc.width;
        int yCen = (int)height / 2; 
        int xCen = (int)width / 2; 
        int yWiggle = height - yCen; 
        int xWiggle = width - xCen; 
        
        int xOffset = RandomMath.addSubtractRandom(xCen, xWiggle); 
        int yOffset = RandomMath.addSubtractRandom(yCen, yWiggle);  
        try { 
            driver.getActions().moveToElement(ele, xOffset, yOffset).click().perform();
            return ClickSuccessType.JITTER;
        } catch (Exception e) { 
            throw new ClickException("Failed to Jitter Click element at location: " + loc, ClickFailureType.JITTERCLICK, LogLevel.ERROR);
        }
    }

}
