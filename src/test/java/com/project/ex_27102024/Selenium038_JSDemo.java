package com.project.ex_27102024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium038_JSDemo {
    WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.get("https://selectorshub.com/xpath-practice-page");
        driver.manage().window().maximize();
    }
    @Description("Verify Java Script ")
    @Test
    public void test_js() throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor)driver;
        WebElement elementToScroll= driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",elementToScroll);
        Thread.sleep(3000);
        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"#pizza\");");
        inputboxPizza.sendKeys("farmhouse");

        driver.quit();


    }

}
