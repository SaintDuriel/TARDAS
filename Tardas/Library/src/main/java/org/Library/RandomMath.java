package org.Library;

import java.util.Random;

public class RandomMath {

    public static int addSubtractRandom(int startVal, int maxWiggle) { 
        int returnVal = 0; 
        int wiggle = getNumberInRange(0, maxWiggle);
        if(getRandomBoolean()) {
            returnVal = add(startVal, wiggle);
        } else { 
            returnVal = subtract(startVal, wiggle); 
        }
        return returnVal; 
    }
    public static int subtract(int a, int b) { 
        return a - b; 
    }
    
    public static int add(int a, int b) { 
        return a + b; 
    }
    

    
    public static Boolean getRandomBoolean() { 
        return new Random().nextBoolean();
    }
    
    public static int getNumberInRange(int min, int max) { 
        if(min > max) { 
            return getNumberInRange(max, min); 
        }
        
        Random rand = new Random(); 
        return rand.ints(min, max).findAny().getAsInt();
    }
}
