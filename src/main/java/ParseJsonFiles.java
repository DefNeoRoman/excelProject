import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonFiles {

    public List<File> getJsonFiles(){
        URL locale =    ParseJsonFiles.class.getResource("fake/locale.json");
        URL rows =      ParseJsonFiles.class.getResource("fake/rows.json");
        URL xlsSchema = ParseJsonFiles.class.getResource("fake/xlsModel.json");
        URL local_ru = ParseJsonFiles.class.getResource("localization-ru.json");
        URL groups = ParseJsonFiles.class.getResource("groups.json");

        List<File> files = new ArrayList<>();

        files.add(new File(locale.getFile()));
        files.add(new File(rows.getFile()));
        files.add(new File(xlsSchema.getFile()));
        files.add(new File(local_ru.getFile()));
        files.add(new File(groups.getFile()));

        return files;
    }
}
