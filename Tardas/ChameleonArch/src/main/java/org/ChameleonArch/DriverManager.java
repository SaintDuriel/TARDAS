package org.ChameleonArch;

import org.ChameleonArch.interactions.DriverModule;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class DriverManager {
    
    public DriverManager() { 
        WebDriverManager.globalConfig().setTargetPath("WebDriver");
    }

    protected ThreadLocal<DriverModule<?>> driver = new ThreadLocal<DriverModule<?>>();

    protected abstract void startService();

    protected abstract void stopService();

    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver.get()) {
            driver.get().quit();
            driver = null;
        }

    }

    public DriverModule<?> getDriver() {
       
        if (null == driver.get()) {
            startService();
            createDriver();
        }
        return driver.get();
    }
}
