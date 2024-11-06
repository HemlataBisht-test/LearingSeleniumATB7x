package com.project.ex_20102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium028 {
    @Description("Verify that the eBay print the price of iMac")
    @Test
    public  void test_ebay_print_price() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchbox= driver.findElement(By.xpath("//input[@name='_nkw']"));
        searchbox.sendKeys("macmini");
        WebElement searchicon = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchicon.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> listofTitle = driver.findElements(By.xpath("//div[@class='s-item__title']/span"));
        List<WebElement> itemsPrice= driver.findElements(By.xpath("//span[@class='s-item__price']"));
        int size = Math.min(listofTitle.size(),itemsPrice.size());
        for (int i=0;i<size;i++){
            System.out.println("Title : "+listofTitle.get(i).getText()+ "|| " +"Price : " +itemsPrice.get(i).getText());
            System.out.println();
        }

        driver.quit();
    }

}
