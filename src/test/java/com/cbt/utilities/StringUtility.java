package com.cbt.utilities;

public class StringUtility {
    public static void verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expected: " + expected + " but actual: " + actual);
        }
    }

    public static void verifyContains(String url, String title) {
        if (url.contains(title)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("title: " + title);
            System.out.println("url = " + url);
        }
    }

    public static void verifyStartWith(String url, String text) {
        if (url.contains(text)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("title: " + text);
            System.out.println("url = " + url);
        }
    }
}
