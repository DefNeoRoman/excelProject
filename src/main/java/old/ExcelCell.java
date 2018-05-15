package old;

public class ExcelCell {
    private String key;
    private String value;
    private int row;

    public ExcelCell(String key, String value) {
        this.key = key;
        this.value = value;

    }

    @Override
    public String toString() {
        return "old.ExcelCell{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
