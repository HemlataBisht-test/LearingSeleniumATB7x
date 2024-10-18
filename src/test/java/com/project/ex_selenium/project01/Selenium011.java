package com.project.ex_selenium.project01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium011 {
    // Open the app.vwo.com
    // We want to verify the title by using the TestNG assertion.
    @Test
    public void testVWOPageTitle(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.quit();

    }
}
