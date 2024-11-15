package com.project.ex_27102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium036_SVG_P2 {
    WebDriver driver;

    @BeforeTest
    public void setUP() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
    }

    @Description("Verify that Tripura present in India map and click on it")
    @Test
    public void test_svg_india_search_click() {
        List<WebElement> sates=driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name()='path']"));
        for (WebElement state :sates){
            System.out.println(state.getAttribute("aria-label"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(state.getAttribute("aria-label").contains("Assam")){
                state.click();
            }


        }


    }

    public void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
