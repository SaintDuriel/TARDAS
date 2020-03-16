package org.EyeOfHarmony.Seed;

import java.util.Properties;

import org.CloisterBell.enumTypes.LogLevel;

public abstract class Black {

    /**
     * Variable to control if tests should be initialized locally.<br>
     * When true this may override or ignore certain configuration parameters based on the system executing the test<br>
     * If test is running locally and the hostPlatform is configured as WINDOWS, but the real system executing the test is MAC OSX the hostPlatform configuration parameter would have to be ignored.
     */
    protected Boolean isTestLocal;
    
    protected String configFileName; 
    protected String browserFileName; 
    protected String deviceFileName; 
    protected String environmentFileName; 

    protected Properties environmentProp;
    protected Properties configProp;
    protected Properties browserProp;
    protected Properties deviceProp;
    /**
     * This would be test environments. 
     * Dev, QA, Stage, or other internally named environment. 
     */
    protected String appTestEnvironment = null;
    /**
     * Test Plan Execution should be overriden by the isTestLocal variable. <br>
     * Otherwise this could  match to any of th epossible cloud services that could be implemented. <br>
     * EX. MobileLabs, ExperiTest, SauceLabs, Browserstack ...
     */
    protected String cloudEnvironment = null;
    /**
     * Variable to control what type of test to be executed. 
     * <br>
     * Browser, App
     */
    protected String testType = null;
    /**
     * Browser name, sane inputs to expect would be
     * Chrome, Firefox, IE11, Edge, Safari
     * Browsers that support headless will be appended with HL
     * Other possible browsers could be PhantonJS, or other non standarad browseers
     */
    protected String browserName = null;
    protected String browserVersion = null;
    /**
     * Likely values: WINDOWS, OSX, ANDROID, IOS
     * Should NIX? environments be supported?
     */
    protected String hostPlatform = null;
    /**
     * Assumed input to be null, and utilize latest release version? 
     */
    protected String deviceId = null;
    protected String deviceName = null;
    protected String bundleId = null;
    protected String androidActivity = null;
    protected String androidPackage = null;
    protected String logLevel = LogLevel.INFO.toString();
    public Black() {
    }
 
    
    @Override 
    public String toString() { 
        return "Test Configuration File: " + this.configFileName
                +"\nBrowser Configuration File: " + this.browserFileName
                +"\nDevice Configuration File: " + this.deviceFileName
                +"\nEnvironment Configuration File: " + this.environmentFileName
                + "\nIs Test Running Locally: " + isTestLocal
                +"\nLogging Level: " + logLevel
                +"\nTest Type: " + testType
                +"\nCloud Environment: " + this.cloudEnvironment
                +"\nTest Environment: " + this.appTestEnvironment
                +"\nBrowser Name: "+ this.browserName
                +"\nBrowser Version: " + this.browserVersion
                +"\nHost Platform: " + this.hostPlatform
                +"\nDevice ID: " + this.deviceId
                +"\nDevice Name: " + this.deviceName
                +"\nBundle ID or App Package: " + (bundleId != null ? bundleId : androidPackage != null ? androidPackage : "")
                +"\nAndroid Activity: " + (androidActivity != null ? androidActivity : "");
                
    }

}