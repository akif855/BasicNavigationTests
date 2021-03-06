package com.cbt.tests.hoomeWorks123;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitleVerify {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.name("field-keywords"));
        searchBox.sendKeys("sunglasses" + Keys.ENTER);

        String actual = driver.getTitle();
        if(actual.contains("sunglasses")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        driver.close();
    }
}