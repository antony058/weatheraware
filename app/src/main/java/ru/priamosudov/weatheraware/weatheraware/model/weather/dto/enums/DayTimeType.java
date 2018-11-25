package ru.priamosudov.weatheraware.weatheraware.model.weather.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DayTimeType {
    DAY("d"),
    NIGHT("n");

    private String type;

    DayTimeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @JsonCreator
    public static DayTimeType forValue(String value) {
        for (DayTimeType type : values()) {
            if (type.getType().equals(value)) {
                return type;
            }
        }
        return null;
    }
}
