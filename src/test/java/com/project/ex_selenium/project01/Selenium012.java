package com.project.ex_selenium.project01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium012 {
    @Test
    public void testPageTitleofKatalon(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--starts-maximized");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
       // System.out.println(driver.getPageSource());
        if (driver.getPageSource().contains("CURA Healthcare Service")){
            System.out.println("CURA Healthcare Service");
        }
        else {
            System.out.println("CURA Healthcare Service is not present ");
        }
      //  Assert.assertEquals(driver.getPageSource().contains("CURA Healthcare Service"),"CURA Healthcare Service");
        driver.quit();
    }
}
