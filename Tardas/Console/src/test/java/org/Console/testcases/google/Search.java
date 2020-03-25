package org.Console.testcases.google;

import org.EyeOfHarmony.Supernova.Spark;
import org.testng.annotations.Test;

public abstract class Search extends Spark {

    protected abstract void focusSearchField(); 
    protected abstract void enterSearchQuery(); 
    protected abstract void checkSearchResults(); 
    
    @Test
    public final void search() {
        focusSearchField(); 
        enterSearchQuery(); 
        checkSearchResults(); 
    }
}
