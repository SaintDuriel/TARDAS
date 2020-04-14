package org.Pool.pages.google.elements;

import org.ChameleonArch.interactions.actions.Getter;
import org.openqa.selenium.WebElement;

public class RelatedLink {

    String title, href; 
    
    public RelatedLink(WebElement ele) { 
        title = Getter.getText(ele); 
        href = Getter.getAttribute(ele, "href"); 
    }
    
    public String title() { 
        return title; 
    }
    
    public String href() { 
        return href; 
    }
}
