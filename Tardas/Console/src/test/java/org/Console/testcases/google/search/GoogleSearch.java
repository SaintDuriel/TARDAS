package org.Console.testcases.google.search;

import java.util.List;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.pages.Page;
import org.Pool.pages.google.GoogleHomePage;
import org.Pool.pages.google.GoogleSearchResults;
import org.Pool.pages.google.elements.SearchResult;
import org.testng.Assert;
public class GoogleSearch extends Search {

    Page page; 
    GoogleHomePage home; 
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
        page.initPage(GoogleHomePage.class).loadPage();
    }
    @Override
    protected void enterSearchQuery() {
        page.initPage(GoogleHomePage.class).search(query);
        
    }
    @Override
    protected  void checkSearchResults() {
        List<SearchResult> eles = page.initPage(GoogleSearchResults.class).getSearchResults();
        Assert.assertTrue(eles.size() > 0 , "Did not find any results");
       for(int ndx = 0; ndx < eles.size(); ndx++) { 
           SearchResult result = eles.get(ndx); 
           System.out.println("Result ("+ndx+"):"
                   + result.toString());
       }
    }
}
