package org.Pool.pages.google;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.pages.BasePage;

public class GoogleHomePage extends BasePage {

    public GoogleHomePage(DriverModule<?>  driver, Spin spin) {
        super(driver, spin);
    }
    

    public GoogleHomePage loadPage() { 
        System.out.println("Testing Environment: " + spin.environment().getDomain());
        driver.get(spin.environment().getDomain());
        return this;
    }
    
    public GoogleHomeSearchPage search() { 
        return pf.init(GoogleHomeSearchPage.class); 
    }
    
    public GoogleSearchResults search(String query) { 
        new GoogleHomeSearchPage(driver,spin).enterSearchQuery(query).clickSearch();
        return pf.init(GoogleSearchResults.class); 
    }
    
    public GoogleHomeHeader header() { 
        return pf.init(GoogleHomeHeader.class); 
    }
    
    public GoogleHomeFooter footer() { 
        return new GoogleHomeFooter(driver,spin ); 
    }
    
    
}
