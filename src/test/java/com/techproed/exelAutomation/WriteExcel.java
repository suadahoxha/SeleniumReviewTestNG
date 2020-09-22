package com.techproed.exelAutomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test() throws IOException {
        String dosyaAdresi="src/test/resources/Ulkeler.xlsx";
        // JAVA'da herhangi bir dosyanın açılabilmesi için, FileInputStream
        // class'ından bir tane nesne oluşturulur. Ve parametre olarak,
        // açılmak istenen dosyanın adresi eklenir.
        FileInputStream fileInputStream = new FileInputStream(dosyaAdresi);
        // Excel dosyasını okumak için Workbook kullanıyoruz.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //Dosyaya yeni bir bilgi ekleyebilmek icin (dosya yazmak icin)
        FileOutputStream fileOutputStream=new FileOutputStream(dosyaAdresi);

        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NUFUS");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue(222333444);

        //Istedigimiz row tamamiyle silmek icin
        Row onuncuRow=workbook.getSheetAt(0).getRow(10);
        workbook.getSheetAt(0).removeRow(onuncuRow);
        //istedigimiz cell i silmek icin
        Cell cell=workbook.getSheetAt(0).getRow(1).getCell(3);
        workbook.getSheetAt(0).getRow(1).removeCell(cell);



        //Yaptigimiz degisiklikleri excel dosyasina uygular ve kaydeder.
        workbook.write(fileOutputStream);


    fileOutputStream.close();
    workbook.close();
    fileInputStream.close();
    }
}
