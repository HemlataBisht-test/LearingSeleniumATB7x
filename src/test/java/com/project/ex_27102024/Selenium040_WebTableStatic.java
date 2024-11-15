package com.project.ex_27102024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium040_WebTableStatic {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable.html");
    }

    @Description("Verify the Web Table")
    @Test
    public void test_WebTable(){
        // Rows -//table[@id='customers']/tbody/tr
        //Columns- //table[@id='customers']/tbody/tr[2]/td
        int rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int column = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
        System.out.println(rows);
        System.out.println(column);
        // //table[@id="customers"]/tbody/tr[2]/td[3]

        // first_part   - //table[@id="customers"]/tbody/tr[
        //  i
        // second -> ]/td[
        // j
        // ]

        // xpath - //table[@id="customers"]/tbody/tr[
        // i
        // ]/td[
        // j
        // ]
        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";
        // i = 1 to 7
        // j = 1,2,3
        for (int i=2;i<=rows;i++){
            for (int j=1;j<=column;j++){
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
               // System.out.println(data);
                if (data.contains("Yoshi Tannamuri")){
                    String countryPath=dynamic_xpath+"/following-sibling::td";
                    String country_company = dynamic_xpath+"/preceding-sibling::td";
                    String country_text = driver.findElement(By.xpath(countryPath)).getText();
                    String company_text = driver.findElement(By.xpath(country_company)).getText();
                    System.out.println("------");
                    System.out.println("Yoshi Tannamuri is In - " + country_text);
                   System.out.println("Yoshi Tannamuri is Company - " + company_text);
                }
                driver.quit();
            }
        }
    }

}
