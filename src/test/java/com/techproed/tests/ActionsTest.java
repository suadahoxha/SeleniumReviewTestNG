package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {
    @Test
    public  void rightClick(){

        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions=new Actions(driver);
        WebElement rightClickMe=driver.findElement(By.xpath("//*[.='right click me']"));
        actions.contextClick(rightClickMe).perform();
    }

    @Test
    public  void doubleClick(){
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions=new Actions(driver);

        WebElement doubleClick=driver.findElement(By.xpath("//*[.='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClick).perform();

    }
    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        Actions actions=new Actions(driver);
        WebElement accountList=driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }

    @Test
    public void upDownTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions actions=new Actions(driver);
        //web sayfasinin en altina gider
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        //web sayfasinda yukari cikmak istiyorsak
        //1.Yontem->PAGE_UP BUTONU
        actions.sendKeys(Keys.PAGE_UP).perform();

        Thread.sleep(3000);
        //2.yontem->ARROW_UP butonu
        actions.sendKeys(Keys.ARROW_UP).perform();

        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);

        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.HOME).perform();

    }
    @Test
    public void keyUpDown(){
        //MERHABA nasilsiniz
        //shifte basili tutarak merhaba            ->MERHABA
        //shiften elimizi kaldirdigimiz nasilsiniz ->nasilsiniz
        driver.get("https://www.google.com/");
        Actions actions=new Actions(driver);

        WebElement aramaKutusu=driver.findElement(By.name("q"));
        //aramakutusu.semdKeys("merhaba nasilsiniz"
        actions.moveToElement(aramaKutusu).click().keyDown(Keys.SHIFT).sendKeys("merhaba").
                                                    keyUp(Keys.SHIFT).sendKeys("nasilsiniz").
                                                                                perform();
    }
    @Test
    public void ikiTusaAyniAndaTiklama(){
        driver.get("https://www.google.com/");
        Actions actions=new Actions(driver);
        //ALT F4 tiklayinca sayfayi kapatiyor
        //actions.keyDown(Keys.ALT).keyDown(Keys.F4).perform(); FAIL VERIYOR
    }
}
