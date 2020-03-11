package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.TreeSet;

public class NavigationTests {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(2000);
        String ggTitle1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1 = driver.getTitle();
        Thread.sleep(2000);
        driver.navigate().back();
        String ggTitle2 = driver.getTitle();

        StringUtility.verifyEquals(ggTitle2,ggTitle2);

        Thread.sleep(2000);
        driver.navigate().forward();
        String etsyTitle2 = driver.getTitle();
        if(ggTitle1.equals(ggTitle2)){
            System.out.println("Etsy Titles are SAME");
        }else {
            System.out.println("Etsy Titles are Different");
        }
        Thread.sleep(2000);
        driver.close();


        WebDriver driver2 = BrowserFactory.getDriver("firefox");
        driver2.manage().window().maximize();
        driver2.get("https://google.com");
        Thread.sleep(2000);
        String FggTitle1 = driver2.getTitle();
        driver2.navigate().to("https://etsy.com");
        String FetsyTitle1 = driver2.getTitle();
        Thread.sleep(2000);
        driver2.navigate().back();
        String FggTitle2 = driver2.getTitle();

        StringUtility.verifyEquals(FggTitle2,FggTitle2);

        Thread.sleep(2000);
        driver2.navigate().forward();
        String FetsyTitle2 = driver2.getTitle();
        if(FggTitle1.equals(FggTitle2)){
            System.out.println("Etsy Titles are SAME");
        }else {
            System.out.println("Etsy Titles are Different");
        }
        Thread.sleep(2000);
        driver2.close();



        WebDriver driver3 = BrowserFactory.getDriver("edge");
        driver3.manage().window().maximize();
        driver3.get("https://google.com");
        Thread.sleep(2000);
        String FggTitle3 = driver3.getTitle();
        driver3.navigate().to("https://etsy.com");
        String FetsyTitle3 = driver3.getTitle();
        Thread.sleep(2000);
        driver3.navigate().back();
        String FggTitle4 = driver3.getTitle();

        StringUtility.verifyEquals(FggTitle3,FggTitle3);

        Thread.sleep(2000);
        driver3.navigate().forward();
        String FetsyTitle4 = driver3.getTitle();
        if(FggTitle3.equals(FggTitle3)){
            System.out.println("Etsy Titles are SAME");
        }else {
            System.out.println("Etsy Titles are Different");
        }
        Thread.sleep(2000);
        driver3.close();

    }
}
