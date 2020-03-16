package org.EyeOfHarmony.Seed;

import org.ChameleonArch.browsers.Browsers;
import org.EyeOfHarmony.Seed.BlackHole.HostPlatform;
import org.EyeOfHarmony.Seed.BlackHole.TestType;

public class SpinBuilder extends Black {

    
    /**
     * Spin Builder constructor that creates a default instance <br>
     * of the Spin class. You will inherit default configurations <br>
     * from the src/test/resouces/*.properties files. <br><br>
     * Also this will still abide by Command Line argument overrides <br>
     * if any were used to trigger the execution. 
     */
    public SpinBuilder() { 
        
    }
    
    public SpinBuilder setLocal() { 
        this.isTestLocal = true; 
        return this;
    }
    
    public SpinBuilder setBrowser(Browsers browser) { 
        this.browserName = browser.toString();
        return this;
    }
    
    public SpinBuilder setBrowserVersion(String browserVersion) { 
        this.browserVersion = browserVersion; 
        return this;
    }
    
    public SpinBuilder setTestConfigFile(String configFile) { 
       this.configFileName = configFile;
       return this;
    }
    
    public SpinBuilder setBrowserConfigFile(String browserConfig) { 
        this.browserFileName = browserConfig; 
        return this;
    }
    
    public SpinBuilder setDeviceConfigFile(String deviceFile) { 
        this.deviceFileName = deviceFile; 
        return this;
    }
    
    public SpinBuilder setEnvironmentConfigFile(String environmentFile) { 
        this.environmentFileName = environmentFile; 
        return this;
    }
    
    public SpinBuilder setAndroidPackage(String ap)
    {      
        this.androidPackage = ap;
        return this;
    }
    
    public SpinBuilder setAndroidActivity(String aa) { 
        this.androidActivity = aa; 
        return this;
    }

    public SpinBuilder setTestEnvironment(String testEnvironment) { 
        this.appTestEnvironment = testEnvironment; 
        return this;
    }
    
    public SpinBuilder setBundleId(String bundleId) { 
        this.bundleId = bundleId; 
        return this;
    }
    
    public SpinBuilder setCloudEnvironment(String cloudEnvironment) { 
        this.cloudEnvironment = cloudEnvironment;
        return this;
    }
    
    public SpinBuilder setDeviceId(String deviceId) { 
        this.deviceId = deviceId; 
        return this;
    }
    
    public SpinBuilder setDeviceName(String deviceName) { 
        this.deviceName = deviceName; 
        return this;
    }
    
    public SpinBuilder setHostPlatform(HostPlatform hostPlatform) { 
        this.hostPlatform = hostPlatform.toString(); 
        return this;
    }
    
    public SpinBuilder setTestType(TestType testType) { 
        this.testType = testType.toString(); 
        return this;
    }
    
    public Spin build() { 
        return new Spin(this); 
    }
}
