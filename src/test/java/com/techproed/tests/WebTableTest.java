package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void basliklar() {
        //sayfadaki basliklar
        List<WebElement> basliklar = driver.findElements(By.xpath("//thead//th"));
        for (WebElement w : basliklar) {
            System.out.println(w.getText());
        }
    }
   @Test
   public void tumSatirlar(){
        //sayfadaki tum satirlar
       List<WebElement>satirlar=driver.findElements(By.xpath("//tbody/tr"));
       for(WebElement w:satirlar){
           System.out.println(w.getText());
       }
   }
   @Test
    public void sutunYazdirma(){
        List<WebElement>besincisutun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for(WebElement w:besincisutun){
            System.out.println(w.getText());
        }
   }
   @Test
    public void istenilenHucre(){
        WebElement cell=driver.findElement(By.xpath("//tbody/tr[2]/td[5]"));
       System.out.println(cell.getText());
       System.out.println(driver.findElements(By.xpath("//tbody/tr/td[1]")).size());
   }


    }

