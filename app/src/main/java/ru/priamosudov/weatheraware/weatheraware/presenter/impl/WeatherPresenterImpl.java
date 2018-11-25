package ru.priamosudov.weatheraware.weatheraware.presenter.impl;

import android.util.Log;

import ru.priamosudov.weatheraware.weatheraware.model.geocoder.GeoCoderRepository;
import ru.priamosudov.weatheraware.weatheraware.model.geocoder.dto.CityGeoData;
import ru.priamosudov.weatheraware.weatheraware.model.weather.WeatherRepository;
import ru.priamosudov.weatheraware.weatheraware.model.weather.dto.CityWeatherData;
import ru.priamosudov.weatheraware.weatheraware.presenter.WeatherPresenter;
import ru.priamosudov.weatheraware.weatheraware.view.WeatherContractView;

public class WeatherPresenterImpl implements WeatherPresenter {

    private final GeoCoderRepository geoCoderRepository;

    private final WeatherRepository weatherRepository;

    private WeatherContractView view;

    public WeatherPresenterImpl(GeoCoderRepository geoCoderRepository, WeatherRepository weatherRepository) {
        this.geoCoderRepository = geoCoderRepository;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public void attachView(WeatherContractView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void onLoadWeather(String cityName) {
        CityGeoData cityGeoData = geoCoderRepository.getCityPosition(cityName);
        if (cityGeoData == null) {
            Log.d("WeatherPresenterImpl", "cityGeoData was not loaded(or other problem, e.g. parse data, etc)");
            return;
        }
        Log.d("WeatherPresenterImpl", cityGeoData.toString());

        CityWeatherData cityWeatherData = weatherRepository.loadCityWeather(cityGeoData);
        if (cityWeatherData == null) {
            Log.d("WeatherPresenterImpl", "cityWeatherData was not loaded(or other problem, e.g. parse data, etc)");
            return;
        }
        Log.d("WeatherPresenterImpl", cityWeatherData.toString());
        // TODO load weather by city position and show it in the view
    }
}
