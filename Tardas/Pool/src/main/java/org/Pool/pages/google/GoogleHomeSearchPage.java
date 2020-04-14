package org.Pool.pages.google;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.IOSWeb;
import org.Pool.annotations.WebBy;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GoogleHomeSearchPage extends GoogleHomePage {

    
    public GoogleHomeSearchPage(DriverModule<?> driver, Spin spin) {
        super(driver, spin);
        // TODO Auto-generated constructor stub
    }

    @WebBy(css="input[name='q']")
    @IOSWeb(css="input[name='q'] mobile skimmer")
    public By searchField; 
    public GoogleHomeSearchPage enterSearchQuery(String query) { 
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
