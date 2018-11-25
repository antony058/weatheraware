package ru.priamosudov.weatheraware.weatheraware.model.geocoder;

import ru.priamosudov.weatheraware.weatheraware.model.geocoder.dto.CityGeoData;

public interface GeoCoderRepository {
    CityGeoData getCityPosition(String cityName);
}
