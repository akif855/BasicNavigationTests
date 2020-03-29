package com.cbt.tests.same_test_with_testNG;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerificationTestsWithTestNG {
    WebDriver driver;
    List<String> urls;
    List<String> titles;
    List<String> actualUrls;

    @BeforeClass
    public void collectData(){
        urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        titles = new ArrayList<>();
        actualUrls = new ArrayList<>();

        driver = WebDriverFactory.getDriver("chrome");
        for(String url : urls){
            driver.get(url);
            titles.add(driver.getTitle());
            actualUrls.add(driver.getCurrentUrl());
        }
        driver.quit();
    }

    @Test
    public void testVerifyTitle1(){
        System.out.println("========== Verifying title 1 ===========");
        Assert.assertEquals(titles.get(0),titles.get(1));
    }

    @Test
    public void testVerifyTitle2(){
        System.out.println("========== Verifying title 2 ===========");
        Assert.assertEquals(titles.get(0),titles.get(2));
    }

    @Test
    public void testVerifyTitle3(){
        System.out.println("========== Verifying title 3 ===========");
        Assert.assertEquals(titles.get(1),titles.get(2));
    }

    @Test
    public void testVerifyUrl1(){
        System.out.println("========== Verifying url 1 ===========");
        Assert.assertTrue(actualUrls.get(0).startsWith("http://practice.cybertekschool.com"));
    }

    @Test
    public void testVerifyUrl2(){
        System.out.println("========== Verifying url 2 ===========");
        Assert.assertTrue(actualUrls.get(1).startsWith("http://practice.cybertekschool.com"));
    }

    @Test
    public void testVerifyUrl3(){
        System.out.println("========== Verifying url 3 ===========");
        Assert.assertTrue(actualUrls.get(2).startsWith("http://practice.cybertekschool.com"));
    }
}