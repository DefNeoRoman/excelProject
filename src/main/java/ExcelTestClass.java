import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ExcelTestClass {
    public static void main(String[] args) throws IOException {
      ExcelTestClass excelTestClass = new ExcelTestClass();
        List<ExcelCell> headers = excelTestClass.getHeaders();
        List<ExcelCell> additionalDataHeaders = excelTestClass.getAdditionalDataMap();
        excelTestClass.xlsConstructor(new ExcelFiller(additionalDataHeaders,headers));
    }
    public List<ExcelCell> getHeaders(){
        ParseJsonFiles parseJsonFiles = new ParseJsonFiles();
        List<File> fileList = parseJsonFiles.getJsonFiles();
        File locale = fileList.get(3);
        FirstGroovyClass firstGroovyClass = new FirstGroovyClass();
        Map<String, String> localeMap = firstGroovyClass.getColumnMap(locale);
        List<ExcelCell> cellsList = new ArrayList<>();
        localeMap.entrySet().forEach(f->{
            try{
                ExcelCell excelCell = new ExcelCell(f.getKey(),f.getValue());
                cellsList.add(excelCell);
            }catch (Exception e){

            }
        });
        return cellsList;
    }
    public List<ExcelCell> getAdditionalDataMap(){
        ParseJsonFiles parseJsonFiles = new ParseJsonFiles();
        List<File> fileList = parseJsonFiles.getJsonFiles();
        File locale = fileList.get(3);
        FirstGroovyClass firstGroovyClass = new FirstGroovyClass();
        Map<String, String> localeMap = firstGroovyClass.getAdditionalDataMap(locale);
        List<ExcelCell> cellsList = new ArrayList<>();
        localeMap.entrySet().forEach(f->{
            try{
                ExcelCell excelCell = new ExcelCell(f.getKey(),f.getValue());
                cellsList.add(excelCell);
            }catch (Exception e){

            }
        });
        return cellsList;
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
    public void xlsConstructor(ExcelFiller filler){
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Omnicomm");
        Row row = sheet.createRow(0);
        CellStyle style = book.createCellStyle();
        //foreground color чтобы установить задний фон ячейки
        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        List<ExcelCell> cellList = filler.getColumns();
        cellList.addAll(filler.getAdditionalDataMap());
        int countCells = cellList.size();
        for(int i=0; i<countCells; i++){
            Cell cell = row.createCell(i);
            ExcelCell excelCell = cellList.get(i);
            cell.setCellValue(excelCell.getValue());
            cell.setCellStyle(style);
        }
       try {
            book.write(new FileOutputStream("abc.xls"));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
