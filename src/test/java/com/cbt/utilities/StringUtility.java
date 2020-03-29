package com.cbt.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    /**
     * takes a list of web elements
     * returns a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> listEl){
        List<String> listSt = new ArrayList<>();
        for (WebElement element : listEl){
            listSt.add(element.getText().trim());
        }
        return listSt;
    }

}