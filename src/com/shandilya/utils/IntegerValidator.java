package com.shandilya.utils;

public class IntegerValidator {

    public static boolean isInteger(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}