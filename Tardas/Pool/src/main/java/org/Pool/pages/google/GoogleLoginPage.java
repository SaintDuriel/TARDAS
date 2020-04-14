package org.Pool.pages.google;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.WebBy;
import org.Pool.pages.BasePage;
import org.openqa.selenium.By;

public class GoogleLoginPage extends BasePage {

    public GoogleLoginPage(DriverModule<?> driver, Spin spin) {
        super(driver, spin);
    }

    @WebBy(id="identifierId")
    protected By txtbxEmail; 
    public GoogleLoginPage fillUsername(String username) 
    { 
        sendKeys(txtbxEmail, username); 
        return this; 
    }
    @WebBy(css="input[type='password']")
    protected By txtbxPassword; 
    public GoogleLoginPage fillPassword(String password) { 
        sendKeys(txtbxPassword, password); 
        return this; 
    }
    
    @WebBy(id="identifierNext")
    protected By btnNext; 
    public GoogleLoginPage clickNext() { 
        click(btnNext); 
        return this; 
    }
    
    
    public void login(String username, String password) 
    {
        fillUsername(username); 
        clickNext(); 
        fillPassword(password); 
        clickNext(); 
    }
    @Override
    public GoogleLoginPage loadPage() {
        String url = "https://accounts.google.com/signin/v2/"
                + "identifier?hl=en&passive=true&continue="
                + "https%3A%2F%2Fwww.google.com%2F&"
                + "flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        driver.get(url);
        return this;
    }

}
