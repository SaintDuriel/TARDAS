package org.ChameleonArch.driverManagers;

import org.ChameleonArch.DriverManager;
import org.ChameleonArch.interactions.DriverWeb;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void startService() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    protected void stopService() {
        if (WebDriverManager.getInstance(ChromeDriver.class) != null) {
            WebDriverManager.getInstance(ChromeDriver.class).clearCache();
        }
    }

    @Override
    protected void createDriver() {
        driver.set(new DriverWeb<RemoteWebElement>(new ChromeDriver()));
    }

}

