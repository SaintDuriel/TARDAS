package org.Console.testcases.google;

import org.EyeOfHarmony.Supernova.Spark;

public abstract class Search extends Spark {

    protected abstract void focusSearchField(); 
    protected abstract void enterSearchQuery(); 
    protected abstract void checkSearchResults(); 
    
    public final void search() {
        focusSearchField(); 
        enterSearchQuery(); 
        checkSearchResults(); 
    }
}
