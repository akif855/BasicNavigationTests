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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Date {
    WebDriver driver;
    WebElement yearDD;
    WebElement monthDD;
    WebElement dayDD;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        yearDD = driver.findElement(By.id("year"));
        monthDD = driver.findElement(By.id("month"));
        dayDD = driver.findElement(By.id("day"));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    /*
    1. go to http://practice.cybertekschool.com/dropdown
    2. verify that dropdowns under Select your date of birth display current year, month, day
     */
    @Test
    public void todaysDate(){
        List<WebElement> listDD = Arrays.asList(yearDD,monthDD,dayDD);
        List<String> listExpected = Arrays.asList(String.valueOf(LocalDate.now().getYear()),
                LocalDate.now().getMonth().name().toLowerCase(),String.valueOf(LocalDate.now().getDayOfMonth()));
        for(int i= 0; i<listDD.size();i++){
            Select select = new Select(listDD.get(i));
            WebElement selectedOption = select.getFirstSelectedOption();
            Assert.assertEquals(selectedOption.getText().toLowerCase(),listExpected.get(i));
        }
        Select select = new Select(yearDD);
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(),"2020");

        select = new Select(monthDD);
        selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "March");

        select = new Select(dayDD);
        selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "27");
    }
    /*
    1. go to http://practice.cybertekschool.com/dropdown
    2. select a random year under Select your date of birth
    3. select month January
    4. verify that days dropdown has current number of days
    5. repeat steps 3, 4 for all the months
    NOTE: if you randomly select a leap year, verify February has 29 days
     */
    @Test
    public void yearsMonthsDays(){
        int[] numberOfDays={31,28,31,30,31,30,31,31,30,31,30,31,30,31};
        Select select;
        Random rd =  new Random();
        for(int i =0; i<12; i++){
            select = new Select(yearDD);
            select.selectByIndex(rd.nextInt(100));
            int selectedYear = Integer.parseInt(select.getFirstSelectedOption().getText());
            select = new Select(monthDD);
            select.selectByIndex(i);
            select = new Select(dayDD);
            if(selectedYear%4==0 && i==1) {
                Assert.assertEquals(select.getOptions().size(), 29);
            }else{
                Assert.assertEquals(select.getOptions().size(), numberOfDays[i]);
            }
        }
    }
}
