package com.cbt.tests.hoomeWorks123;

import com.cbt.utilities.WebDriverFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultTitle {
    public static void main(String[] args) throws InterruptedException {
        List<String> searchStrs = Arrays.asList("Java",
                "cucumber bdd",
                "Selenium web browser automation");

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
        Thread.sleep(2000);

        for (String each : searchStrs) {
            WebElement searchBox = driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
            searchBox.sendKeys(each, Keys.ENTER);

            String expected = driver.findElement(By.xpath("//cite[@class='iUh30 tjvcx']")).getText();
            driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).click();
            Thread.sleep(2000);
            String actual = driver.getCurrentUrl();

            StringUtility.verifyEquals(expected,actual);
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

        }
    }
}
