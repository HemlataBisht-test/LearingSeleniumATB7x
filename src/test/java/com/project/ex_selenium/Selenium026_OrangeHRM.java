package com.project.ex_selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium026_OrangeHRM {
    WebDriver driver;
    @BeforeTest
    public void setUP(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

    }
    @Description("Verify that login successfully")
    @Test
    public void testOrangeHRM()
    {

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("admin");
        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
    @Description("Find the First Terminated Employee and Click on the Delete icon ()")
    @Test (dependsOnMethods = "testOrangeHRM")
    public void validateThePIMPage() throws InterruptedException {
        WebElement webTable = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webTable);
       // javascriptExecutor.executeScript("window.scrollBy(0,500);");
        Thread.sleep(3000);

    }
    @AfterTest
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    }

