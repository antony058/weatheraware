package ru.priamosudov.weatheraware.weatheraware.model.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartContainer {

    @JsonProperty(value = "day_short")
    private ShortPart dayShort;

    @JsonProperty(value = "night_short")
    private ShortPart nightShort;

    public ShortPart getDayShort() {
        return dayShort;
    }

    public void setDayShort(ShortPart dayShort) {
        this.dayShort = dayShort;
    }

    public ShortPart getNightShort() {
        return nightShort;
    }

    public void setNightShort(ShortPart nightShort) {
        this.nightShort = nightShort;
    }

    @Override
    public String toString() {
        return "PartContainer{" +
                "dayShort=" + dayShort +
                ", nightShort=" + nightShort +
                '}';
    }
}
