package old

class PathEntity {
    private String name;
    private def fields;

    PathEntity(String name, fields) {
        this.name = name
        this.fields = fields
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    def getFields() {
        return fields
    }

    void setFields(fields) {
        this.fields = fields
    }
}
