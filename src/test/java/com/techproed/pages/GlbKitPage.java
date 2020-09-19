package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
2. ÖRNEK : Yazldızlı Çay Bardağı
a ) https://www.glbtrader.com/listing/Home-Garden-Kitchen--Dining-Bar/60/67
	Bu sayfaya gidelim. Bu sayfaya gitmek için;
	1- Driver class'ını kullanın.
	2- Sayfa adresini properties dosyasına ekleyin ve oradan alın.
		glb_kitchen = https://www.glbtr...
b ) Pages paketinin altında GlbKitPage isminde bir tane class oluşturun.
	İçerisinde "Yaldızlı Çay Bardağı" ürününü webelemtent şeklinde bulun.
		@FindBy (partialLinkText = "..")
	ürünün başlığını webelement şeklinde bulun.
	ürünün fiyatını webelement şeklinde bulun.
	ürünün açıklamasını webelement şeklinde bulun.
c ) Bu webelementlerin içerdiği yazıları ekrana yazdırın.


 */
public class GlbKitPage {
    public GlbKitPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='Yaldizli Cay bardagi']")
    public WebElement cayBardagi;

    @FindBy(xpath = "//h4[@class='pro_new_head']")
    public WebElement urunBasligi;

    @FindBy(xpath = "//span[@class='maincolor font24 bold fix-md-set']")
    public WebElement urunFiyati;

    @FindBy(xpath = "//*[.='A set of large size tea glasses']")
    public WebElement urunAciklamasi;
}
