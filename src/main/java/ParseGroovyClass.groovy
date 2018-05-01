import groovy.json.JsonSlurper
import org.apache.poi.poifs.filesystem.Entry

// Сюда закладываем схему и дальше с ней работаем
class ParseGroovyClass {
    private File file;
    private JsonSlurper jsonSlurper = new JsonSlurper();
    private def res = jsonSlurper.parse(file)
    private  List<PathEntity> entities = new ArrayList<>();
    private String mainName =   res.groups.main.name;
    private def mainFields  =   res.groups.main.fields;




    ParseGroovyClass(File file) {
        this.file = file
        entities.add(new PathEntity(mainName,mainFields))
    }

    ExcelHeader getMainMap(){
        String name = mainName;
        List<ExcelCell> cellList = new ArrayList<>();
        def list = (Map)mainFields;
        list.each {key,value -> cellList.add(new ExcelCell(key,value))}
        ExcelHeader header = new ExcelHeader(name,cellList);
       return  header;
    }
    ExcelHeader getMovementMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        String name = res.groups.movement.name;
        List<ExcelCell> cellList = new ArrayList<>();
        def list = (Map)res.groups.movement.fields;
        list.each {key,value -> cellList.add(new ExcelCell(key,value))}
        ExcelHeader header = new ExcelHeader(name,cellList);
        return  header;
    }
    Map<String,String> getFuelMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
    }
    Map<String,String> getFuel2Map(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
    }
    Map<String,String> getUVMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
    }
    Map<String,String> getCanEndMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
    }
    Map<String,String> getCanCountersMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
    }

    Map<String,String> getCanLoadingMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
    }
}
