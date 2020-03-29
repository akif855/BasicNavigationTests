package com.cbt.tests.homeWork4;

import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Amazon {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    /*
    1. go to https://www.amazon.com
    2. verify that default value of the All departments dropdown is All
    3. verify that options in the All departments dropdown are not sorted alphabetically
     */

    @Test
    public void departmentsSort() {
        driver.get("https://www.amazon.com");
        WebElement allDD = driver.findElement(By.id("searchDropdownBox"));
        Select allDDSelect = new Select(allDD);

        Assert.assertTrue(allDDSelect.getFirstSelectedOption().getText().contains("All"));

        List<WebElement> allDDList = allDDSelect.getOptions();
            List<String> elementsText = BrowserUtils.getElementsText(allDDList);

           List<String> copyOfElementsText = new ArrayList<>(elementsText);
           Collections.sort(copyOfElementsText);
           Assert.assertNotEquals(elementsText,copyOfElementsText);
    }

    /*
    1. go to https://www.amazon.com/gp/site-directory
    2. verify that every main department name (indicated by blue rectangles in the picture) is present
    in the All departments dropdown (indicated by green rectangle in the picture)
     */
    @Test
    public void mainDepartments(){
        driver.get("https://www.amazon.com/gp/site-directory");
        WebElement allDD = driver.findElement(By.id("searchDropdownBox"));
        Select allDDSelect = new Select(allDD);

        List<WebElement> allDDList = allDDSelect.getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(allDDList);
        System.out.println(elementsText.size());

        List<WebElement> mainDepNames= driver.findElements(By.cssSelector("[class='fsdDeptTitle']"));
        List<String> mainDepNamesText = BrowserUtils.getElementsText(mainDepNames);

        Assert.assertTrue(elementsText.containsAll(mainDepNamesText));
    }

    /*
    1. go to https://amazon.com
    2. search for "wooden spoon"
    3. click search
    4. remember the name and the price of a random result
    5. click on that random result
    6. verify default quantity of items is 1
    7. verify that the name and the price is the same as the one from step 5
    8. verify button "Add to Cart" is visible
     */

    @Test
    public void cart() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        WebElement name = driver.findElement(By.xpath("//span[.='Riveira Wooden Spoons for Cooking " +
                "6-Piece Bamboo Utensil Set Apartment Essentials Wood Spatula Spoon Nonstick Kitchen " +
                "Utensil Set Premium Quality Housewarming Gifts Wooden Utensils for Everyday Use']"));
        String nameEx = name.getText();
        WebElement price = driver.findElement(By.xpath("//span[.='$12.97'][1]"));
        String priceEx = price.getAttribute("innerHTML");

        name.click();
        Thread.sleep(2000);

        WebElement quantityB = driver.findElement(By.id("quantity"));
        Select quantityBS = new Select(quantityB);

        Assert.assertEquals(quantityBS.getFirstSelectedOption().getAttribute("value"), "1");

        String nameAC = driver.findElement(By.id("productTitle")).getText();
        Assert.assertEquals(nameAC, nameEx);

        String priceAc = driver.findElement(By.id("priceblock_saleprice")).getText();
        Assert.assertEquals(priceAc, priceEx);

        WebElement addTCB = driver.findElement(By.id("add-to-cart-button"));
        Assert.assertTrue(addTCB.isDisplayed());
    }
}