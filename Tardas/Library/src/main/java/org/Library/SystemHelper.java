package org.Library;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SystemHelper {

    public static String getWorkingDir() { 
        return System.getProperty("user.dir"); 
    }

    public static String getProjectDir() {
        String projectDir = null; 
        String match = "Tardas"; 
        String textToRemove = getWorkingDir().substring(getWorkingDir().indexOf(match)+match.length());
        projectDir = getWorkingDir().replace(textToRemove, "");
        return projectDir;
    }

    public static String getHostOperatingSystem() { 
        return System.getProperty("os.name");
    }

    public static String getSystemFileDivider() { 
        String os = getHostOperatingSystem();
        if(os.toLowerCase().contains("win"))
        {
            return "\\";
            
        } else if (os.toLowerCase().contains("osx") ||os.toLowerCase().contains("nix"))
        {
            return "/";
        }
        
        //oh shit, what didn't we account for now? 
        return "/"; 
    }
    
    public static String getSystemSafeFilePath(String[] args) { 
        String finalString = ""; 
        for (String str : args) { 
            finalString += getSystemFileDivider() + str; 
        }
        return finalString;
    }

    @Test
    public void testGetUserDir() { 
        System.out.println("Running Test for get Working Directory");
        System.out.println(getWorkingDir());
        Assert.assertNotNull(getWorkingDir());
    }

    @Test
    public void testGetProjectDir() { 
        System.out.println("Running Test for get Project Directory");
        System.out.println(getProjectDir());
        Assert.assertFalse(getProjectDir().contains("Library"));
    }

    @Test
    public void testGetHostOperatingSystem() { 
        System.out.println("Running Test for Host Operating System");
        System.out.println(getHostOperatingSystem());
    }
    
    
}
