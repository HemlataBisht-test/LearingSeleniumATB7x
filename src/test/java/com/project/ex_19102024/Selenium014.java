package com.project.ex_19102024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium014 {
@Test
    public void test(){
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts();
}
}
