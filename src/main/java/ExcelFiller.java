import java.util.List;

public class ExcelFiller {
    private List<ExcelHeader> headers;

    public ExcelFiller(List<ExcelHeader> headers) {
        this.headers = headers;
    }

    public List<ExcelHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<ExcelHeader> headers) {
        this.headers = headers;
    }
}
