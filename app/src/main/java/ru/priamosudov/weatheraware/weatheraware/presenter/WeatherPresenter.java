package ru.priamosudov.weatheraware.weatheraware.presenter;

import ru.priamosudov.weatheraware.weatheraware.view.WeatherContractView;

public interface WeatherPresenter {
    void attachView(WeatherContractView view);

    void detachView();

    void onLoadWeather(String cityName);
}
