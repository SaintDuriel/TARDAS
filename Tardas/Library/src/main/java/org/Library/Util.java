package org.Library;

import org.CloisterBell.Clapper;
import org.CloisterBell.enumTypes.LogLevel;

public class Util {

    /**
     * Util Function to check the value of two inputs. <br>
     * if s1 is not null it will be returned in priority <br>
     * over s2. 
     * 
     * @param <T>
     * @param s1
     * @param s2
     * @return 
     */
    public static synchronized <T> T compare(T s1, T s2) { 
        try {
           if(s1 == null && s2 == null) { 
               return null; 
           }
            Clapper.log(LogLevel.DEBUG, "Returning Value: " + (s1 != null ? s1 : s2).toString());
            return s1 != null ? s1 : s2; 
        } catch (Exception e) {
            //TODO(matjohns05):Oh damn, I guess PERHAPS we should do some 
            //sort of type checking. 
            Clapper.log(LogLevel.ERROR, "Something went wrong while comparing values.");
            if(s1 != null && s2 != null) {
                Clapper.log(LogLevel.DEBUG, "Var Obj Type 1: " +s1.getClass().getName() +"\nVar Obj Type2:" +s2.getClass().getName());
            }
            Clapper.log(LogLevel.ERROR, "Trace:\n" + e.getLocalizedMessage());
        }
        return null;
        
    }
}
