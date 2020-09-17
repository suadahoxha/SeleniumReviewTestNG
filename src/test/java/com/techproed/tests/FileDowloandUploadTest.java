package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDowloandUploadTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        //suanda bulundugumuz klasorun dosya yolunu veriyor.(String olarak)
        System.out.println(System.getProperty("user.dir"));

        //Kullanicin ana klasorunun dosya yolunu veriyor.(String veriri)
        System.out.println(System.getProperty("user.home"));

        //Java ile belirtilen adreste ,aradigimiz dosyanin var olup olamdigini
        //asagidaki kod ile yapabiliriz
        //eger dosya varsa TRUE,yoksa FALSE
        boolean varMi= Files.exists(Paths.get("/Users/apple/IdeaProjects/MeetSizeProject/SeleniumReviewTestNG/pom.xml"));
        Assert.assertTrue(varMi);
        System.out.println(varMi);
    }
    @Test
    public void dosuaUpload(){
        driver.get("https://the-internet.herokuapp.com/upload");

        //"dosya sec (choose file)" webelement locate ettik.
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        //sendKeys ile upload etmek istedigimzi dosyanin adresini gondermemiz
        chooseFile.sendKeys("/Users/apple/Downloads/image(2).png");
        driver.findElement(By.id("file-submit")).click();
    }

    @Test
    public void dosyaIndirme(){
        // websitesinden, indirmek istediğimiz dosyayı indirdikten sonra,
// bilgisayarımızda indirme klasöründe, o dosyanın var olup olmadığını kontrol
// ediyoruz. Eğer dosya varsa, indirme işleminde bir problem yok diyebiliriz.
// Dikkat edilmesi gereken bir husus : Bazen indirme işlemi uzun sürebilir. Bu yüzden
// indirme işleminden sonra, bir müddet beklemek gerekir. Thread.sleep ile yapabiliriz.

        driver.get("http://the-internet.herokuapp.com/download");
        // indirme işlemi başlıyor
        WebElement image=driver.findElement(By.partialLinkText("image.png"));
        image.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //eger dosya varsa true yoksa false
        boolean varMi= Files.exists(Paths.get("/Users/apple/Downloads/image\\ \\(5\\).png"));
        Assert.assertTrue(varMi);
    }
}
