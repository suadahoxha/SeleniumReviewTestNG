package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {
    // her test methodundan önce çalışır.
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void test(){
        FhcTripHotelCreatePage createPage = new FhcTripHotelCreatePage(driver);
        createPage.codeKutusu.sendKeys("123");
        createPage.nameKutusu.sendKeys("yoruldum hayat");
        createPage.adressKutusu.sendKeys("gelme ustume");
        createPage.phoneKutusu.sendKeys("3245214");
        createPage.emailKutusu.sendKeys("sbcdhsf@hkjfdh");
        Select select=new Select(createPage.idGroupDropDown);
        select.selectByIndex(1);
        createPage.saveButonu.submit();
        WebDriverWait wait=new WebDriverWait(driver,30);
        //WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        boolean esitMi=wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"Hotel was inserted successfully"));
        Assert.assertTrue(createPage.basariliYazisi.isDisplayed());

    }
}
