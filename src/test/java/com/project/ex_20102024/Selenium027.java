package com.project.ex_20102024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium027 {

    @Test
    public  void test_verify_expire_message(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // different xpath and css for 1 element
//        WebElement username_input_css_1 = driver.findElement(By.cssSelector("input#username"));
//        WebElement username_input_css_2 = driver.findElement(By.cssSelector("#username"));
//        WebElement username_input_name = driver.findElement(By.name("username"));
        WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
        email.sendKeys("augtest_040823@idrive.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("123456");
        WebElement span_checkbox = driver.findElement(By.className("id-checkmark"));
        span_checkbox.click();

        WebElement button_submit = driver.findElement(By.cssSelector("div.id-frm-btnblk > button"));
        button_submit.click();
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement error_message= driver.findElement(By.xpath("//h5[@class='id-card-title']"));
        Assert.assertEquals(error_message.getText(),"Your free trial has expired");
        driver.quit();
    }
}
