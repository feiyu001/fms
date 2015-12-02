

package com.zhnan.reader.utils;

import java.util.ArrayList;
import java.util.List;

public final class StringUtils {

    /**
     * @Description: constructor.
     */
    private StringUtils() {
    }

    /**
     * @Description: reverse a string.
     * @param str the String to reverse, may be null
     * @return reversedStr the reversed String, null if null String input
     */
    public static String reverse(String str) {
        if (isEmpty(str)) {
            return str;
        }

        return new StringBuilder(str).reverse().toString();
    }

    /**
     * @Description: Compares whether two strings are equals, null-safe.
     * @param str1 fist value
     * @param str2 second value
     * @return boolean
     */
    public static boolean isEquals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    /**
     * @Description: Removes all occurrences of a substring from within the source string.
     * @param str the source String to search
     * @param remove the String to search for and remove
     * @return the substring with the string removed if found, null if null String input
     */
    public static String remove(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }

        return str.replace(remove, "");
    }

    /**
     * @Description: Removes leading and trailing space of the String, handling null by returning
     *               null.
     * @param str the String to be trimmed, may be null
     * @return the trimmed string, null if null String input
     */
    public static String trim(String str) {
        if (isEmpty(str)) {
            return str;
        }

        return str.trim();
    }

    /**
     * 
     * @Title: startsWithIgnoreCase
     * @Description: check if a string starts with a specified prefix.
     * @param str input value
     * @param prefix prefix value
     * @return true if the string starts with the prefix, case insensitive, or both null, blank
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }

        if (prefix.length() > str.length()) {
            return false;
        }

        return str.toUpperCase().startsWith(prefix.toUpperCase());
    }

    /**
     * whether value does not contain number(s).
     * 
     * @Title: isAllAlphas
     * @param value the source to be handled
     * @return boolean
     */
    public static boolean isAllAlphas(String value) {
        // if input parameter is null, just return
        if (value == null) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (!(Character.isLetter(value.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

   

    /**
     * Split the source string by given delimiter.
     * 
     * @Title: split
     * @param input input source string
     * @param delimiter delimiter string
     * @return result list
     */
    public static List<String> split(String input, String delimiter) {
        List<String> list = new ArrayList<String>();

        // check input is vacant str
        if (isVacantStr(input)) {
            return list;
        }

        if (isEmpty(delimiter)) {
            for (int j = 0; j < input.length(); j++) {
                list.add(input.substring(j, j + 1));
            }
        } else {
            int start = 0;
            int index = -1;

            while ((index = input.indexOf(delimiter, start)) != -1) {
                list.add(input.substring(start, index));
                start = index + delimiter.length();
            }

            list.add(input.substring(start));
        }

        while (list.remove("")) {
            ;
        }

        return list;
    }

    /**
     * check that the string is empty or not.
     * 
     * @Title: isVacantStr
     * @param str input value
     * @return boolean
     */
    public static boolean isVacantStr(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }

        return false;
    }

    /**
     * check whether is empty.
     * 
     * @Title: isEmpty
     * @param str input value
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }


    
    /**
     * check if the CharSequence contains only unicode digits.
     * 
     * @Title: isNumber
     * @param str input str
     * @return true or false
     */
    public static boolean isNumeric(String str) {
        // if input parameter is null, just return false
        if (isEmpty(str)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            // if there is a alpha, return false
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
}
