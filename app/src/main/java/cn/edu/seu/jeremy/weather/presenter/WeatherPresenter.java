package cn.edu.seu.jeremy.weather.presenter;

import javax.inject.Inject;

import cn.edu.seu.jeremy.weather.contract.WeatherContract;
import cn.edu.seu.jeremy.weather.entity.WeatherInfo;
import cn.edu.seu.jeremy.weather.service.WeatherService;
import cn.edu.seu.jeremy.weather.util.LogUtil;
import rx.Subscriber;

/**
 * Author: Jeremy Xu on 2016/7/28 22:05
 * E-mail: jeremy_xm@163.com
 */
public class WeatherPresenter extends Presenter<WeatherContract.IView> implements WeatherContract.Presenter {

    private final WeatherService mWeatherService;

    private WeatherInfo mWeather;

    @Inject
    public WeatherPresenter(WeatherService service, WeatherContract.IView view) {
        mWeatherService = service;
        takeView(view);
    }

    @Override
    public void updateWeather(String city) {
        mWeatherService.getWeatherInfo(city).subscribe(mSubscriber);
    }

    private Subscriber mSubscriber = new Subscriber<WeatherInfo>() {
        @Override
        public void onCompleted() {
            LogUtil.i("weather loaded");
        }

        @Override
        public void onError(Throwable e) {
            getMvpView().showError(e.toString());
        }

        @Override
        public void onNext(WeatherInfo weatherInfo) {
            mWeather = weatherInfo;
            getMvpView().renderWeather(weatherInfo);
        }
    };
}
