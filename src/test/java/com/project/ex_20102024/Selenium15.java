package com.project.ex_20102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;


public class Selenium15 {

    @Description("Verify the price list present in ebay for macmini")
    @Test
    public void testEBay(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
       // chromeOptions.addArguments("--start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");
       WebElement searchbox= driver.findElement(By.xpath("//input[@id='gh-ac']"));
       searchbox.sendKeys("macmini");
       WebElement serchButton= driver.findElement(By.xpath("//input[@value='Search']"));
       serchButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Search the title present for macmini
    List<WebElement> searchTitle =driver.findElements(By.xpath("//div[@class='s-item__title']"));
    List<WebElement> searchPrices =driver.findElements(By.className("s-item__price"));


        int size = Math.min(searchTitle.size(),searchPrices.size());
        for (int i = 0; i < size; i++) {
            System.out.println("Title: "+searchTitle.get(i).getText()+"||"+ "Price : "+searchPrices.get(i).getText());
            System.out.println("Price: "+searchPrices.get(i).getText());
        // Maximum and minium value from the list
//            int max = Collections.max(Integer.parseInt(searchPrices));
//            int min = Collections.min(searchPrices);
//            double maxValue=Double.MAX_VALUE;
//            double minValue=Double.MIN_VALUE;

            driver.quit();

        }
    }
}
