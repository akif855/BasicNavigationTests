package com.cbt.tests.homeWork4;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TransferQueue;

public class Prime {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

// TODO   1. go to https://amazon.com
//        2. search for "wooden spoon"
//        3. click search
//        4. remember name first result that has prime label
//        5. select Prime checkbox on the left
//        6. verify that name first result that has prime label is same as step 4
//        7. check the last checkbox under Brand on the left
//        8. verify that name first result that has prime label is different


    @Test
    public void test1() throws InterruptedException {
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);

        Thread.sleep(2000);
        WebElement beforeFirstResult = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));

        Thread.sleep(2000);
        WebElement prime = driver.findElement(By.xpath("//li[@aria-label='Prime Eligible']//label/i"));
        prime.click();//TODO clicking prime

        Thread.sleep(2000);
        WebElement afterFirstResult = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));

       // Assert.assertEquals(beforeFirstResult, afterFirstResult);

    }

}

