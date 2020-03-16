package org.Pool.pages;

import java.time.Duration;

import org.ChameleonArch.interactions.DriverModule;
import org.ChameleonArch.interactions.actions.GetMethods;
import org.ChameleonArch.interactions.actions.InputMethods;
import org.EyeOfHarmony.Seed.Spin;
import org.openqa.selenium.By;

public abstract class BasePage extends Page {

    public BasePage(DriverModule<?> driver, Spin spin) {
        super(driver, spin);
    }

    public long implicitWait = 30; 

    
    protected Boolean sendKeys(By by, String keysToSend) { 
        InputMethods.sendKeys(driver, Duration.ofSeconds(driver.implicitWait()), by, keysToSend);
        return GetMethods.getAttribute(driver, by, Duration.ofSeconds(driver.implicitWait()), "value") == keysToSend ? true : false;
    }
}
