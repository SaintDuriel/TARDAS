package org.ChameleonArch.driverManagers;

import org.ChameleonArch.DriverManager;
import org.ChameleonArch.interactions.DriverWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IE11DriverManager extends DriverManager {

    @Override
    protected void startService() {
        
        WebDriverManager.iedriver().setup();
    }

    @Override
    protected void stopService() {
        if (WebDriverManager.getInstance(InternetExplorerDriver.class) != null) {
            WebDriverManager.getInstance(InternetExplorerDriver.class).clearCache();
        }
    }

    @Override
    protected void createDriver() {
        
        driver.set(new DriverWeb<WebElement>(new InternetExplorerDriver()));
        
    }

}

