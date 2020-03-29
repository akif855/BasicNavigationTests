package com.cbt.tests.same_test_with_testNG;
import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2WithTestNG {
    WebDriver driver;
    List<String> urls;
    List<String> titles;
    List<String> actualUrls;
    @BeforeClass
    public void collectData(){
        urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com",
                "https://www.westelm.com",
                "https://www.walmart.com");
        titles = new ArrayList<>();
        actualUrls = new ArrayList<>();

        driver = WebDriverFactory.getDriver("chrome");

        for(String url: urls){
            driver.get(url);
            titles.add(driver.getTitle().toLowerCase().replace(" ",""));
            actualUrls.add(driver.getCurrentUrl().toLowerCase().replace(" ", ""));
        }

        driver.quit();
    }

    @BeforeMethod
    public void verifyMessage(){
        System.out.println("4. Verify that URL of the website contains the title of the website. Ignore spaces and case in comparison.");
    }

    @Test
    public void test1(){
        Assert.assertTrue(actualUrls.get(0).contains(titles.get(0)));
    }

    @Test
    public void test2(){
        Assert.assertTrue(actualUrls.get(1).contains(titles.get(1)));
    }

    @Test
    public void test3(){
        Assert.assertTrue(actualUrls.get(2).contains(titles.get(2)));
    }

    @Test
    public void test4(){
        Assert.assertTrue(actualUrls.get(3).contains(titles.get(3)));
    }

}