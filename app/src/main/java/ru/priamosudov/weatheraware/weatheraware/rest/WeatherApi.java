package ru.priamosudov.weatheraware.weatheraware.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import ru.priamosudov.weatheraware.weatheraware.model.weather.dto.CityWeatherData;

public interface WeatherApi {

    String API_KEY = "aa1b9dd1-2bf2-4436-ac28-b9a0c27bbb05";

    @GET(value = "forecast")
    Call<CityWeatherData> loadWeather(@Query(value = "lat") String lat,
                                      @Query(value = "lon") String lon,
                                      @Header(value = "X-Yandex-API-Key") String apiKey);
}
