package com.cbt.tests.hoomeWorks123;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://ebay.com");

        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("Wooden Spoon" + Keys.ENTER);

        Thread.sleep(2000);

        WebElement countEl = driver.findElement(By.cssSelector("h1>span"));
        String count = countEl.getText();
        System.out.println(count);

        int countOne = Integer.parseInt(count.replace(",", ""));
        System.out.println(countOne);

        WebElement all = driver.findElement(By.linkText("All"));
        all.click();
        Thread.sleep(2000);

        countEl = driver.findElement(By.cssSelector("h1>span"));
        count = countEl.getText();
        System.out.println(count);

        int countTwo = Integer.parseInt(count.replace(",",""));
        System.out.println(countTwo);

        if(countTwo>countOne){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("countOne = " + countOne);
            System.out.println("countTwo = " + countTwo);
        }

        driver.navigate().back();

        input = driver.findElement(By.id("gh-ac"));
        String woodenSpoon = input.getAttribute("value");
        System.out.println(woodenSpoon);

        if(woodenSpoon.equals("Wooden Spoon")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected: " + "woodenSpoon");
            System.out.println("actual: " + woodenSpoon);
        }

        driver.navigate().back();

        Thread.sleep(2000);
        input = driver.findElement(By.id("gh-ac"));
        woodenSpoon = input.getAttribute("value");
        System.out.println("woodenSpoon = " + woodenSpoon);

        if(woodenSpoon.isEmpty()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected a blank value");
            System.out.println("actual: " + woodenSpoon);
        }

        driver.quit();
    }
}
