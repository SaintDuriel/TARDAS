package org.Pool.pages;

import java.time.Duration;
import java.util.List;

import org.ChameleonArch.enums.ClickSuccessType;
import org.ChameleonArch.interactions.DriverModule;
import org.ChameleonArch.interactions.actions.FindMethods;
import org.ChameleonArch.interactions.actions.GetMethods;
import org.ChameleonArch.interactions.actions.InputMethods;
import org.ChameleonArch.interactions.actions.IsMethods;
import org.EyeOfHarmony.Seed.Spin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The Base Page is the method holder for the implemented page objects.
 * <br><br>
 * This class should be the extension "base" of each page object, or <br>
 * within the inheritance hierarchy at some point. 
 *
 * @author matth
 *
 */
/**
 * @author matth
 *
 */
/**
 * @author matth
 *
 */
public abstract class BasePage extends Page {

    public BasePage(DriverModule<?> driver, Spin spin) {
        super(driver, spin);
    }
    public abstract Page loadPage(); 
    /**
     * Implicit Wait that is included in the baseline of<br>
     * all method interactions. Should be overridden by each page<br>
     * to ensure proper page performance.
     * 
     * NOTE: This has no affect on the {@link DriverModule.#implicitWait()} method/variable setting. 
     */
    /**
     * 
     */
    public long implicitWait = 30; 

    /**
     * Method to return the WebElement within a specified duration
     * @param by
     * @param duration
     * @return
     */
    protected final WebElement findElement(By by, Duration duration) { 
        return FindMethods.findElement(driver, by, duration); 
    }
    
    /** Method to return the WebElement within the {@link #implicitWait} duration
     * @param by
     * @return
     */
    protected final WebElement findElement(By by) { 
        return FindMethods.findElement(driver, by, Duration.ofSeconds(implicitWait)); 
    }
    
    /**
     * Method to return a list of WebElements within the {@link #implicitWait} duration
     * @param by
     * @return
     */
    protected final List<WebElement> findElements(By by) { 
        return FindMethods.findElements(driver, by, Duration.ofSeconds(implicitWait));
    }
    
    /**
     * Method to return a list of WebElements with the specified Dduration. 
     * @param by
     * @param duration
     * @return
     */
    protected final List<WebElement> findElements(By by, Duration duration) { 
        return FindMethods.findElements(driver, by, duration);
    }
    
    /**
     * Method to send keys to an element. More than likely an 'input' type element. 
     * @param by By Locator of Element
     * @param keysToSend String to enter into element. 
     * @return Boolean which returns the current "value" attribute of the element, and compares to the input keysToSend variable. 
     */
    protected final Boolean sendKeys(By by, String keysToSend) { 
        InputMethods.sendKeys(driver, Duration.ofSeconds(implicitWait), by, keysToSend);
        return keysToSend.equals(GetMethods.getAttribute(driver, by , Duration.ofSeconds(implicitWait), "value"));
    }
    
    /**
     * Method to send keys to an element within a specified Duration. 
     * @param by
     * @param duration
     * @param keysToSend
     * @return
     */
    protected final Boolean sendKeys(By by, Duration duration, String keysToSend) { 
        InputMethods.sendKeys(driver, duration, by, keysToSend);
        return keysToSend.equals(GetMethods.getAttribute(driver, by , Duration.ofSeconds(implicitWait), "value"));
    }
    
    protected final ClickSuccessType click(By by, Duration duration) { 
        return InputMethods.click(driver, by, duration);
    }
    
    protected final ClickSuccessType click(By by) { 
        return InputMethods.click(driver, by, Duration.ofSeconds(implicitWait)); 
    }
    
    protected final Boolean isDisplayed(By by) { 
        return IsMethods.isDisplayed(driver, Duration.ofSeconds(implicitWait), by);
    }
    
    protected final Boolean isDisplayed(By by, Duration duration) { 
        return IsMethods.isDisplayed(driver, duration, by);
    }
    
    protected final Boolean isEnabled(By by) { 
        return IsMethods.isEnabled(driver, Duration.ofSeconds(implicitWait), by);
    }
    
    protected final Boolean isEnabled(By by, Duration duration) { 
        return IsMethods.isEnabled(driver, duration, by);
    }
    
    protected final Boolean isSelected(By by) { 
        return IsMethods.isSelected(driver, Duration.ofSeconds(implicitWait), by);
    }
    
    protected final Boolean isSelected(By by, Duration duration) { 
        return IsMethods.isSelected(driver, duration, by);
    }
    
    protected final String getText(By by) { 
        return GetMethods.getText(driver, by,Duration.ofSeconds(implicitWait)); 
    }
    protected final String getText(By by, Duration duration) { 
        return GetMethods.getText(driver, by,duration); 
    }
    
    protected final String getAttribute(By by, String attribute) { 
        return GetMethods.getAttribute(driver, by, Duration.ofSeconds(implicitWait), attribute); 
    }
    
    protected final String getAttribute(By by, String attribute, Duration duration) { 
        return GetMethods.getAttribute(driver, by, duration, attribute); 
    }
    
    protected final String getCss(By by, String cssName) { 
        return GetMethods.getCSSValue(driver, by, Duration.ofSeconds(implicitWait), cssName); 
    }
    
    protected final String getCss(By by, String cssName, Duration duration) { 
        return GetMethods.getCSSValue(driver, by, duration, cssName); 
    }
}
