package org.Console.testcases.google.search;

import org.EyeOfHarmony.Supernova.Spark;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTestProvider extends Spark {


    @Test(dataProvider="searches")
    public void searchTestFromDataProvider(Search searchTest) { 
        searchTest.search();
    }

    @DataProvider
    public Search[] searches() { 
        Search[] objs =  {  
                new GoogleSearch(driver, spin, "Automation is Awesome!"),
                new GoogleSearch(driver, spin, "Aldous Snow!"),
                new GoogleSearch(driver, spin, "Ozzy Osbourne"),
                new GoogleSearch(driver, spin, "Fuzzy Walls"),
                new GoogleSearch(driver, spin, "Disney"),
                new GoogleSearch(driver, spin, "Disneyland"),
                new GoogleSearch(driver, spin, "Disneyworld"),
                new GoogleSearch(driver, spin, "Universal"),
                new GoogleSearch(driver, spin, "Universal Studios Orlando"),
                new GoogleSearch(driver, spin, "Universal Studios Los Angeles")

        };
        return objs;
    }
}
