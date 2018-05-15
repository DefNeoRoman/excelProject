package old;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class XlsGenerator {
    private Workbook book = new HSSFWorkbook();
    private Sheet sheet = book.createSheet("Omnicomm");
    private Row headRow = sheet.createRow(0);
    private Row underHeadRow = sheet.createRow(1);
    private ExcelFiller filler;

    public XlsGenerator() {

    }

    public XlsGenerator(ExcelFiller filler) {

        this.filler = filler;

    }
    public void createHeader(){
        List<ExcelHeader> headers = filler.getHeaders();
        ExcelHeader header = headers.get(0);
        ExcelHeader movementHeader = headers.get(1);

        List<ExcelCell> cells = header.getCells();
        List<ExcelCell> movementCells = movementHeader.getCells();

        int countMerge = cells.size()-1;
        int movementMerge = movementCells.size()-1;

        Cell head = headRow.createCell(0);
        Cell movement = headRow.createCell(countMerge+1);

        head.setCellStyle(getHeaderStyle());
        head.setCellValue(header.getName());
        movement.setCellStyle(getHeaderStyle());
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
                movementMerge+countMerge+1  //last column  (0-based)
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
    }

    public Workbook getBook() {
        return book;
    }

    public Sheet getSheet() {
        return sheet;
    }
    public CellStyle getHeaderStyle(){
        CellStyle style = book.createCellStyle();
        //foreground color чтобы установить задний фон ячейки
        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }
}
