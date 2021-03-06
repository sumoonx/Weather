package cn.edu.seu.jeremy.weather.service;

import java.util.List;

import cn.edu.seu.jeremy.weather.entity.CityInfo;
import cn.edu.seu.jeremy.weather.entity.WeatherInfo;
import rx.Observable;

/**
 * Author: Jeremy Xu on 2016/7/28 21:50
 * E-mail: jeremy_xm@163.com
 */
public interface WeatherService {
    Observable<WeatherInfo> getWeatherInfo(String city);

    Observable<List<CityInfo>> getCityInfo();
}
