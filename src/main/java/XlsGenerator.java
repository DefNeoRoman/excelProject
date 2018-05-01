import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class XlsGenerator {
    private Workbook book = new HSSFWorkbook();
    private Sheet sheet = book.createSheet("Omnicomm");

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
