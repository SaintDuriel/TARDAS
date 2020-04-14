package org.ChameleonArch.driverManagers;

import org.ChameleonArch.DriverManager;
import org.ChameleonArch.interactions.DriverWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager extends DriverManager {


    @Override
    protected void startService() {
        
        WebDriverManager.edgedriver().setup();
    }

    @Override
    protected void stopService() {
        if (WebDriverManager.getInstance(EdgeDriver.class) != null) {
            WebDriverManager.getInstance(EdgeDriver.class).clearCache();
        }
    }

    @Override
    protected void createDriver() {
        driver.set(new DriverWeb<WebElement>(new EdgeDriver()));
        
    }

}

