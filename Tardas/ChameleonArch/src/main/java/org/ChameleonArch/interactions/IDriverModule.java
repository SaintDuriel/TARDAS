package org.ChameleonArch.interactions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public interface IDriverModule<X extends WebElement> extends WebDriver {

 
	Actions getActions(); 
	JavascriptExecutor getJSExecute(); 
	WebDriver getDriver(); 

	/**
	 * Method to fetch a given URL String
	 * @author matth
	 * @param url - String which should be a valid HTTP/S URL
	 */
	void get(String url); 
	/**
	 * Uses implicit wait to find elements matching input Locator. <br>
	 * 
	 * 
	 * @see WebDriver#findElements(By)
	 * @author matth
	 * @param by - By locator to locate elements with
	 * @return {@linkplain java.util.List}  <T extends WebElement> of Elements which could have zero elements
	 */
	<Y extends WebElement> List<Y> findElements(By by);
	/**
	 * Search for element within specified time in seconds
	 * @see #findElements(By) for reference of WebDriver method implementation. 
	 * @param by  - By Locator of Element
	 * @param time - Time in seconds to search for element
	 * @return {@linkplain java.util.List}  <T extends WebElement> of Elements which could have zero elements
	 */
	<Y extends WebElement> List<Y> findElements(By by, Duration time);
	
	/**
	 * Use Implicit wait to find element matching input locator. <br>
	 * 
	 * @see WebDriver#findElement(By)
	 *
	 * @author matth
	 * @param by - By locator to find element
	 * @return first located element or null
	 */
	<Y extends WebElement> Y findElement(By by);
	/**
	 * Search for element within specified time in seconds
	 * @see #findElement(By) for reference of WebDriver method implementation
	 * @param by  - By locator to find element
	 * @param time - Time in seconds to search for element
	 * @return first located element or null
	 */
	<Y extends WebElement> Y findElement(By by, Duration timeout);
	
	void click(By by); 
	void click(By by, Duration timeout); 
	void click(X ele); 
	void sendKeys(By by, String keysToSend); 
	void sendKeys(By by, String keysToSend, Duration timeout); 
	void sendKeys(X ele); 
	
	String getText(By by); 
	String getText(By by, Duration timeout); 
	String getText(X ele); 
	
	String getAttribute(By by, String att); 
	String getAttribute(By by, String att,  Duration timeout); 
	String getAttribute(X ele, String att); 
	
	
	String getCssValue(By by, String val); 
	String getCssValue(By by, String val, Duration timeout); 
	String getCssValue(X ele, String val); 
	
	
	
}
