package com.cbt.tests.homeWork4;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Days {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    /*
    1. go to  http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
    2. Randomly select a checkbox. As soon as you check any day, print the name of the day and uncheck immediately.
    After you check and uncheck Friday for the third time, exit the program.
    NOTE: Remember some checkboxes are not selectable. You need to find a way to ignore them when they are randomly selected.
    It has to be dynamic. Do not hard code Saturday and Sunday. Use values of certain attributes.
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox ");
        Thread.sleep(3000);
        List<WebElement> checkBoxList = driver.findElements(By.cssSelector("[type='checkbox']"));
        List<WebElement> dayList = driver.findElements(By.cssSelector("[for]"));
        List<String> dayTextList = BrowserUtils.getElementsText(dayList);
        Random rd = new Random();
        int counter =0;
        while(counter<3){
            int random = rd.nextInt(7);
            if(random>=0 && random<=4){ //!dayTextList.get(random).equals("Saturday") && !dayTextList.get(random).equals("Sunday")
                checkBoxList.get(random).click();
                System.out.println(dayTextList.get(random));
                checkBoxList.get(random).click();
                if(random==4){
                    counter++;
                }
            }
        }
    }
}
