import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.List;


public class ExcelTestClass {
    public static void main(String[] args) throws IOException {
      ParseJsonFiles parseJsonFiles = new ParseJsonFiles();
        List<File> jsonFiles = parseJsonFiles.getJsonFiles();
        ParseGroovyClass parseGroovyClass = new ParseGroovyClass(jsonFiles.get(4));
        ExcelHeader mainMap = parseGroovyClass.getMainMap();
        ExcelFiller excelFiller = new ExcelFiller(Collections.singletonList(mainMap));
        xlsConstructor(excelFiller);
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
    public static void xlsConstructor(ExcelFiller filler){
        XlsGenerator xlsGenerator = new XlsGenerator();
        Workbook book = xlsGenerator.getBook();
        Sheet sheet = xlsGenerator.getSheet();
        Row headerRow = sheet.createRow(0);
        Row underHeadRow = sheet.createRow(1);
        CellStyle headerStyle = xlsGenerator.getHeaderStyle();
        List<ExcelHeader> headers = filler.getHeaders();
        ExcelHeader header = headers.get(0);
        List<ExcelCell> cells = header.getCells();
        int countMerge = cells.size();
        Cell head = headerRow.createCell(0);
        head.setCellStyle(headerStyle);
        head.setCellValue(header.getName());
        sheet.addMergedRegion(new CellRangeAddress(
                0, //first headerRow (0-based)
                0, //last headerRow  (0-based)
                0, //first column (0-based)
                countMerge  //last column  (0-based)
        ));
       for(int i=0; i< cells.size(); i++){
           Cell currentCell = underHeadRow.createCell(i);

           ExcelCell excelCell =  cells.get(i);

           currentCell.setCellValue(cells.get(i).getValue());
       }
        try {
            book.write(new FileOutputStream("abc.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
