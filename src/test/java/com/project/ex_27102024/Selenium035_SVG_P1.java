package com.project.ex_27102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium035_SVG_P1 {
    WebDriver driver;

    @BeforeTest
    public void setUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }

    @Description("Verify the search feature of flipkart")
    @Test
    public void test_flipkart_search() {
        // Step 1 - Enter the "macnmini" in the inputbox.
        WebElement input = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        input.sendKeys("macmini");
        // Step 2 - Click on the svg element.
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();

        List<WebElement> titlesResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement title : titlesResults) {
            System.out.println(title.getText());
        }


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
