package org.Console.testcases.google;

import org.EyeOfHarmony.Supernova.Spark;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTestProvider extends Spark {


    @Test(dataProvider="searches", threadPoolSize=4)
    public void tests(Search searchTest) { 
        searchTest.search();
    }

    @DataProvider
    public Search[] searches() { 
        Search[] objs =  {  
                new GoogleSearch(driver, spin, "Automation is Awesome!"),
                new GoogleSearch(driver, spin, "Aldous Snow!"),
                new GoogleSearch(driver, spin, "Ozzy Osbourne"),
                new GoogleSearch(driver, spin, "Fuzzy Walls")
        };
        return objs;
    }
}
