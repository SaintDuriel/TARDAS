package org.Console.testcases.google.search;

import java.util.List;

import org.Pool.pages.Page;
import org.Pool.pages.google.GoogleHomePage;
import org.Pool.pages.google.GoogleSearchResults;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
public class GoogleSearchAlt extends Search {

    Page page; 
    String query; 
    
    @BeforeClass
    public void initPageObjects() { 
        page = new Page(driver,spin); 
        query = "Automation is awesome!";
    }
    
    public void searchGoogle(@Optional String query) { 
        if(query != null) {
            this.query = query;
        } else { 
            this.query = "NULL QUERY";
        }
        
        System.err.println("HOST PLATFORM: " + spin.hostPlatform());
        focusSearchField(); 
        enterSearchQuery(); 
        checkSearchResults(); 
    }
    
    
    protected void focusSearchField() {
        page.initPage(GoogleHomePage.class).loadPage();
    }
    
    protected void enterSearchQuery() {
        page.initPage(GoogleHomePage.class).search(query);
    }
    
    protected  void checkSearchResults() {
        List<WebElement> eles = page.initPage(GoogleSearchResults.class).getResultList();
        Assert.assertTrue(eles.size() > 0 , "Did not find any results");
    }
}
