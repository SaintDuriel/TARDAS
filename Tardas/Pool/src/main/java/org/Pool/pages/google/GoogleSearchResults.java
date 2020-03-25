package org.Pool.pages.google;

import java.time.Duration;
import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.IOSWeb;
import org.Pool.annotations.WebBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleSearchResults extends GoogleSearchHome {

    public GoogleSearchResults(DriverModule<?>  driver, Spin spin) {
        super(driver, spin);
    }
    
    @WebBy(className="rc")
    @IOSWeb(className="rc")
    public By lstResults;
    public List<WebElement> getResultList() { 
        return findElements(lstResults, Duration.ofSeconds(25));
    }

    
    
    
    
}
