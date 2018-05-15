package old;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


public class ExcelTestClass {
    public static void main(String[] args) throws IOException {
        ParseJsonFiles parseJsonFiles = new ParseJsonFiles();
        parseJsonFiles.addJsonFileToList("groups.json");
        parseJsonFiles.addJsonFileToList("real.json");
        parseJsonFiles.addJsonFileToList("visibleAttributes.json");
        parseJsonFiles.addJsonFileToList("attrsWithoutCondition.json");
        List<File> jsonFiles = parseJsonFiles.getJsonFiles();
        ParseGroovyClass parseGroovyClass = new ParseGroovyClass(jsonFiles.get(0));
        ParseGroovyClass pGroovyClass2 = new ParseGroovyClass(jsonFiles.get(1));
       //распарсили реальный json в лист из мап
        pGroovyClass2.test();
//        List<old.ExcelHeader> headerList = parseGroovyClass.getHeaders();
//        old.ExcelFiller excelFiller = new old.ExcelFiller(headerList);
//        xlsConstructor(excelFiller);
    }


    public void testXls() {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");
        Row row = sheet.createRow(0);
        Cell name = row.createCell(0);
        name.setCellValue("John");
        Cell birthdate = row.createCell(1);
        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);
        birthdate.setCellValue(new Date(110, 10, 10));
        sheet.autoSizeColumn(1);
        try {
            book.write(new FileOutputStream("abc.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void xlsConstructor(ExcelFiller filler) {
        XlsGenerator xlsGenerator = new XlsGenerator(filler);
        Workbook book = xlsGenerator.getBook();
        xlsGenerator.createHeader();

        try {
            book.write(new FileOutputStream("abc.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
