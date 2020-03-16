package org.Console.testcases.google;

import java.util.List;

import org.EyeOfHarmony.Supernova.Spark;
import org.Pool.pages.Page;
import org.Pool.pages.google.Home;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class GoogleSearchAlt extends Spark {

    Page page; 
    String query; 
    
    @BeforeClass
    public void initPageObjects() { 
        page = new Page(driver,spin); 
        query = "Automation is awesome!";
    }
    
    @Parameters("query")
    @Test
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
        page.initPage(Home.class).loadPage();
    }
    
    protected void enterSearchQuery() {
        page.initPage(Home.class).enterSearchQuery(query)
        .clickSearch();
        
    }
    
    protected  void checkSearchResults() {
        List<WebElement> eles = page.initPage(Home.class).getResultList();
        Assert.assertTrue(eles.size() > 0 , "Did not find any results");
       
    }
}
