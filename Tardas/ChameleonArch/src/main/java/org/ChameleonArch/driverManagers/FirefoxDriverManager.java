package org.ChameleonArch.driverManagers;

import org.ChameleonArch.DriverManager;
import org.ChameleonArch.interactions.DriverWeb;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {


    @Override
    protected void startService() {
        
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    protected void stopService() {
        if (WebDriverManager.getInstance(FirefoxDriver.class) != null) {
            WebDriverManager.getInstance(FirefoxDriver.class).clearCache();
        }
    }

    @Override
    protected void createDriver() {
        
        driver.set(new DriverWeb<FirefoxDriver>(new FirefoxDriver()));
       
    }

}

