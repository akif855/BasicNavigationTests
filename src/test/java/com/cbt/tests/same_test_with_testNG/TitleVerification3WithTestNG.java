package com.cbt.tests.same_test_with_testNG;
import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class TitleVerification3WithTestNG {
    WebDriver driver;
    List<String> urls = Arrays.asList("https://luluandgeorgia.com",
            "https://wayfair.com",
            "https://www.westelm.com",
            "https://www.walmart.com");
    List<String> browsers = Arrays.asList("chrome", "firefox", "edge");
    List<String> titles_chrome = new ArrayList<>();
    List<String> actualUrls_chrome = new ArrayList<>();

    List<String> titles_firefox = new ArrayList<>();
    List<String> actualUrls_firefox = new ArrayList<>();

    List<String> titles_edge = new ArrayList<>();
    List<String> actualUrls_edge = new ArrayList<>();


    @BeforeClass
    public void collectData(){
        for (String browser : browsers) {
            driver = WebDriverFactory.getDriver(browser);
            for (String url : urls) {
                driver.get(url);
                switch (browser){
                    case "chrome":
                        titles_chrome.add(driver.getTitle().toLowerCase().replace(" ", ""));
                        actualUrls_chrome.add(driver.getCurrentUrl().toLowerCase().replace(" ", ""));
                        break;
                    case "firefox":
                        titles_firefox.add(driver.getTitle().toLowerCase().replace(" ", ""));
                        actualUrls_firefox.add(driver.getCurrentUrl().toLowerCase().replace(" ", ""));
                        break;
                    case "edge":
                        titles_edge.add(driver.getTitle().toLowerCase().replace(" ", ""));
                        actualUrls_edge.add(driver.getCurrentUrl().toLowerCase().replace(" ", ""));
                        break;
                }

            }
            driver.quit();
        }
    }


    @BeforeMethod
    public void message(){
        System.out.println("4. Verify that URL of the website contains the title of the website. Ignore spaces and case in comparison.");
    }

    @Test
    public void testUrlChrome1(){
        Assert.assertTrue(actualUrls_chrome.get(0).contains(titles_chrome.get(0)));
    }
    @Test
    public void testUrlChrome2(){
        Assert.assertTrue(actualUrls_chrome.get(1).contains(titles_chrome.get(1)));
    }
    @Test
    public void testUrlChrome3(){
        Assert.assertTrue(actualUrls_chrome.get(2).contains(titles_chrome.get(2)));
    }
    @Test
    public void testUrlChrome4(){
        Assert.assertTrue(actualUrls_chrome.get(3).contains(titles_chrome.get(3)));
    }


    @Test
    public void testUrlFirefox1(){
        Assert.assertTrue(actualUrls_firefox.get(0).contains(titles_firefox.get(0)));
    }
    @Test
    public void testUrlFirefox2(){
        Assert.assertTrue(actualUrls_firefox.get(1).contains(titles_firefox.get(1)));
    }
    @Test
    public void testUrlFirefox3(){
        Assert.assertTrue(actualUrls_firefox.get(2).contains(titles_firefox.get(2)));
    }
    @Test
    public void testUrlFirefox4(){
        Assert.assertTrue(actualUrls_firefox.get(3).contains(titles_firefox.get(3)));
    }

    @Test
    public void testUrlSafari1(){
        Assert.assertTrue(actualUrls_edge.get(0).contains(titles_edge.get(0)));
    }
    @Test
    public void testUrlSafari2(){
        Assert.assertTrue(actualUrls_edge.get(1).contains(titles_edge.get(1)));
    }
    @Test
    public void testUrlSafari3(){
        Assert.assertTrue(actualUrls_edge.get(2).contains(titles_edge.get(2)));
    }
    @Test
    public void testUrlSafari4(){
        Assert.assertTrue(actualUrls_edge.get(3).contains(titles_edge.get(3)));
    }




}