package com.project.ex_19102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium013 {
    @Description("Verify that Account registration is successful")
    @Test
    public void testCreateRegistration() {
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximaized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("diya");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("gupta");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("diyagupta@mail.com");
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("9874567834");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("test1234");
        WebElement confirmPassword = driver.findElement(By.name("confirm"));
        confirmPassword.sendKeys("test1234");
     //   WebElement newsletter = driver.findElement(By.linkText("No"));
      //  newsletter.click();
        WebElement checkbox = driver.findElement(By.name("agree"));
        checkbox.click();
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement accountCreate = driver.findElement(By.xpath("//div//h1"));
        System.out.println(accountCreate.getText());
        Assert.assertEquals(accountCreate.getText(),"Your Account Has Been Created!");
        WebElement submit2 = driver.findElement(By.linkText("Continue"));
        submit2.click();
        WebElement verification = driver.findElement(By.linkText("My Account"));
        System.out.println(verification.getText());
        Assert.assertEquals(verification.getText(),"My Account");
        driver.quit();



    }

}
