package org.Console.testcases.google;

import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.pages.Page;
import org.Pool.pages.google.GoogleSearchHome;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class GoogleSearch extends Search {

    Page page; 
    GoogleSearchHome home; 
    String query; 
    public GoogleSearch(String query_) { 
        query = query_; 
    }
    public GoogleSearch(DriverModule<?> driver, Spin spin, String query_) { 
        page =  new Page(driver,spin);
        query = query_; 
    }
    private void initPage() { 
        if(page == null) { 
            page = new Page(driver,spin); 
        }
    }
    
    @Override
    protected void focusSearchField() {
        initPage();
        page.initPage(GoogleSearchHome.class).loadPage();
    }
    @Override
    protected void enterSearchQuery() {
        page.initPage(GoogleSearchHome.class).enterSearchQuery(query);
        
    }
    @Override
    protected  void checkSearchResults() {
        List<WebElement> eles = page.initPage(GoogleSearchHome.class).clickSearch().getResultList();
        Assert.assertTrue(eles.size() > 0 , "Did not find any results");
       
    }
}
