package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    // https://the-internet.herokuapp.com/iframe
// 1. Adım : Sayfadaki iframe'i bulacağız.
// 2. Adım : O iframe'in içerisindeki "p" tag name'ine sahip webelementi bulacağız.
// 3. Adım : İçerisine "Selamlar IFRAME" yazdıracağız.
// 4. Adım : Iframe'den çıkış yapıp, sayfamıza döneceğiz (defaultContent)
// 5. Adım : "Elemental Selenium" linkini bulup, tıklayacağız.

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

       //1. driver.switchTo().frame(0);
       //2. driver.switchTo().frame("mceu_28");
        WebElement frame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);

        WebElement yaziBolumu=driver.findElement(By.tagName("p"));
        yaziBolumu.clear();
        yaziBolumu.sendKeys("selamlar FRAME");
        driver.switchTo().defaultContent();
        WebElement link=driver.findElement(By.partialLinkText("Elemental Selenium"));
        System.out.println(link.getText());


    }
}