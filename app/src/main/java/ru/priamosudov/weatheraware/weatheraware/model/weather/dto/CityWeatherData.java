package ru.priamosudov.weatheraware.weatheraware.model.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityWeatherData {

    private Fact fact;

    private List<Forecast> forecasts;

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public String toString() {
        return "CityWeatherData{" +
                "fact=" + fact +
                ", forecasts=" + forecasts +
                '}';
    }
}
