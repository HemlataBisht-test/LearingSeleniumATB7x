package com.project.ex_26102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium030 {
    @Description("Verify that the pop should closed")
    @Test
    public void makeMyTripPopupTest(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());

        WebElement popup=driver.findElement(By.xpath("//section[@data-cy='CommonModal_2']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfAllElements(popup));
        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
        driver.quit();
    }

}
