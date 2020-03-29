package com.cbt.tests.homeWork4;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class ToDaysDate {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void getSelectedOption() {
        // FIND THE ELEMENT THAT HAS SELECT TAG
        WebElement dropdown = driver.findElement(By.id("year"));
        WebElement dropdown2 = driver.findElement(By.id("month"));
        WebElement dropdown3 = driver.findElement(By.id("day"));

        // create a select class using the web element
        Select dropdownList = new Select(dropdown);
        Select dropdownList2 = new Select(dropdown2);
        Select dropdownList3 = new Select(dropdown3);

        // get the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();
        WebElement selectedOption2 = dropdownList2.getFirstSelectedOption();
        WebElement selectedOption3 = dropdownList3.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
        System.out.println(selectedOption2.getText());
        System.out.println(selectedOption3.getText());
        // verify selected option
        Assert.assertEquals(selectedOption.getText(), "2020");
        Assert.assertEquals(selectedOption2.getText(), "March");
        Assert.assertEquals(selectedOption3.getText(), "27");

        System.out.println(LocalDate.now().getMonth().name() + "/" +
                        LocalDate.now().getDayOfMonth() + "/" +
                        LocalDate.now().getYear());
    }
}
