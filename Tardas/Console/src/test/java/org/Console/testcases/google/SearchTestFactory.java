package org.Console.testcases.google;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class SearchTestFactory {

    @Factory//(dataProvider="searchData")
    public  Object[] searchFactory() { 
       String[] searchs = {"Hurray from a factory", "there's no way it worked", "Try again"}; 
       List<Object> thgs = new ArrayList<Object>(); 
        for(String s : searchs )  {
            thgs.add(new GoogleSearch(s)); 
        }
        
        System.out.println("Created "+  thgs.size() + " test instances?");
        return thgs.toArray();
    }
    
    @DataProvider(name="searchData")
    public String[] searchData() { 
        String[] searchs = {"Hurray from a factory", "there's no way it worked", "Try again"}; 
        
        return searchs; 
    }
    
}
