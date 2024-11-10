package com.project.ex_26102024;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium034 {
    @Description("Verify that all JavaScript Alerts will handle by Selenium")
    @Test
    public void test_HandleThe_Alerts(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert= driver.switchTo().alert();
        alert.accept();
        String result= driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        alert.accept();
       // Assert.assertEquals(result,"You clicked: Ok");

        WebElement elementPrompt= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        elementPrompt.click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        alert.sendKeys("Hemlata Bisht");
        alert.accept();
//        alert.dismiss();

        Assert.assertEquals(result,"You entered: Hemlata Bisht");
        driver.quit();
    }
}
