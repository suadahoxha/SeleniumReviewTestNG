package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class windowhandlesil extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
      String windowHandle= driver.getWindowHandle();
        System.out.println(windowHandle);
      Thread.sleep(3000);
        WebElement clickHere=driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        Thread.sleep(3000);
        driver.switchTo().window(windowHandle);
        Set<String> allhandles=driver.getWindowHandles();
        System.out.println(allhandles);

        for(String handle:allhandles){
            if(!handle.equals(windowHandle))
            System.out.println(handle);
        }

    }
}