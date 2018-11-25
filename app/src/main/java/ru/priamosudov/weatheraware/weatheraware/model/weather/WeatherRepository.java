package ru.priamosudov.weatheraware.weatheraware.model.weather;

import ru.priamosudov.weatheraware.weatheraware.model.geocoder.dto.CityGeoData;
import ru.priamosudov.weatheraware.weatheraware.model.weather.dto.CityWeatherData;

public interface WeatherRepository {
    CityWeatherData loadCityWeather(CityGeoData cityGeoData);
}
