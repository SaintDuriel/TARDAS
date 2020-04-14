package org.EyeOfHarmony.Seed;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.ChameleonArch.browsers.Browsers;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.Library.FileLoader;
import org.Library.SystemHelper;

public abstract class BlackHole extends Black {

    /**
     * Enum to flag to driver manager if it should return a <br>
     * web browser or prepare to automate a native mobile app.
     * 
     * @author matth
     *
     */
    public enum TestType {
        BROWSER, APP;
    }

    /**
     * Enum to flag to driver manager which host platform <br>
     * it should return a driver instance for. <br><br>
     * 
     * If WINDOWS is selected the DriverManager should make an effort<br>
     * to connect to a browser session that has Windows 10 as it's <br>
     * system. <br><br>
     * 
     * If OSX is selected the DriverManager should make an effort<br>
     * to connect to a browser session that has OS X as it's host<br>
     * operating system.
     *
     * 
     * NOTE: In local configurations you will always be returned <br>
     * system specific browser for your local host machine.<br>
     * 
     * @author matth
     *
     */
    //TODO: Consider adding alternate WINOWS support for 7X and up???? 
    //TODO: Consider NIX? 
    public enum HostPlatform {
        WINDOWS, OSX, UNIX, ANDROID, IOS;
        
        public static HostPlatform platformExecutingTest() { 
            
            String os = SystemHelper.getHostOperatingSystem();
            if(os.contains("windows")) {
                return HostPlatform.WINDOWS;
            } else if (os.contains("os x") || os.contains("osx")) {
                return HostPlatform.OSX;
            } else if (os.contains("nix")) {
                return HostPlatform.UNIX;
            }
            System.err.println("Unable to determine Host Operating System. Returning null");
            return null; 
        }
    }

    public enum Environment {
        DEV, QA, STAGE, PROD;
    
        static Properties environmentProperty;
        public static void setProperty(Properties propFile) { 
            Environment.environmentProperty = propFile; 
        }
        public String getDomain(Properties propFile) {
            return propFile.getProperty(this.toString() + "domainURL");
        }
        public String getDomain() {
            if(environmentProperty == null) { 
                System.err.println("Environment Property File is Null. You get Google");
                return "https://www.google.com";
            }
            return environmentProperty.getProperty(this.name() + "domainURL");
        }
    }

    public BlackHole() {
        super();
    }

    /**
     * Returns the configuration if the test is running locally. 
     * This will override any other configuration properties<br>
     * that may determine to run on a cloud service. <br> 
     * This means that you'll only be given a browser that<br>
     * your local machine is capable of running. 
     * @return
     */
    public Boolean isTestLocal() { 
        return isTestLocal; 
    }

    protected void setTestLocal() { 
        isTestLocal = true; 
    }
    
    public Environment environment() { 
        return Environment.valueOf(appTestEnvironment.toUpperCase());
    }

    public TestType testType() {
        return TestType.valueOf(testType.toUpperCase());
    }

    protected void testType(String testType) { 
        this.testType = testType; 
    }
    
    public Browsers browserName() {
        return Browsers.valueOf(browserName.toUpperCase());
    }

    protected void browser(String browserName) { 
        if(browserName != null) { 
            this.browserName = browserName; 
        }
    }

    public HostPlatform hostPlatform() {
        return HostPlatform.valueOf(hostPlatform.toUpperCase());
    }

    protected void hostPlatform(String hostPlatform) { 
        if(hostPlatform != null ) { 
            this.hostPlatform = hostPlatform; 
        }
    }
    
    public LogLevel logLevel() { 
        return LogLevel.valueOf(logLevel.toUpperCase()); 
    }

    public String deviceId() {
        return deviceId;
    }

    public void deviceId(String deviceId) { 
        if(deviceId != null) { 
            this.deviceId = deviceId; 
        }
    }

    public String deviceName() {
        return deviceName;
    }

    protected void deviceName(String deviceName) { 
        if(deviceName != null) {
            this.deviceName = deviceName; 
        }
    }

    public String bundleId() {
        return bundleId;
    }

    protected void bundleId(String bundleId) { 
        if(bundleId != null) { 
            this.bundleId = bundleId; 
        }
    }

    public String androidActivity() {
        return androidActivity;
    }

    protected void androidActivity(String aa) { 
        if (aa != null) { 
            androidActivity = aa; 
        }
    }

    public String androidPackage() {
        return androidPackage;
    }

    protected void androidPackage(String ap) { 
        if (ap != null) { 
            androidPackage = ap; 
        }
    }
    
    

  

    protected Properties loadPropertyFile(String fileName) { 
    	Properties prop = new Properties(); 
    	String[] strArr = {"EyeOfHarmony", "src", "main", "java", "resources", fileName};
    	String filePath = SystemHelper. getSystemSafeFilePath(strArr);
    	String resourcePath = SystemHelper.getProjectDir().concat(filePath);

    	File propFile = FileLoader.loadFile(resourcePath);
    	FileInputStream fsI = FileLoader.loadFileInputStream(propFile);
    	try {
    		if (fsI != null) { 
    			prop.load(fsI);
    			fsI.close();
    		}
    	} catch (IOException e) {
    	    Clapper.log(LogLevel.ERROR, "Property File is not accessible or present\nFile Path:" +resourcePath);
    		Clapper.log(LogLevel.DEBUG, e.getLocalizedMessage());
    	}
    	
    	if(prop.isEmpty()) {
    	    System.err.println();
    	    Clapper.log(LogLevel.ERROR, "Property File is empty");
    	}
    	
    	Clapper.log(LogLevel.DEBUG, "Loaded Property File: " + resourcePath);
    	return prop; 
    }

    protected void setProperties(Properties property, String fileName) { 
    	property = loadPropertyFile(fileName);
    }

}