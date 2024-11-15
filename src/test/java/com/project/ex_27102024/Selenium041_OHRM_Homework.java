package com.project.ex_27102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium041_OHRM_Homework {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
    }
    @Description("Verify that the First Terminated Employe and Click on the Delete icon ()")
    @Test
    public void test_orangeHRM() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        WebElement element_to_scroll= driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element_to_scroll);
        int row= driver.findElements(By.xpath("//div[@role='row']")).size();
        int column= driver.findElements(By.xpath("//div[@role='cell']")).size();
        System.out.println(row);
        System.out.println(column);
        for (int i=1;i<=row;i++){
            for (int j=1;j<=column;j++){
                // Construct the XPath for the current cell in the table
                String cellXPath = "//div[@role='row'][" + i + "]//div[@role='cell'][" + j + "]";
             //   String cellText = driver.findElement(By.xpath(cellXPath)).getText();
                if (cellXPath.contains("Terminated")){

                    driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
                    System.out.println("Tarminated is clicked");
                    break; // Exit the loop after clicking the target element

                }
            }
            Thread.sleep(3000);
            driver.quit();

            }
        }

    }

