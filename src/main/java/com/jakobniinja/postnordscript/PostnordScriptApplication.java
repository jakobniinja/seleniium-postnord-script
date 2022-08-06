package com.jakobniinja.postnordscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

@Configuration
@SpringBootApplication
public class PostnordScriptApplication {
    public static void main(String[] args) throws InterruptedException {
        final int postkod = 12456;
        CharSequence charSequence = new StringBuffer("12456");
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
        driver.findElement(By.xpath("//*[@id=\"block-DeliveryDaySearchBlockProxy-41857\"]/div/pn-zipcode-search/pn-search-field/div/input")).sendKeys(charSequence);
        driver.findElement(By.xpath("//*[@id=\"block-DeliveryDaySearchBlockProxy-41857\"]/div/pn-zipcode-search/pn-search-field/div/input")).sendKeys(Keys.ENTER);

        System.out.println("postkod is: " + postkod);
        Thread.sleep(600000);
        driver.quit();
    }
}


