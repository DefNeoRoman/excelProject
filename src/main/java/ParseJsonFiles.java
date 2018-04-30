import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonFiles {
    public static void main(String[] args) {


    }
    public List<File> getJsonFiles(){
        URL locale =    ParseJsonFiles.class.getResource("locale.json");
        URL rows =      ParseJsonFiles.class.getResource("rows.json");
        URL xlsSchema = ParseJsonFiles.class.getResource("xlsModel.json");
        URL local_ru = ParseJsonFiles.class.getResource("localization-ru.json");

        List<File> files = new ArrayList<>();

        files.add(new File(locale.getFile()));
        files.add(new File(rows.getFile()));
        files.add(new File(xlsSchema.getFile()));
        files.add(new File(local_ru.getFile()));

        return files;
    }
}
