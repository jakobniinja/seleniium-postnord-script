package com.jakobniinja.postnordscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PostnordScriptApplication {
    public static void main(String[] args) throws InterruptedException {
        final String seleniumUrl = "https://www.postnord.se/vara-verktyg/sok-utdelningsdag";

//        <------- Config --------->

        System.setProperty("webdriver.chrome.driver", "/home/niinja/selenium-drivers/chromedriver");
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(handlingSSL);

//        <------- Config --------->

//        < -------     let the browser load the webelements  ------->
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(seleniumUrl);
        System.out.println("title is :" + driver.getTitle());

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();


        Thread.sleep(6000);
        driver.quit();
    }

}
