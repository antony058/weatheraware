package ru.priamosudov.weatheraware.weatheraware;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.priamosudov.weatheraware.weatheraware.rest.GeoCoderApi;
import ru.priamosudov.weatheraware.weatheraware.rest.WeatherApi;

public class WeatherAwareApplication extends Application {

    private static GeoCoderApi geoCoderApi;

    private static WeatherApi weatherApi;

    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        OkHttpClient okHttpClient = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.yandex_geocoder_base_url))
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
        geoCoderApi = retrofit.create(GeoCoderApi.class);

        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.yandex_weather_base_url))
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }

    public static GeoCoderApi getGeoCoderApi() {
        return geoCoderApi;
    }

    public static WeatherApi getWeatherApi() {
        return weatherApi;
    }
}
