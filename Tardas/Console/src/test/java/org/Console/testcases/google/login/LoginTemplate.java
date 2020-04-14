package org.Console.testcases.google.login;

import org.EyeOfHarmony.Supernova.Spark;
import org.testng.annotations.Test;

public abstract class LoginTemplate extends Spark {

    public LoginTemplate() { 
        
    }
    
    public abstract void loadPage(); 
    public abstract void enterUsername(); 
    public abstract void enterPassword(); 
    public abstract void clickLogin(); 
    public abstract void checkForErrors(); 
    
    @Test
    public final void login() { 
        loadPage(); 
        enterUsername(); 
        enterPassword(); 
        clickLogin(); 
        checkForErrors(); 
    }
}
