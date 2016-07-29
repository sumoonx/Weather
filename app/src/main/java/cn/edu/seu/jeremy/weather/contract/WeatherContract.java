package cn.edu.seu.jeremy.weather.contract;

import java.util.List;

import cn.edu.seu.jeremy.weather.entity.WeatherInfo;

/**
 * Author: Jeremy Xu on 2016/7/28 21:53
 * E-mail: jeremy_xm@163.com
 */
public interface WeatherContract {

    public interface IView extends MvpView {

        void showLoading();

        void showError(String error);

        void renderWeather(WeatherInfo weather);
    }

    public interface Presenter {

        void updateWeather(String city);
    }
}
