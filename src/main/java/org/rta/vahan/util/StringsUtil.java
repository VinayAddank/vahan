package org.rta.vahan.util;

import java.util.Objects;

public final class StringsUtil {

    /**
     * Get last chars defined by {@code numberOfChars} of the {@code str}
     * 
     * @param str
     * @param numberOfChars
     * @return String
     */
    public static String getLastChars(String str, int numberOfChars) {
        if (Objects.isNull(str)) {
            return null;
        }
        str = str.trim();
        if (str.length() < numberOfChars) {
            throw new IllegalArgumentException("string must be greater than number of chars");
        }
        
        return str.substring(str.length() - numberOfChars, str.length());
    }
    
    /**
     * Get starting chars defined by {@code numberOfChars} of the {@code str}
     * 
     * @param str
     * @param numberOfChars
     * @return String
     */
    public static String getStartingChars(String str, int numberOfChars) {
        if (Objects.isNull(str)) {
            return null;
        }
        str = str.trim();
        if (str.length() < numberOfChars) {
            throw new IllegalArgumentException("string must be greater than number of chars");
        }
        
        return str.substring(0, numberOfChars);
    }
    
    public static void main(String[] args) {
        System.out.println(getLastChars("sadlf234213        ", 5));
        System.out.println(getStartingChars("     sadlf234213        ", 3));
    }
    
}
