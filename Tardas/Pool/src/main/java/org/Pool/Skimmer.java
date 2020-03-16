package org.Pool;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.ChameleonArch.interactions.DriverModule;
import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;
import org.EyeOfHarmony.Seed.BlackHole.TestType;
import org.EyeOfHarmony.Seed.Spin;
import org.Pool.annotations.AndroidApp;
import org.Pool.annotations.AndroidWeb;
import org.Pool.annotations.IOSApp;
import org.Pool.annotations.IOSWeb;
import org.Pool.annotations.WebBy;
import org.Pool.pages.Page;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class Skimmer {

    DriverModule<?>  driver; 
    Spin spin; 
    static Class<?> annoTypeToInit; 
    public Skimmer(DriverModule<?> driver, Spin spin) { 
        this.driver = driver; 
        this.spin = spin;
    }

    public static <T extends Page> T initLocators(DriverModule<?> driver, Spin spin,Class<T> page) { 
        T returnPage = null; 
        setAnnotationTypeToInit(spin);
        try {
            returnPage = findAnnotationType(page.getConstructor(DriverModule.class, Spin.class).newInstance(driver, spin));
        } catch (Exception e) { 
            Clapper.log(LogLevel.DEBUG, "Failed to initialize Page Object: " + page.getCanonicalName());
        }
        

        return returnPage; 
    }

    public <T extends Page> T initLocators( Class<T> page) { 
        T returnPage = Skimmer.initLocators(driver, spin, page); 

        return returnPage; 
    }

    @SuppressWarnings("unchecked")
    private static <T extends Page> T findAnnotationType(T page) { 
        for(Field f : page.getClass().getFields()) { 
            if(f.getAnnotation((Class<Annotation>)annoTypeToInit) != null) { 
                setFieldValue(f.getAnnotation((Class<Annotation>)annoTypeToInit), f, page); 
            } else if (f.getAnnotation(WebBy.class) != null) { 
                setFieldValue(f.getAnnotation(WebBy.class), f, page); 
            }
        }

        return page; 
    }

    String[] methodNames = {"id","css","xpath","tagName","className","linkText","partialLinkText","accessibilityId"};
    private static <T extends Page> T setFieldValue(Annotation anno, Field field, T page) { 
        field.setAccessible(true);
        try {
            By valueToSet = getLocator(anno);
            field.set(page,valueToSet);
            Clapper.log(LogLevel.DEBUG, "\tSkimmer Set Page Object: " + page.getClass().getCanonicalName() 
                    + "\n\t\tField: " + field.getName()
                    +"\n\t\tWith By Locator : " + valueToSet);
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        }

        return page; 
    }

    private static By getLocator(Annotation anno) { 
        if(anno instanceof WebBy) { 
            return getLocator((WebBy) anno);
        }
        if(anno instanceof AndroidApp) { 
            return getLocator((AndroidApp) anno);
        }
        if(anno instanceof AndroidWeb) { 
            return getLocator((AndroidWeb) anno);
        }
        if(anno instanceof IOSWeb) { 
            return getLocator((IOSWeb) anno);
        }
        if(anno instanceof IOSApp) { 
            return getLocator((IOSApp) anno);
        }

        return null; 
    }

    private static By getLocator(WebBy aApp) { 
        if(!"".equals(aApp.css()))  {
            return By.cssSelector(aApp.css());
        } 
        if(!"".equals(aApp.id()))  {
            return By.id(aApp.id());
        } 
        if(!"".equals(aApp.xpath()))  {
            return By.xpath(aApp.xpath());
        } 
        if(!"".equals(aApp.tagName()))  {
            return By.tagName(aApp.tagName());
        } 
        if(!"".equals(aApp.className()))  {
            return By.className(aApp.className());
        } 
        if(!"".equals(aApp.linkText()))  {
            return By.linkText(aApp.linkText());
        } 
        if(!"".equals(aApp.partialLinkText()))  {
            return By.partialLinkText(aApp.partialLinkText());
        } 
        return null; 
    }


    private static By getLocator(AndroidWeb aApp) { 
        if(!"".equals(aApp.css()))  {
            return By.cssSelector(aApp.css());
        } 
        if(!"".equals(aApp.id()))  {
            return By.id(aApp.id());
        } 
        if(!"".equals(aApp.xpath()))  {
            return By.xpath(aApp.xpath());
        } 
        if(!"".equals(aApp.tagName()))  {
            return By.tagName(aApp.tagName());
        } 
        if(!"".equals(aApp.className()))  {
            return By.className(aApp.className());
        } 
        if(!"".equals(aApp.linkText()))  {
            return By.linkText(aApp.linkText());
        } 
        if(!"".equals(aApp.partialLinkText()))  {
            return By.partialLinkText(aApp.partialLinkText());
        } 
        return null; 
    }


    private static By getLocator(AndroidApp aApp) { 
        if(!"".equals(aApp.css()))  {
            return By.cssSelector(aApp.css());
        } 
        if(!"".equals(aApp.id()))  {
            return By.id(aApp.id());
        } 
        if(!"".equals(aApp.xpath()))  {
            return By.xpath(aApp.xpath());
        } 
        if(!"".equals(aApp.tagName()))  {
            return By.tagName(aApp.tagName());
        } 
        if(!"".equals(aApp.className()))  {
            return By.className(aApp.className());
        } 
        if(!"".equals(aApp.linkText()))  {
            return By.linkText(aApp.linkText());
        } 
        if(!"".equals(aApp.partialLinkText()))  {
            return By.partialLinkText(aApp.partialLinkText());
        } 
        if(!"".equals(aApp.accessibilityId()))  {
            return MobileBy.AccessibilityId(aApp.accessibilityId());
        }  
        return null; 
    }


    private static By getLocator(IOSApp aApp) { 
        if(!"".equals(aApp.css()))  {
            return By.cssSelector(aApp.css());
        } 
        if(!"".equals(aApp.id()))  {
            return By.id(aApp.id());
        } 
        if(!"".equals(aApp.xpath()))  {
            return By.xpath(aApp.xpath());
        } 
        if(!"".equals(aApp.tagName()))  {
            return By.tagName(aApp.tagName());
        } 
        if(!"".equals(aApp.className()))  {
            return By.className(aApp.className());
        } 
        if(!"".equals(aApp.linkText()))  {
            return By.linkText(aApp.linkText());
        } 
        if(!"".equals(aApp.partialLinkText()))  {
            return By.partialLinkText(aApp.partialLinkText());
        } 
        if(!"".equals(aApp.accessibilityId()))  {
            return MobileBy.AccessibilityId(aApp.accessibilityId());
        } 
        return null; 
    }


    private static By getLocator(IOSWeb aApp) { 
        if(!"".equals(aApp.css()))  {
            return By.cssSelector(aApp.css());
        } 
        if(!"".equals(aApp.id()))  {
            return By.id(aApp.id());
        } 
        if(!"".equals(aApp.xpath()))  {
            return By.xpath(aApp.xpath());
        } 
        if(!"".equals(aApp.tagName()))  {
            return By.tagName(aApp.tagName());
        } 
        if(!"".equals(aApp.className()))  {
            return By.className(aApp.className());
        } 
        if(!"".equals(aApp.linkText()))  {
            return By.linkText(aApp.linkText());
        } 
        if(!"".equals(aApp.partialLinkText()))  {
            return By.partialLinkText(aApp.partialLinkText());
        } 
        return null; 
    }



    private static void setAnnotationTypeToInit(Spin spin) { 

        switch(spin.hostPlatform()) {
        case OSX:
        case UNIX:
        case WINDOWS:
            annoTypeToInit = WebBy.class;
            break;
        case ANDROID: 
            if(spin.testType() == TestType.APP){
                annoTypeToInit =  AndroidApp.class;
            } else { 
                annoTypeToInit = AndroidWeb.class;
            }
            break;
        case IOS: 
            if(spin.testType() == TestType.APP){
                annoTypeToInit= IOSApp.class;
            } else { 
                annoTypeToInit =  IOSWeb.class;
            }
            break;
        default:
            annoTypeToInit = WebBy.class;;
        }

        Clapper.log(LogLevel.DEBUG, "Setting Annotation Type to initialize to: " + annoTypeToInit.getSimpleName());

    }

}
