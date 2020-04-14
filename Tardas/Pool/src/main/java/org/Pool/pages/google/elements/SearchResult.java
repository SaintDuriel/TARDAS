package org.Pool.pages.google.elements;

import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.ChameleonArch.interactions.actions.Sender;
import org.ChameleonArch.interactions.exceptions.ClickException;
import org.Pool.pages.google.GoogleSearchResultElement;
import org.openqa.selenium.WebElement;

public class SearchResult {

    String linkTitle, linkHref, description, citeBreadcrumb, citeBreadcrumbHref; 
    List<RelatedLink> relLinks;
    WebElement link; 
    
    public SearchResult(WebElement ele, GoogleSearchResultElement page) { 
        link = page.resultLink(ele);
        linkHref = page.resultHref(ele); 
        linkTitle = page.resultTitle(ele);
        description = page.resultDescription(ele); 
        citeBreadcrumb = page.resultBreadcrumb(ele);
        citeBreadcrumbHref = page.resultBreadcrumbHref(ele);
    }
    
    public String toString() { 
        String str =  "Title: " + linkTitle
        + "\nDescription: " + description 
        +"\nLink Href: " + linkHref;
        
        str = str + ( citeBreadcrumb == null ? "\nCite Breadcrumb: " + citeBreadcrumb : "" );
        return str; 
    }
    
    public void clickLink(DriverModule<?> driver) {
       try { 
           Sender.click(driver, link);
       } catch (ClickException ce) { 
           
       }
    }
    
    public String title() { 
        return linkTitle; 
    }
    
    public String href() { 
        return linkHref; 
    }
    
    public String description() { 
        return description; 
    }
    
    public String breadcrumbText() { 
        return citeBreadcrumb; 
    }
    
    public String breadcrumbHref() { 
        return citeBreadcrumbHref; 
    }
}
