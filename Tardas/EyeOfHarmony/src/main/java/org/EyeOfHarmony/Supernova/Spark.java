package org.EyeOfHarmony.Supernova;

import org.ChameleonArch.DriverManager;
import org.ChameleonArch.DriverManagerFactory;
import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * The Spark is the ignition point of each test instance All tests should extend
 * from the Spark, as this will handle the driver initialization reading of all
 * input parameters that are supported etc.
 * 
 * @author matth
 *
 */
public class Spark {

    protected DriverModule<?> driver;
    private DriverManager dmf;
    protected Spin spin; 
    /**
     * Dear god lets hope we never have to touch this. 
     * 
     * We can think of this as the MASTER print for the whole SUITE of tests. 
     * 
     * Now, how we define what the whole suite is... We'll need to figure that out. 
     * 
     * @param isTestLocal - This flag will set all the driver instances to be LOCAL to the machine, and not use any remote service.
     * @param testConfigFile - @see 'EyeOfHarmony/src/test/resources/config.properties' for default configuration.
     * @param browserConfigFile @see 'EyeOfHarmony/src/test/resources/browser.properties' for default configuration. 
     * @param deviceConfigFile @see 'EyeOfHarmony/src/test/resources/device.properties' for default configuration.
     * @param environmentConfigFile @see 'EyeOfHarmony/src/test/resources/environment.properties' for default configuration. 
     * @param testType
     * @param appTestEnvironment
     * @param testExecutionEnvironment
     * @param browserName
     * @param browserVersion
     * @param deviceName
     * @param hostPlatfrom
     * @param androidPackage
     * @param deviceId
     * @param deviceAppBundleId
     * @param deviceMainActivty
     */
    @Parameters({"isTestLocal" , "testConfigFile" , "browserConfigFile" , "deviceConfigFile" ,
        "environmentConfigFile" , "testType" , "testEnvironment" , "cloudEnvironment" , 
        "browserName" , "browserVersion" , "deviceName" , "hostPlatform" , "androidPackage" , "deviceId" , 
        "deviceAppBundleId" , "deviceMainActivty", "logLevel"})
    @BeforeSuite
    public void retrieveConfigurations(@Optional String isTestLocal, @Optional String testConfigFile, @Optional String browserConfigFile, @Optional String deviceConfigFile, 
            @Optional String environmentConfigFile, @Optional String testType, @Optional String testEnvironment
            , @Optional String cloudEnvironment, @Optional String browserName, @Optional String browserVersion, @Optional String deviceName
            , @Optional String hostPlatform, @Optional String androidPackage, @Optional String deviceId, @Optional String deviceAppBundleId, @Optional String deviceMainActivty, @Optional String logLevel) {

        Boolean localTest = Boolean.valueOf(isTestLocal != null ? isTestLocal : "true");
        spin = new Spin(localTest, testConfigFile, browserConfigFile, deviceConfigFile, environmentConfigFile, testType, testEnvironment,
                cloudEnvironment, browserName, browserVersion, deviceName, hostPlatform, androidPackage, deviceId, deviceAppBundleId, deviceMainActivty, logLevel);
    }



    @BeforeClass
    public void parseClassLevelParameters(@Optional String isTestLocal, @Optional String testConfigFile, @Optional String browserConfigFile, @Optional String deviceConfigFile, 
            @Optional String environmentConfigFile, @Optional String testType, @Optional String testEnvironment
            , @Optional String cloudEnvironment, @Optional String browserName, @Optional String browserVersion, @Optional String deviceName
            , @Optional String hostPlatform, @Optional String androidPackage, @Optional String deviceId, @Optional String deviceAppBundleId, @Optional String deviceMainActivty, @Optional String logLevel) {

        Boolean localTest = Boolean.valueOf(isTestLocal != null ? isTestLocal : "true");
        spin = new Spin(localTest, testConfigFile, browserConfigFile, deviceConfigFile, environmentConfigFile, testType, testEnvironment,
                cloudEnvironment, browserName, browserVersion, deviceName, hostPlatform, androidPackage, deviceId, deviceAppBundleId, deviceMainActivty, logLevel);

        dmf = DriverManagerFactory.getManager(spin.browserName());
        driver = dmf.getDriver();
    }

    @BeforeTest
    public void beforeTestInitialization() {

    }

    @AfterSuite
    public void teardownAllInstances() {
        dmf.quitDriver();
    }
    
    @AfterClass
    public void tearDownInstance() { 
        dmf.quitDriver(); 
    }
}
