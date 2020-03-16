package org.Console.testcases.google;

import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.pages.Page;
import org.Pool.pages.google.Home;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class GoogleSearch extends Search {

    Page page; 
    Home home; 
    String query; 
    public GoogleSearch(DriverModule<?> driver, Spin spin, String query_) { 
        page =  new Page(driver,spin);
        query = query_; 
    }
    
    @Override
    protected void focusSearchField() {
        page.initPage(Home.class).loadPage();
    }
    @Override
    protected void enterSearchQuery() {
        page.initPage(Home.class).enterSearchQuery(query)
        .clickSearch();
        
    }
    @Override
    protected  void checkSearchResults() {
        List<WebElement> eles = page.initPage(Home.class).getResultList();
        Assert.assertTrue(eles.size() > 0 , "Did not find any results");
       
    }
}
