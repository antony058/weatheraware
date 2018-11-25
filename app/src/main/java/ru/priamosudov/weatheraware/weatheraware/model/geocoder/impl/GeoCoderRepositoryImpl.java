package ru.priamosudov.weatheraware.weatheraware.model.geocoder.impl;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Response;
import ru.priamosudov.weatheraware.weatheraware.model.geocoder.GeoCoderRepository;
import ru.priamosudov.weatheraware.weatheraware.model.geocoder.dto.CityGeoData;
import ru.priamosudov.weatheraware.weatheraware.rest.GeoCoderApi;
import ru.priamosudov.weatheraware.weatheraware.rest.enums.FormatType;

public class GeoCoderRepositoryImpl implements GeoCoderRepository {

    private final GeoCoderApi geoCoderApi;
    private final ExecutorService executorService;

    public GeoCoderRepositoryImpl(GeoCoderApi geoCoderApi) {
        this.geoCoderApi = geoCoderApi;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public CityGeoData getCityPosition(String cityName) {
        Future<Response<CityGeoData>> responseFuture = executorService.submit(() -> {
            try {
                return geoCoderApi
                        .getCityGeoData(cityName, FormatType.JSON.getTypeName(), GeoCoderApi.API_KEY)
                        .execute();
            } catch (IOException e) {
                Log.e("GeoCoderRepositoryImpl", "IOException by executing getCityPosition(String), message: ".concat(e.getMessage()));
            }
            return null;
        });
        try {
            Response<CityGeoData> response = responseFuture.get();
            if (response != null) {
                return response.body();
            }
        } catch (ExecutionException e) {
            Log.e("GeoCoderRepositoryImpl", "ExecutionException by executing getCityPosition(String)"
                    .concat(" by cause: ")
                    .concat(e.getCause().getClass().getSimpleName())
                    .concat(" ;with message: ")
                    .concat(e.getCause().getMessage()));
        } catch (InterruptedException e) {
            Log.e("GeoCoderRepositoryImpl", "The thread was interrupted when try to executing getCityPosition(String), message: "
                    .concat(e.getMessage()));
        }
        return null;
    }
}
