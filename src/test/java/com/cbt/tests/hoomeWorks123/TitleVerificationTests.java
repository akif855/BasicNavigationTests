package com.cbt.tests.hoomeWorks123;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) throws InterruptedException {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                          "http://practice.cybertekschool.com/dropdown",
                                          "http://practice.cybertekschool.com/login");

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://google.com");
        Thread.sleep(2000);

        String title1 = driver.getTitle();
        driver.navigate().to("http://practice.cybertekschool.com/");

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS, actual Title is: " + actualTitle);
        }else {
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver.close();


        WebDriver driver2 = WebDriverFactory.getDriver("chrome");

        driver2.get("https://google.com");
        Thread.sleep(2000);

        String title2 = driver2.getTitle();
        driver2.navigate().to("http://practice.cybertekschool.com/dropdown");

        String expectedTitle2 = "Practice";
        String actualTitle2 = driver2.getTitle();

        if(expectedTitle2.equals(actualTitle2)){
            System.out.println("PASS, actual Title is: " + actualTitle2);
        }else {
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver2.close();


        WebDriver driver3 = WebDriverFactory.getDriver("chrome");

        driver3.get("https://google.com");
        Thread.sleep(2000);

        String title3 = driver3.getTitle();
        driver3.navigate().to("http://practice.cybertekschool.com/login");

        String expectedTitle3 = "Practice";
        String actualTitle3 = driver3.getTitle();

        if(expectedTitle2.equals(actualTitle2)){
            System.out.println("PASS, actual Title is: " + actualTitle2);
        }else {
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver3.close();


        WebDriver driver4 = WebDriverFactory.getDriver("chrome");

        driver4.get("http://practice.cybertekschool.com/");
        Thread.sleep(2000);
        String expectedURL = "http://practice.cybertekschool.com/";

        String expectedStartsWith = "http://practice.cybertekschool.com";
        String actualURL = driver4.getCurrentUrl();


        if(actualURL.startsWith(expectedStartsWith)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("I expected " + expectedURL);
            System.out.println("The actual URL is: " + actualURL);
        }
        Thread.sleep(2000);
        driver4.close();


        WebDriver driver5 = WebDriverFactory.getDriver("chrome");

        driver5.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(2000);
        String expectedURL2 = "http://practice.cybertekschool.com/dropdown";

        String expectedStartsWith2 = "http://practice.cybertekschool.com";
        String actualURL2 = driver5.getCurrentUrl();


        if(actualURL.startsWith(expectedStartsWith)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("I expected " + expectedURL);
            System.out.println("The actual URL is: " + actualURL);
        }
        Thread.sleep(2000);
        driver5.close();


        WebDriver driver6 = WebDriverFactory.getDriver("chrome");

        driver6.get("http://practice.cybertekschool.com/login");
        Thread.sleep(2000);
        String expectedURL3 = "http://practice.cybertekschool.com/login";

        String expectedStartsWith3 = "http://practice.cybertekschool.com";
        String actualURL3 = driver6.getCurrentUrl();


        if(actualURL.startsWith(expectedStartsWith)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("I expected " + expectedURL);
            System.out.println("The actual URL is: " + actualURL);
        }
        Thread.sleep(2000);
        driver6.close();

    }
}
