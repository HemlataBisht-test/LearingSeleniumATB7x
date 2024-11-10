package com.project.ex_26102024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium033 {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        WebElement element_select= driver.findElement(By.id("dropdown"));
        Select select = new Select(element_select);
//        select.selectByVisibleText("Option 2");
        select.selectByIndex(2);
        driver.quit();

    }
}
