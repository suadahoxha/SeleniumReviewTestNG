package com.techproed.utilities;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigurationReader {
    private static Properties properties;
    static{
        String dosyaYolu = "/Users/apple/IdeaProjects/MeetSizeProject/SeleniumReviewTestNG/Configuration.properties";
        try{
            // okumak istediğiniz dosyanın, dosya yolunu göndermeniz gerekiyor.
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e){
        }
    }
    public static String getProperty(String key){
        String deger = properties.getProperty(key);
        return deger;
    }
}
