package org.Console.testcases.google;

import java.util.List;

import org.Pool.pages.Page;
import org.Pool.pages.google.GoogleSearchHome;
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
        page.initPage(GoogleSearchHome.class).loadPage();
    }
    
    protected void enterSearchQuery() {
        page.initPage(GoogleSearchHome.class).enterSearchQuery(query);
    }
    
    protected  void checkSearchResults() {
        List<WebElement> eles = page.initPage(GoogleSearchHome.class).clickSearch().getResultList();
        Assert.assertTrue(eles.size() > 0 , "Did not find any results");
    }
}
