package org.EyeOfHarmony.Seed;

import java.util.Properties;

/**
 * Property Keys enum is a reference for the names of the configurable properties.<br>
 * Has methods for fetching the variable value from the System, and coniguration files.<br>
 * Needs to have XML values input in order to store a value for a run. However; given the nature of enums<br>
 * it's not recommended to have the enum's storing the value.
 * @author matth
 *
 */
public enum PropertyKeys {
    TESTCONFIGFILE("testConfigFile"), 
    BROWSERCONFIGFILE("browserConfigFile"), 
    DEVICECONFIGFILE("deviceConfigFile"),
    ENVIRONMENTCONFIGFILE("environmentConfigFile"),
    CLOUDENVIRONMENT("cloudEnvironment"),
    APPTESTENVIRONMENT("appTestEnvironment"),
    BROWSERNAME("browserName"),
    BROWSERVERSION("browserVersion"),
    HOSTPLATFORM("hostPlatform"), 
    DEVICEID("deviceId"),
    DEVICENAME("deviceName"),
    ANRDROIDPACKAGE("androidPackage"),
    ANDROIDACTIVITY("androidActivity"),
    BUNDLEID("bundleId"), 
    TESTTYPE("testType"),
    ISTESTLOCAL("isTestLocal"), 
    APPURLORPATH("app"),
    LOGLEVEL("logLevel");
    
    String propKey;

    PropertyKeys(String propertyKey) {
        propKey = propertyKey;
    }

    public String getPropertyKey() {
        return this.propKey;
    }

    public String retrieveSystemValue() {
        try {
            return System.getProperty(getPropertyKey());
        } catch (SecurityException se) {
            System.err
                    .println("Encountered a Security Issue. Review Stack Trace and debug if you know you set this key");
            se.printStackTrace();
        } catch (NullPointerException npe) {
            //TODO: meh, that's cool.
        } catch (IllegalArgumentException iae) {
            //TODO: meh, that's cool.
        }
        return null;
    }

    public String retrieveConfigValue(Properties propFile) {
        if(propFile == null) { 
            System.err.println("Property File is Null");
        }
        return propFile.getProperty(this.getPropertyKey());
    }

}
