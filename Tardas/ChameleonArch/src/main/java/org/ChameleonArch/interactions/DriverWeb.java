package org.ChameleonArch.interactions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.ChameleonArch.interactions.actions.Finder;
import org.ChameleonArch.interactions.actions.Getter;
import org.ChameleonArch.interactions.actions.Sender;
import org.ChameleonArch.interactions.exceptions.ClickException;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
@SuppressWarnings("unchecked")
public class DriverWeb<X extends WebElement> extends DriverModule<X> {

    public DriverWeb(WebDriver driver) {
        super(driver);
    }
    
   
    public void get(String url) { 
        driver.get(url);
    }

    public Actions getActions() {
        return new Actions(driver);
    }

    public JavascriptExecutor getJSExecute() {
        return (JavascriptExecutor) driver;
    }
    
    public WebDriver getDriver() { 
        return driver;
    }


    public List<WebElement> findElements(By by) {
        return findElements(by, Duration.ofSeconds(implicitWait));
    }

    public List<WebElement> findElements(By by, Duration time) {
        return Finder.findElements(this, by, time);
    }

    public WebElement findElement(By by) {
        return this.findElement(by, Duration.ofSeconds(implicitWait));
    }

    public WebElement findElement(By by, Duration timeout) {
        return Finder.findElement(this, by, timeout);
    }

    public void click(By by) {
        click(by, Duration.ofSeconds(implicitWait));
        
    }

    public void click(By by, Duration timeout) {
        Sender.click(this, by, timeout);
        
    }

    public void sendKeys(By by, String keysToSend) {
        sendKeys(by, keysToSend, Duration.ofSeconds(implicitWait));
        
    }

    public void sendKeys(By by, String keysToSend, Duration timeout) {
        Sender.sendKeys(this, timeout, by, keysToSend);
    }

    public String getText(By by) {
        return this.getText(by, Duration.ofSeconds(implicitWait));
    }

    public String getText(By by, Duration timeout) {
        return Getter.getText(this, by, timeout);
    }

    public String getAttribute(By by, String att) {
        return this.getAttribute(by, att, Duration.ofSeconds(implicitWait));
    }

    public String getAttribute(By by, String att, Duration timeout) {
        return Getter.getAttribute(this, by, timeout, att);
    }

    public String getCssValue(By by, String val) {
        return this.getCssValue(by, val, Duration.ofSeconds(implicitWait));
    }

    public String getCssValue(By by, String val, Duration timeout) {
        return Getter.getCSSValue(this, by, timeout, val);
    }

    public void click(WebElement ele) {
        try {
            Sender.click(this, ele);
        } catch (ClickException e) {
           Clapper.log(LogLevel.DEBUG, e.getClickExceptionMessage()); 
        } 
        
    }

    public void sendKeys(WebElement ele) {
        // TODO Auto-generated method stub
        
    }


    public String getCurrentUrl() {
        // TODO Auto-generated method stub
        return null;
    }


    public String getTitle() {
        // TODO Auto-generated method stub
        return null;
    }


    public String getPageSource() {
        String ps = driver.getPageSource();
        this.log(LogLevel.INFO, "Returning Page Source");
        log(LogLevel.DEBUG, "Source: " + ps);
        return ps;
    }


    public void close() {
        // TODO Auto-generated method stub
        driver.close();
    }


    public Set<String> getWindowHandles() {
        // TODO Auto-generated method stub
        return driver.getWindowHandles();
    }


    public String getWindowHandle() {
        // TODO Auto-generated method stub
        return driver.getWindowHandle();
    }


    public TargetLocator switchTo() {
        // TODO Auto-generated method stub
        return driver.switchTo();
    }


    public Navigation navigate() {
        // TODO Auto-generated method stub
        return driver.navigate();
    }


    public Options manage() {
        // TODO Auto-generated method stub
        return driver.manage();
    }


    public String getText(X ele) {
        // TODO Auto-generated method stub
        return null;
    }


    public String getAttribute(X ele, String att) {
        // TODO Auto-generated method stub
        return null;
    }


    public String getCssValue(X ele, String val) {
        // TODO Auto-generated method stub
        return null;
    }

}
