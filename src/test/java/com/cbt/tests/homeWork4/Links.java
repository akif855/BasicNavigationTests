package com.cbt.tests.homeWork4;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class Links {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
       driver.quit();
    }
    /*
    1. go to https://www.w3schools.com/
    2. find all the elements in the page with the tag a
    3. for each of those elements, if it is displayed on the page, print the text and the href of that element
     */
    @Test
    public void links(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for (WebElement each: allLinks) {
            if(each.isDisplayed()){
                System.out.println(each.getText());
                System.out.println(each.getAttribute("href"));
            }
        }
    }
    /*
    1. go to https://www.selenium.dev/documentation/en/
     2. find all the elements in the page with the tag a
     3. verify that all the links are valid
     */
    @Test
    public void validLinks(){
        driver.get("https://www.selenium.dev/documentation/en/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for (WebElement eachLink: allLinks) {
            Assert.assertTrue(eachLink.isEnabled());
        }
    }
}
