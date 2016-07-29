package cn.edu.seu.jeremy.weather.inject.module;

import android.content.Context;

import javax.inject.Singleton;

import cn.edu.seu.jeremy.weather.service.ApiService;
import cn.edu.seu.jeremy.weather.service.WeatherService;
import dagger.Module;
import dagger.Provides;

/**
 * Author: Jeremy Xu on 2016/7/29 09:54
 * E-mail: jeremy_xm@163.com
 */
@Module
public final class ApiServiceModule {

    private final ApiService mApiService;

    public ApiServiceModule(Context context) {
        mApiService = new ApiService(context);
    }

    @Singleton
    @Provides
    WeatherService provideWeatherService() {
        return mApiService;
    }
}
