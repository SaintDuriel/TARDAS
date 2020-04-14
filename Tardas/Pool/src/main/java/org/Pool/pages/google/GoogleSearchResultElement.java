package org.Pool.pages.google;

import java.util.ArrayList;
import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.ChameleonArch.interactions.actions.Getter;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.WebBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleSearchResultElement extends GoogleSearchResults {

    public GoogleSearchResultElement(DriverModule<?>  driver, Spin spin) {
        super(driver, spin);
    }
    
    @WebBy(css=".r a")
    protected By resultLink; 
    public WebElement resultLink(WebElement ele) { 
        return findContextElement(ele, resultLink);
    }
    public String resultHref(WebElement ele) { 
        return Getter.getAttribute(findContextElement(ele, resultLink), "href");
    }
   
    @WebBy(css = ".r h3")
    protected By resultTitle; 
    public String resultTitle(WebElement ele) {
        return Getter.getText(findContextElement(ele, resultTitle));
    }
    
    @WebBy(css= ".s .st")
    protected By resultDescription; 
    public String resultDescription(WebElement ele) { 
        return Getter.getText(findContextElement(ele, resultDescription)); 
    }
    
    @WebBy(css= ".r a cite")
    protected By resultBreadcrumb; 
    public String resultBreadcrumb(WebElement ele) { 
        return Getter.getText(findContextElement(ele, resultBreadcrumb)); 
    }
    public String resultBreadcrumbHref(WebElement ele) { 
        return Getter.getAttribute(findContextElement(ele, resultBreadcrumb), "href");
    }
    
    @WebBy(className = "fl")
    protected By resultRelatedLinks; 
    public List<WebElement> getRelatedLinks(WebElement ele) { 
        return new ArrayList<WebElement>(); 
    }
    
}
