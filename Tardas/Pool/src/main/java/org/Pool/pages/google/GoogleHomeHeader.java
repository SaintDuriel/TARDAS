package org.Pool.pages.google;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.WebBy;
import org.openqa.selenium.By;

public class GoogleHomeHeader extends GoogleHomePage {

    public GoogleHomeHeader(DriverModule<?> driver, Spin spin) {
        super(driver, spin);
    }
    
    @WebBy(css="#hptl a:nth-child(1)")
    protected By lnkAbout; 
    public void clickAbout() {
        click(lnkAbout); 
    }
    
    @WebBy(css="#hptl a:nth-child(2)")
    protected By lnkStore; 
    public void clickStore() { 
        click(lnkStore); 
    }
    
    @WebBy(css="a[data-pid='23']")
    protected By lnkGmail;
    public void clickGmail() { 
        click(lnkGmail); 
    }
    
    @WebBy(css="a[data-pid='2']")
    protected By lnkImage; 
    public void clickImage() { 
        click(lnkImage); 
    }
    
    @WebBy(css="[title='Google apps']")
    protected By btnApps; 
    public void clickApps() { 
        click(btnApps); 
    }
    
    @WebBy(id="gb_70")
    protected By lnkSignIn; 
    public GoogleLoginPage clickSignIn() { 
        click(lnkSignIn); 
        return pf.initLocators(GoogleLoginPage.class);
    }

}
