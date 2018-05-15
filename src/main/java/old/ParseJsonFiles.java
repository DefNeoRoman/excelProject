package old;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonFiles {

    private List<File> filesList = new ArrayList<>();

    public List<File> getJsonFiles() {
         return filesList;
    }

    public void addJsonFileToList(String path) {
        URL resource = ParseJsonFiles.class.getResource(path);
        filesList.add(new File(resource.getFile()));
    }
}
