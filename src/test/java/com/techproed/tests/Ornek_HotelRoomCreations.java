package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_HotelRoomCreations extends TestBase {

    @BeforeMethod
    public void beforeMethos(){

        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void test(){
        WebElement idHotelDropdown=driver.findElement(By.id("IDHotel"));
        WebElement codeKutusu=driver.findElement(By.id("Code"));
        WebElement nameKutusu=driver.findElement(By.id("Name"));
        WebElement locationKutusu=driver.findElement(By.id("Location"));
        WebElement descKutusu=driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        WebElement priceKutusu=driver.findElement(By.id("Price"));
        WebElement fiyat500=driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement roomDropdown=driver.findElement(By.id("IDGroupRoomType"));
        WebElement adultCountKutusu=driver.findElement(By.id("MaxAdultCount"));
        WebElement childCountKutusu=driver.findElement(By.id("MaxChildCount"));
        WebElement saveButonu=driver.findElement(By.id("btnSubmit"));

       Select hotelDropdown=new Select(idHotelDropdown);
       hotelDropdown.selectByIndex(2);

       codeKutusu.sendKeys("9999");
       nameKutusu.sendKeys("suat");
       locationKutusu.sendKeys("Dubai");
       descKutusu.sendKeys("denize sifir wood odalar");

       //dragAndDrop  - Actions clastan obje uretecegiz
        Actions actions=new Actions(driver);
        actions.dragAndDrop(fiyat500,priceKutusu).perform();

        Select select=new Select(roomDropdown);
        select.selectByIndex(3);

        adultCountKutusu.sendKeys("2");
        childCountKutusu.sendKeys("4");
        saveButonu.click();
    }
}
