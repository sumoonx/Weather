package cn.edu.seu.jeremy.weather.inject.module;

import cn.edu.seu.jeremy.weather.contract.WeatherContract;
import dagger.Module;
import dagger.Provides;

/**
 * Author: Jeremy Xu on 2016/7/29 10:26
 * E-mail: jeremy_xm@163.com
 */
@Module
public class WeatherPresenterModule {

    private final WeatherContract.IView mView;

    public WeatherPresenterModule(WeatherContract.IView iView) {
        mView = iView;
    }

    @Provides
    WeatherContract.IView provideWeatherContractIView() {
        return mView;
    }
}
