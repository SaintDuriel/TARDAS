package org.EyeOfHarmony.Seed;
import static org.Library.Util.compare;

import java.util.Properties;

import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;


/**
 * The spin in the Eye of Harmony essentially is the core of the EOH's configuration. 
 * <br> The spin class is the 'state and configuration' of the test instance. 
 * <br> For each unique configuration of the test node within your TestNG xml a 
 * <br>Spin object will be created with the Property Configuration of the test. 
 * @author matth
 *
 */
public class Spin extends BlackHole {
    private static final String DEFAULTCONFIGFILENAME = "testconfig.properties";
    private static final String DEFAULTBROWSERFILENAME = "browser.properties";
    private static final String DEFAULTDEVICEFILENAME = "mobile.properties";
    private static final String DEFAULTENVIRONMENTFILENAME = "environment.properties";
    public Properties getTestConfig() { 
        return configProp;
    }

    public Properties getBrowserConfig() { 
        return browserProp;
    }

    public Properties getDeviceConfig() { 
        return deviceProp;
    }

    public Properties getEnvironmentConfig() { 
        return environmentProp;
    }


    /**
     * Default No-Arg constructor to get default values, or values from system variable inputs.<br>
     * This provided for the SpinBuilder. 
     */
    protected Spin() { 
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    protected Spin(Black black) { 
        this(black,LogLevel.INFO.toString());
    }

    protected Spin(Black black, String logLevel) { 
        this(black.isTestLocal, black.configFileName, black.browserFileName, black.deviceFileName, black.environmentFileName, 
                black.testType, black.appTestEnvironment, black.cloudEnvironment, black.browserName, black.browserVersion
                , black.deviceName, black.hostPlatform, black.androidPackage, black.deviceId, black.bundleId, black.androidActivity, logLevel);
    }

    public Spin(Boolean isTestLocal, String testConfigFile, String browserConfigFile, String deviceConfigFile, 
            String environmentConfigFile, String testType, String appTestEnvironment
            , String cloudEnvironment, String browserName, String browserVersion, String deviceName
            , String hostPlatform, String androidPackage, String deviceId, String deviceAppBundleId, String deviceMainActivty, String logLevel) 
    { 
        this.logLevel = compare(logLevel,this.logLevel);
        Clapper.setLogLevel(this.logLevel());
        configFileName = 
                compare(PropertyKeys.TESTCONFIGFILE.retrieveSystemValue(), compare(testConfigFile, DEFAULTCONFIGFILENAME));
        browserFileName = compare(PropertyKeys.BROWSERCONFIGFILE.retrieveSystemValue(), compare(browserConfigFile,DEFAULTBROWSERFILENAME ));
        deviceFileName = 
                compare(PropertyKeys.DEVICECONFIGFILE.retrieveSystemValue(), compare(deviceConfigFile,DEFAULTDEVICEFILENAME));
        environmentFileName = 
                compare(PropertyKeys.ENVIRONMENTCONFIGFILE.retrieveSystemValue(), compare(environmentConfigFile,DEFAULTENVIRONMENTFILENAME ));
        configProp =  loadPropertyFile(configFileName );
        browserProp = loadPropertyFile(browserFileName );
        deviceProp =  loadPropertyFile(deviceFileName);
        environmentProp =  loadPropertyFile(environmentFileName);

        this.isTestLocal = compare(isTestLocal, this.isTestLocal);
        this.testType = compare(testType, this.testType);
        this.appTestEnvironment = compare(appTestEnvironment, this.appTestEnvironment);
        this.cloudEnvironment = compare(cloudEnvironment, this.cloudEnvironment);
        this.browserName = compare(browserName, this.browserName);
        this.hostPlatform = compare(hostPlatform, this.hostPlatform);
        this.deviceId = compare(deviceId, this.deviceId);
        this.deviceName = compare(deviceName, this.deviceName);
        this.bundleId = compare(deviceAppBundleId, this.bundleId); 
        this.androidActivity = compare(deviceMainActivty, this.androidActivity); 
        this.androidPackage = compare(androidPackage, this.androidPackage);


        setInitialValuesFromSystemAndConfig(); 


        Environment.setProperty(environmentProp); 
        Clapper.setLogLevel(this.logLevel());
    }


    public static SpinBuilder builder() { 
        SpinBuilder returnVal = new SpinBuilder();
        return returnVal;
    }



    private void setInitialValuesFromSystemAndConfig() { 
        this.isTestLocal = compare(Boolean.parseBoolean(PropertyKeys.ISTESTLOCAL.retrieveSystemValue()),
                compare(this.isTestLocal, Boolean.parseBoolean(PropertyKeys.ISTESTLOCAL.retrieveConfigValue(configProp))));

        this.testType = compare(PropertyKeys.TESTTYPE.retrieveSystemValue(),
                compare(this.testType,PropertyKeys.TESTTYPE.retrieveConfigValue(configProp)));

        this.cloudEnvironment = compare(PropertyKeys.CLOUDENVIRONMENT.retrieveSystemValue(),
                compare(this.cloudEnvironment, PropertyKeys.CLOUDENVIRONMENT.retrieveConfigValue(configProp)));

        this.appTestEnvironment = compare(PropertyKeys.APPTESTENVIRONMENT.retrieveSystemValue(),
                compare(this.appTestEnvironment, PropertyKeys.APPTESTENVIRONMENT.retrieveConfigValue(configProp)));

        this.browserName = compare(PropertyKeys.BROWSERNAME.retrieveSystemValue(),
                compare(this.browserName,PropertyKeys.BROWSERNAME.retrieveConfigValue(browserProp)));

        this.browserVersion = compare(PropertyKeys.BROWSERVERSION.retrieveSystemValue(),
                compare(this.browserVersion, PropertyKeys.BROWSERVERSION.retrieveConfigValue(browserProp)));

        this.bundleId = compare(PropertyKeys.BUNDLEID.retrieveSystemValue(),
                compare(this.bundleId, PropertyKeys.BUNDLEID.retrieveConfigValue(deviceProp)));

        this.deviceId = compare(PropertyKeys.DEVICEID.retrieveSystemValue(),
                compare(this.deviceId, PropertyKeys.DEVICEID.retrieveConfigValue(deviceProp)));

        this.deviceName = compare(PropertyKeys.DEVICENAME.retrieveSystemValue(),
                compare(this.deviceName, PropertyKeys.DEVICENAME.retrieveConfigValue(deviceProp)));

        this.androidActivity = compare(PropertyKeys.ANDROIDACTIVITY.retrieveSystemValue(),
                compare(this.androidActivity, PropertyKeys.ANDROIDACTIVITY.retrieveConfigValue(deviceProp)));

        this.hostPlatform = compare(PropertyKeys.HOSTPLATFORM.retrieveSystemValue(),
                compare(this.hostPlatform, PropertyKeys.HOSTPLATFORM.retrieveConfigValue(configProp)));

        this.logLevel = compare(PropertyKeys.LOGLEVEL.retrieveSystemValue(), 
                compare(this.logLevel, PropertyKeys.LOGLEVEL.retrieveConfigValue(configProp)));

    }


}
