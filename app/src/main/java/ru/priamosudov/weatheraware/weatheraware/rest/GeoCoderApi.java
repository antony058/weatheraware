package ru.priamosudov.weatheraware.weatheraware.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.priamosudov.weatheraware.weatheraware.model.geocoder.dto.CityGeoData;

public interface GeoCoderApi {

    String API_KEY = "aa1b9dd1-2bf2-4436-ac28-b9a0c27bbb05";

    @GET(value = "1.x")
    Call<CityGeoData> getCityGeoData(@Query(value = "geocode") String name,
                                     @Query(value = "format") String formatType,
                                     @Query(value = "apikey") String apiKey);
}
