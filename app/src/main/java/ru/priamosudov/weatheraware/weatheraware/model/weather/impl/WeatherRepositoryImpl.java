package ru.priamosudov.weatheraware.weatheraware.model.weather.impl;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Response;
import ru.priamosudov.weatheraware.weatheraware.model.geocoder.dto.CityGeoData;
import ru.priamosudov.weatheraware.weatheraware.model.weather.WeatherRepository;
import ru.priamosudov.weatheraware.weatheraware.model.weather.dto.CityWeatherData;
import ru.priamosudov.weatheraware.weatheraware.rest.WeatherApi;

public class WeatherRepositoryImpl implements WeatherRepository {

    private final WeatherApi weatherApi;

    private final ExecutorService executorService;

    public WeatherRepositoryImpl(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
        executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public CityWeatherData loadCityWeather(CityGeoData cityGeoData) {
        Future<Response<CityWeatherData>> responseFuture = executorService.submit(() -> {
            try {
                return weatherApi
                        .loadWeather(cityGeoData.getLat(), cityGeoData.getLon(), WeatherApi.API_KEY)
                        .execute();
            } catch (IOException e) {
                Log.e("WeatherRepositoryImpl", "IOException by executing loadCityWeather(CityGeoData), message: ".concat(e.getMessage()));
            }
            return null;
        });
        try {
            Response<CityWeatherData> response = responseFuture.get();
            if (response != null) {
                return response.body();
            }
        } catch (ExecutionException e) {
            Log.e("WeatherRepositoryImpl", "ExecutionException by executing loadCityWeather(CityGeoData)"
                    .concat(" by cause: ")
                    .concat(e.getCause().getClass().getSimpleName())
                    .concat(" ;with message: ")
                    .concat(e.getCause().getMessage()));
        } catch (InterruptedException e) {
            Log.e("WeatherRepositoryImpl", "The thread was interrupted when try to executing loadCityWeather(CityGeoData), message: "
                    .concat(e.getMessage()));
        }
        return null;
    }
}
