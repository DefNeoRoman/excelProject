package old

import groovy.json.JsonSlurper

// Сюда закладываем схему и дальше с ней работаем
class ParseGroovyClass {
    private File file;
    private JsonSlurper jsonSlurper = new JsonSlurper();
    private def res = jsonSlurper.parse(file)
    private List<PathEntity> entities = new ArrayList<>();


    ParseGroovyClass(File file) {
        this.file = file

    }
    public void test(){
        def ob = (List)res.rows;
        List<Map<Object,Object>> result = new ArrayList<>();
        ob.each {value -> result.add((Map) value)}
        println result.get(0).get("shiftsStart")


    }
    ExcelHeader getMainMap() {
        String name = mainName;
        List<ExcelCell> cellList = new ArrayList<>();
        def list = (Map) mainFields;
        list.each { key, value -> cellList.add(new ExcelCell(key, value)) }
        ExcelHeader header = new ExcelHeader(name, cellList);
        return header;
    }

    ExcelHeader getMovementMap() {
        String name = movementName;
        List<ExcelCell> cellList = new ArrayList<>();
        def list = (Map) movementFields;
        list.each { key, value -> cellList.add(new ExcelCell(key, value)) }
        ExcelHeader header = new ExcelHeader(name, cellList);
        return header;
    }

    ExcelHeader getHeader(String name, def fields) {
        def map = (Map) fields;
        List<ExcelCell> cellList = new ArrayList<>();
        map.each { key, value ->

            cellList.add(new ExcelCell(key, value))}

        ExcelHeader header = new ExcelHeader(name, cellList);
        return header;
    }

    List<ExcelHeader> getHeaders() {
     String mainName = res.groups.main.name;
     def mainFields = res.groups.main.fields;
     String movementName = res.groups.movement.name;
     def movementFields = res.groups.movement.fields;
      entities.add(new PathEntity(mainName, mainFields))
      entities.add(new PathEntity(movementName, movementFields))
      List<ExcelHeader> headers = new ArrayList<>();
      for (int i = 0; i < entities.size(); i++) {
          PathEntity pathEntity = entities.get(i)
            ExcelHeader currentHeader = getHeader(pathEntity.getName(), pathEntity.getFields());
            headers.add(currentHeader);
        }
        return headers
    }

}
