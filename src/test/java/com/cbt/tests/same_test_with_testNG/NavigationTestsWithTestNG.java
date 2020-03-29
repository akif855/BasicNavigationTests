package com.cbt.tests.same_test_with_testNG;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NavigationTestsWithTestNG {
    WebDriver driver;

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void testNavigationChrome(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        driver.get("https://www.etsy.com/");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();

        String expectedTitle = titleGoogle;
        String actualTitle = driver.getTitle();
        System.out.println("7. Verify that title is same is in step 3");
        Assert.assertEquals(expectedTitle,actualTitle);


        driver.navigate().forward();

        expectedTitle = titleEtsy;
        actualTitle = driver.getTitle();
        System.out.println("9. Verify that title is same is in step 5");
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void testNavigationFirefox(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        driver.get("https://www.etsy.com/");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();

        String expectedTitle = titleGoogle;
        String actualTitle = driver.getTitle();
        System.out.println("7. Verify that title is same is in step 3");
        Assert.assertEquals(expectedTitle,actualTitle);


        driver.navigate().forward();

        expectedTitle = titleEtsy;
        actualTitle = driver.getTitle();
        System.out.println("9. Verify that title is same is in step 5");
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void testNavigationSafari(){
        driver = WebDriverFactory.getDriver("edge");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String titleGoogle = driver.getTitle();

        driver.get("https://www.etsy.com/");
        String titleEtsy = driver.getTitle();

        driver.navigate().back();

        String expectedTitle = titleGoogle;
        String actualTitle = driver.getTitle();
        System.out.println("7. Verify that title is same is in step 3");
        Assert.assertEquals(expectedTitle,actualTitle);


        driver.navigate().forward();

        expectedTitle = titleEtsy;
        actualTitle = driver.getTitle();
        System.out.println("9. Verify that title is same is in step 5");
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
