package com.gamasoft.commons;

public class Utils {
    public static boolean isNullOrBlank(String s)
    {
        return (s==null || s.trim().equals(""));
    }

    public static void notBlank(String value, String name) {
        if (isNullOrBlank(value))
            throw new RuntimeException(name + " cannot be blank!");
    }
}
