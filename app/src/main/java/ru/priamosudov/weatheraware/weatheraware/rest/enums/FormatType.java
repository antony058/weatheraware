package ru.priamosudov.weatheraware.weatheraware.rest.enums;

public enum FormatType {

    JSON("json"),
    XML("xml");

    private String typeName;

    FormatType(String typeName) {
     this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
