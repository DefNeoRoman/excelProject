import java.util.List;

public class ExcelFiller {
    private List<ExcelCell> additionalDataMap;
    private List<ExcelCell> columns;

    public ExcelFiller(List<ExcelCell> additionalDataMap, List<ExcelCell> columns) {
        this.additionalDataMap = additionalDataMap;
        this.columns = columns;
    }

    public List<ExcelCell> getAdditionalDataMap() {
        return additionalDataMap;
    }

    public void setAdditionalDataMap(List<ExcelCell> additionalDataMap) {
        this.additionalDataMap = additionalDataMap;
    }

    public List<ExcelCell> getColumns() {
        return columns;
    }

    public void setColumns(List<ExcelCell> columns) {
        this.columns = columns;
    }
}
