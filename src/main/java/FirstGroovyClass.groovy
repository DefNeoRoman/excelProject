import groovy.json.JsonSlurper

// Файл локализации смаппить на xls схему
// строим xls файл
// значения берем из rows
class FirstGroovyClass {
    static void main(String[] args){

    }
    Map<String, String> getColumnMap(File file){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
       return  (Map) res.language.column;
    }
    Map<String,String> getAdditionalDataMap(File file){
        JsonSlurper jsonSlurper = new JsonSlurper();
        def res = jsonSlurper.parse(file)
        return  (Map) res.language.column.additionalData;
    }

}
