package org.Pool.pages;

import org.ChameleonArch.interactions.DriverModule;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.Skimmer;

public class Page {

    protected DriverModule<?> driver; 
    protected Spin spin; 
    protected static Skimmer pf; 
   
    public Page(DriverModule<?> driver, Spin spin) { 
        this.driver = driver;
        this.spin = spin; 
        pf = new Skimmer(driver, spin); 
        initPage(this);
    }

    public <TPage extends Page> TPage initPage(TPage pageClass) {
        return pf.initLocators(pageClass);
    }
    public <TPage extends Page> TPage initPage(Class<TPage> pageClass) {
        return pf.initLocators(pageClass);
    }
    
    @SuppressWarnings("unchecked")
    public static <TPage extends Page> TPage getPage(DriverModule<?> driver, Spin spin, TPage page) {
        return (TPage) new Skimmer(driver,spin).initLocators(page.getClass());
    }
    
}
