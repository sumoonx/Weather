package cn.edu.seu.jeremy.weather.inject.component;

import cn.edu.seu.jeremy.weather.ui.WeatherFragment;
import cn.edu.seu.jeremy.weather.inject.FragmentScoped;
import cn.edu.seu.jeremy.weather.inject.module.WeatherPresenterModule;
import dagger.Component;

/**
 * Author: Jeremy Xu on 2016/7/29 10:29
 * E-mail: jeremy_xm@163.com
 */
@FragmentScoped
@Component(dependencies = ApiServiceComponent.class, modules = WeatherPresenterModule.class)
public interface WeatherComponent {

    void inject(WeatherFragment fragment);

}
