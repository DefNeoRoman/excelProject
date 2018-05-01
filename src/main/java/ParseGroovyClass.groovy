import groovy.json.JsonSlurper
import org.apache.poi.poifs.filesystem.Entry

// Сюда закладываем схему и дальше с ней работаем
class ParseGroovyClass {
    private File file;

    ParseGroovyClass(File file) {
        this.file = file
    }

    ExcelHeader getMainMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        String name = res.groups.main.name;
        List<ExcelCell> cellList = new ArrayList<>();

       def list = (Map)res.groups.main.fields;

        list.each {key,value -> cellList.add(new ExcelCell(key,value))}

        ExcelHeader header = new ExcelHeader(name,cellList);
       return  header;
    }
    Map<String,String> getMovementMap(){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
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
