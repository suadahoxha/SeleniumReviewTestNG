package com.techproed.smoketests;

import com.techproed.pages.GlbKitPage;
import com.techproed.pages.GlbPantsPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GlbKitsTest {

    @Test(groups = "glbtest")
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_kitchen"));
        GlbKitPage glbKitPage=new GlbKitPage();
        glbKitPage.cayBardagi.click();

        System.out.println(glbKitPage.urunBasligi.getText());
        System.out.println(glbKitPage.urunFiyati.getText());
        System.out.println(glbKitPage.urunAciklamasi.getText());
    }

}
