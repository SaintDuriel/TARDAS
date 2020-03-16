package org.Pool.pages.google;

import java.time.Duration;
import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.IOSWeb;
import org.Pool.annotations.WebBy;
import org.Pool.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Home extends BasePage {

    public Home(DriverModule<?>  driver, Spin spin) {
        super(driver, spin);
    }
    

    public Home loadPage() { 
        System.out.println("Testing Environment: " + spin.environment().getDomain());
        driver.get(spin.environment().getDomain());
        return this;
    }
    
    @WebBy(css="input[name='q']")
    @IOSWeb(css="input[name='q'] mobile skimmer")
    public By searchField; 
    public Home enterSearchQuery(String query) { 
        if(sendKeys(searchField,query)) {
            
        }
        return this;
    }
    
    @WebBy(css="input[name='btnK']")
    @IOSWeb(css="input[name='btnK']")
    public By searchButton; 
    public Home clickSearch() { 
        driver.click(searchButton);
        return this;
    }
    
    @WebBy(className="rc")
    @IOSWeb(className="rc")
    public By lstResults;
    public List<WebElement> getResultList() { 
        return driver.findElements(lstResults, Duration.ofSeconds(25));
    }

    
    
    
    
}
