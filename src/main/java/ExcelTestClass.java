import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ExcelTestClass {
    public static void main(String[] args) throws IOException {
      ParseJsonFiles parseJsonFiles = new ParseJsonFiles();
        List<File> jsonFiles = parseJsonFiles.getJsonFiles();
        ParseGroovyClass parseGroovyClass = new ParseGroovyClass(jsonFiles.get(4));
        List<ExcelHeader> headerList = new ArrayList<>();
        ExcelHeader mainMap = parseGroovyClass.getMainMap();
        ExcelHeader movementMap = parseGroovyClass.getMovementMap();
        headerList.add(mainMap);
        headerList.add(movementMap);
        ExcelFiller excelFiller = new ExcelFiller(headerList);
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
        ExcelHeader movementHeader = headers.get(1);
        List<ExcelCell> cells = header.getCells();
        List<ExcelCell> movementCells = movementHeader.getCells();
        int countMerge = cells.size()-1;
        int movementMerge = movementCells.size()-1;
        Cell head = headerRow.createCell(0);
        Cell movement = headerRow.createCell(countMerge+1);
        head.setCellStyle(headerStyle);
        head.setCellValue(header.getName());
        movement.setCellStyle(headerStyle);
        movement.setCellValue(movementHeader.getName());
        sheet.addMergedRegion(new CellRangeAddress(
                0, //first headerRow (0-based)
                0, //last headerRow  (0-based)
                0, //first column (0-based)
                countMerge  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                0, //first headerRow (0-based)
                0, //last headerRow  (0-based)
                countMerge+1, //first column (0-based)
                movementMerge  //last column  (0-based)
        ));
       for(int i=0; i< cells.size(); i++){
           Cell currentCell = underHeadRow.createCell(i);
           currentCell.setCellValue(cells.get(i).getValue());
           sheet.autoSizeColumn(i);
       }
        int region = cells.size() + movementCells.size();

        for(int i = cells.size(); i< region; i++){
            Cell currentCell = underHeadRow.createCell(i);
            currentCell.setCellValue(movementCells.get(i-cells.size()).getValue());
            sheet.autoSizeColumn(i);
        }
        try {
            book.write(new FileOutputStream("abc.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
