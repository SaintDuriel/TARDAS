package org.Console.testcases.google.login;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;

public abstract class LoginBase extends LoginTemplate{

    protected String username; 
    protected String password; 
    private static final String defUsername ="matthew.jordan.johns@gmail.com"; 
    private static final String defPassword = ""; 
    public LoginBase() {     
    }
    
    public LoginBase(DriverModule<?> driver, Spin spin) { 
       this(driver,spin,null,null); 
    }
    
    public LoginBase(DriverModule<?> driver_, Spin spin_, String username_, String password_) { 
        driver = driver_; 
        spin = spin_; 

        setUsername(username); 
        setPassword(password); 
    }
    
    private final void setUsername(String username_)  {
        username = username_ == null ? defUsername : username_; 
    }
    
    private final void setPassword(String password_) { 
        password = password_ == null ? defPassword : password_; 
    }
}
