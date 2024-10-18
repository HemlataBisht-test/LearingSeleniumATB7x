package com.project.ex_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Selenium008 {
    // Add extention in chrome.
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("src/test/java/com/project/ex_selenium/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_6_9_3_0 (1).crx"));
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
    }
}
