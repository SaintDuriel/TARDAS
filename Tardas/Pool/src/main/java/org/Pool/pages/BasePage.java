package org.Pool.pages;

import java.time.Duration;
import java.util.List;

import org.ChameleonArch.enums.ClickSuccessType;
import org.ChameleonArch.interactions.DriverModule;
import org.ChameleonArch.interactions.actions.ElementState;
import org.ChameleonArch.interactions.actions.Finder;
import org.ChameleonArch.interactions.actions.Getter;
import org.ChameleonArch.interactions.actions.Sender;
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
        return Finder.findElement(driver, by, duration); 
    }
    
    /** Method to return the WebElement within the {@link #implicitWait} duration
     * @param by
     * @return
     */
    protected final WebElement findElement(By by) { 
        return Finder.findElement(driver, by, Duration.ofSeconds(implicitWait)); 
    }
    
    protected final WebElement findContextElement(By ctx, By by) { 
        return Finder.findContextElement(driver, ctx, by, Duration.ofSeconds(implicitWait));
    }
    
    protected final WebElement findContextElement(WebElement ctx, By by) { 
        return Finder.findContextElement(driver, ctx, by, Duration.ofSeconds(implicitWait));
    }
    
    /**
     * Method to return a list of WebElements within the {@link #implicitWait} duration
     * @param by
     * @return
     */
    protected final List<WebElement> findElements(By by) { 
        return Finder.findElements(driver, by, Duration.ofSeconds(implicitWait));
    }
    
    /**
     * Method to return a list of WebElements with the specified Dduration. 
     * @param by
     * @param duration
     * @return
     */
    protected final List<WebElement> findElements(By by, Duration duration) { 
        return Finder.findElements(driver, by, duration);
    }
    
    /**
     * Method to send keys to an element. More than likely an 'input' type element. 
     * @param by By Locator of Element
     * @param keysToSend String to enter into element. 
     * @return Boolean which returns the current "value" attribute of the element, and compares to the input keysToSend variable. 
     */
    protected final Boolean sendKeys(By by, String keysToSend) { 
        Sender.sendKeys(driver, Duration.ofSeconds(implicitWait), by, keysToSend);
        return keysToSend.equals(Getter.getAttribute(driver, by , Duration.ofSeconds(implicitWait), "value"));
    }
    
    /**
     * Method to send keys to an element within a specified Duration. 
     * @param by
     * @param duration
     * @param keysToSend
     * @return
     */
    protected final Boolean sendKeys(By by, Duration duration, String keysToSend) { 
        Sender.sendKeys(driver, duration, by, keysToSend);
        return keysToSend.equals(Getter.getAttribute(driver, by , Duration.ofSeconds(implicitWait), "value"));
    }
    
    protected final ClickSuccessType click(By by, Duration duration) { 
        return Sender.click(driver, by, duration);
    }
    
    protected final ClickSuccessType click(By by) { 
        return Sender.click(driver, by, Duration.ofSeconds(implicitWait)); 
    }
    
    protected final Boolean isDisplayed(By by) { 
        return ElementState.isDisplayed(driver, Duration.ofSeconds(implicitWait), by);
    }
    
    protected final Boolean isDisplayed(By by, Duration duration) { 
        return ElementState.isDisplayed(driver, duration, by);
    }
    
    protected final Boolean isEnabled(By by) { 
        return ElementState.isEnabled(driver, Duration.ofSeconds(implicitWait), by);
    }
    
    protected final Boolean isEnabled(By by, Duration duration) { 
        return ElementState.isEnabled(driver, duration, by);
    }
    
    protected final Boolean isSelected(By by) { 
        return ElementState.isSelected(driver, Duration.ofSeconds(implicitWait), by);
    }
    
    protected final Boolean isSelected(By by, Duration duration) { 
        return ElementState.isSelected(driver, duration, by);
    }
    
    protected final String getText(By by) { 
        return Getter.getText(driver, by,Duration.ofSeconds(implicitWait)); 
    }
    protected final String getText(By by, Duration duration) { 
        return Getter.getText(driver, by,duration); 
    }
    
    protected final String getAttribute(By by, String attribute) { 
        return Getter.getAttribute(driver, by, Duration.ofSeconds(implicitWait), attribute); 
    }
    
    protected final String getAttribute(By by, String attribute, Duration duration) { 
        return Getter.getAttribute(driver, by, duration, attribute); 
    }
    
    protected final String getCss(By by, String cssName) { 
        return Getter.getCSSValue(driver, by, Duration.ofSeconds(implicitWait), cssName); 
    }
    
    protected final String getCss(By by, String cssName, Duration duration) { 
        return Getter.getCSSValue(driver, by, duration, cssName); 
    }
}
