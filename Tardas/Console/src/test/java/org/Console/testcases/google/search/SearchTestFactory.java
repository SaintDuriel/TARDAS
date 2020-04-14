package org.Console.testcases.google.search;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class SearchTestFactory {

    @Factory
    public  Object[] searchFactory(Object[] ss) { 
       String[] searchs = {"Hurray from a factory", "there's no way it worked", "Try again"}; 
       List<Object> thgs = new ArrayList<Object>(); 
        for(Object s : searchs )  {
            thgs.add(new GoogleSearch(s.toString())); 
        }
        
        System.out.println("Created "+  thgs.size() + " test instances?");
        return thgs.toArray();
    }
    
    @DataProvider(name="searchData")
    public Object[] searchData() { 
        String[] searchs = {"Hurray from a factory", "there's no way it worked", "Try again"}; 
        
        return searchs; 
    }
    
}
