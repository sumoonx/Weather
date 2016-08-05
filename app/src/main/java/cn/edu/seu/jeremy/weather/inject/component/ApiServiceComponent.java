package cn.edu.seu.jeremy.weather.inject.component;

import javax.inject.Singleton;

import cn.edu.seu.jeremy.weather.repository.CityInfoDB;
import cn.edu.seu.jeremy.weather.inject.module.ApiServiceModule;
import cn.edu.seu.jeremy.weather.inject.module.ApplicationModule;
import cn.edu.seu.jeremy.weather.service.WeatherService;
import cn.edu.seu.jeremy.weather.ui.CityFragment;
import dagger.Component;

/**
 * Author: Jeremy Xu on 2016/7/29 09:59
 * E-mail: jeremy_xm@163.com
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiServiceModule.class})
public interface ApiServiceComponent {

    WeatherService getWeatherService();

    CityInfoDB getCityInfoDB();

    void inject(CityFragment fragment);
}
