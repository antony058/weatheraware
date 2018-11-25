package ru.priamosudov.weatheraware.weatheraware.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import ru.priamosudov.weatheraware.weatheraware.R;
import ru.priamosudov.weatheraware.weatheraware.WeatherAwareApplication;
import ru.priamosudov.weatheraware.weatheraware.model.geocoder.impl.GeoCoderRepositoryImpl;
import ru.priamosudov.weatheraware.weatheraware.model.weather.impl.WeatherRepositoryImpl;
import ru.priamosudov.weatheraware.weatheraware.presenter.WeatherPresenter;
import ru.priamosudov.weatheraware.weatheraware.presenter.impl.WeatherPresenterImpl;
import ru.priamosudov.weatheraware.weatheraware.view.WeatherContractView;

public class MainActivity extends AppCompatActivity implements WeatherContractView {

    private Button getWeatherButton;
    private EditText cityNameEditText;

    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherPresenter = new WeatherPresenterImpl(
                new GeoCoderRepositoryImpl(WeatherAwareApplication.getGeoCoderApi()),
                new WeatherRepositoryImpl(WeatherAwareApplication.getWeatherApi())
        );
        weatherPresenter.attachView(this);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (weatherPresenter != null) {
            weatherPresenter.detachView();
        }
    }

    private void init() {
        cityNameEditText = findViewById(R.id.cityNameEditText);

        getWeatherButton = findViewById(R.id.getWeatherButton);
        getWeatherButton.setOnClickListener(v ->
                weatherPresenter.onLoadWeather(cityNameEditText.getText().toString()));
    }
}
