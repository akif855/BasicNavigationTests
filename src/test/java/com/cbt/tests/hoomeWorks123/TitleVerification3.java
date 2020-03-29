package com.cbt.tests.hoomeWorks123;

import com.cbt.utilities.WebDriverFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {

        List<String> webBrowser = Arrays.asList("chrome","firefox","edge");

        for(String browsers : webBrowser) {
            WebDriver driver = WebDriverFactory.getDriver(browsers);

            List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                    "https://wayfair.com",
                    "https://www.westelm.com",
                    "https://walmart.com");

            List<String> titles = new ArrayList<>();
            List<String> actualUrls = new ArrayList<>();

            for (String url : urls) {
                driver.get(url);
                titles.add(driver.getTitle().toLowerCase().replace(" ", ""));
                actualUrls.add(driver.getCurrentUrl().toLowerCase().replace(" ", ""));
            }
            System.out.println("4. Verify that URL of the website contains the title of the website. Ignore spaces and case in comparison.");
            StringUtility.verifyContains(actualUrls.get(0), titles.get(0));

            System.out.println("4. Verify that URL of the website contains the title of the website. Ignore spaces and case in comparison.");
            StringUtility.verifyContains(actualUrls.get(1), titles.get(1));

            System.out.println("4. Verify that URL of the website contains the title of the website. Ignore spaces and case in comparison.");
            StringUtility.verifyContains(actualUrls.get(2), titles.get(2));

            System.out.println("4. Verify that URL of the website contains the title of the website. Ignore spaces and case in comparison.");
            StringUtility.verifyContains(actualUrls.get(3), titles.get(3));

            driver.quit();
        }
    }
}
