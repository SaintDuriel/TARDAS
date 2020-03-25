package org.Pool.pages.google;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.IOSWeb;
import org.Pool.annotations.WebBy;
import org.Pool.pages.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GoogleSearchHome extends BasePage {

    public GoogleSearchHome(DriverModule<?>  driver, Spin spin) {
        super(driver, spin);
    }
    

    public GoogleSearchHome loadPage() { 
        System.out.println("Testing Environment: " + spin.environment().getDomain());
        driver.get(spin.environment().getDomain());
        return this;
    }
    
    @WebBy(css="input[name='q']")
    @IOSWeb(css="input[name='q'] mobile skimmer")
    public By searchField; 
    public GoogleSearchHome enterSearchQuery(String query) { 
        Assert.assertTrue(sendKeys(searchField, query), "Failed to enter search query");
        return this;
    }
    
    @WebBy(css="input[name='btnK']")
    @IOSWeb(css="input[name='btnK']")
    public By searchButton; 
    public GoogleSearchResults clickSearch() { 
        click(searchButton);
        return pf.initLocators(GoogleSearchResults.class);
    }
    
    
}
