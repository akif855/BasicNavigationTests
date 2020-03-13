package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaUrlVerify {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver" + Keys.ENTER);

        Thread.sleep(2000);

        WebElement seleniumSoftware = driver.findElement(By.xpath("html/body/div/div[3]/div/div[3]/ul/li/div/a"));
        seleniumSoftware.click();

        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains("Selenium_(software)")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();




    }
}
