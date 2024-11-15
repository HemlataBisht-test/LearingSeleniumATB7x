package com.project.ex_02112024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium042 {
    WebDriver driver;

    @Test
    public void test_webTable(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable1.html");
        //table= //table[@summary='Sample Table']
        WebElement table= driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        // rows and column
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        for (int i=1; i< rows.size();i++){
            List <WebElement> column =rows.get(i).findElements(By.tagName("td"));
            for (WebElement c: column) {
                System.out.println(c.getText());
                
            }
        }
    }
}
