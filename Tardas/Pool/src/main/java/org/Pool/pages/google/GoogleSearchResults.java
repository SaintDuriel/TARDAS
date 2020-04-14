package org.Pool.pages.google;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.IOSWeb;
import org.Pool.annotations.WebBy;
import org.Pool.pages.google.elements.SearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleSearchResults extends GoogleHomePage {

    public GoogleSearchResults(DriverModule<?>  driver, Spin spin) {
        super(driver, spin);
    }
    
    @WebBy(className="rc")
    @IOSWeb(className="rc")
    protected By lstResults;
    public List<WebElement> getResultList() { 
        return findElements(lstResults, Duration.ofSeconds(25));
    }
    
    public List<SearchResult> getSearchResults() { 
        List<SearchResult> results = new ArrayList<SearchResult>(); 
        for(WebElement ele : getResultList()) {
            results.add(getSearchResult(ele)); 
        }
        return results; 
    }
    
    private SearchResult getSearchResult(WebElement ele) { 
        return new SearchResult(ele, pf.init(GoogleSearchResultElement.class)); 
    }
    
    @WebBy(css = ".r h3")
    protected By resultTitle; 
    
    @WebBy(css= ".s .st")
    protected By resultDescription; 
    
    @WebBy(css= ".r cite")
    protected By resultBreadcrumb; 
    
    @WebBy(className = "fl")
    protected By resultRelatedLinks; 
    
    @WebBy(id="result-stats")
    protected By txtTotalResults;
    public String getTotalResultCount() { 
        return getText(txtTotalResults); 
    }
    
    
    
    
}
