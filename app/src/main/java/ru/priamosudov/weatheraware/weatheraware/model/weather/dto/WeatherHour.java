package ru.priamosudov.weatheraware.weatheraware.model.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.priamosudov.weatheraware.weatheraware.model.weather.dto.enums.WeatherConditionType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherHour {

    private String hour;

    private Integer temp;

    @JsonProperty(value = "feels_like")
    private Integer feelsLike;

    @JsonProperty(value = "icon")
    private String iconPathUrl;

    private WeatherConditionType condition;

    @JsonProperty(value = "wind_speed")
    private Double windSpeed;

    private Integer humidity;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Integer feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIconPathUrl() {
        return iconPathUrl;
    }

    public void setIconPathUrl(String iconPathUrl) {
        this.iconPathUrl = iconPathUrl;
    }

    public WeatherConditionType getCondition() {
        return condition;
    }

    public void setCondition(WeatherConditionType condition) {
        this.condition = condition;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherHour{" +
                "hour='" + hour + '\'' +
                ", temp=" + temp +
                ", feelsLike=" + feelsLike +
                ", iconPathUrl='" + iconPathUrl + '\'' +
                ", condition=" + condition +
                ", windSpeed=" + windSpeed +
                ", humidity=" + humidity +
                '}';
    }
}
