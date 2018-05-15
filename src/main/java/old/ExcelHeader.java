package old;

import java.util.List;

public class ExcelHeader {
    private String name;
    private List<ExcelCell> cells;

    public ExcelHeader(String name, List<ExcelCell> cells) {
        this.name = name;
        this.cells = cells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExcelCell> getCells() {
        return cells;
    }

    public void setCells(List<ExcelCell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "old.ExcelHeader{" +
                "name='" + name + '\'' +
                ", cells=" + cells +
                '}';
    }
}
