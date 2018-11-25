package ru.priamosudov.weatheraware.weatheraware.model.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

    private String date;

    private String sunrise;

    private String sunset;

    private PartContainer parts;

    private List<WeatherHour> hours;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public PartContainer getParts() {
        return parts;
    }

    public void setParts(PartContainer parts) {
        this.parts = parts;
    }

    public List<WeatherHour> getHours() {
        return hours;
    }

    public void setHours(List<WeatherHour> hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", parts=" + parts +
                ", hours=" + hours +
                '}';
    }
}
