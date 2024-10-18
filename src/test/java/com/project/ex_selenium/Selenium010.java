package com.project.ex_selenium;

import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenium010 {
    // get vs Navigate.to()


    public static void main(String[] args) throws MalformedURLException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://bing.com");
        // No back, forward option allowed in case of get
        // There is no diffrence between the get and Navigate.to(). but Navigate.to() have some extra feature like
        // backward and forward option and refesh page option in Navigate.to()
        // in case of VPN use proxy.setHttpProxy("<HOST:PORT>");


        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to(new URL("https://google.com"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();




    }

}
