package cn.edu.seu.jeremy.weather;

import android.app.Application;

import cn.edu.seu.jeremy.weather.inject.component.ApiServiceComponent;
import cn.edu.seu.jeremy.weather.inject.component.DaggerApiServiceComponent;
import cn.edu.seu.jeremy.weather.inject.module.ApiServiceModule;

/**
 * Author: Jeremy Xu on 2016/7/29 09:48
 * E-mail: jeremy_xm@163.com
 */
public class WeatherApplication extends Application {

    private ApiServiceComponent mApiServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiServiceComponent = DaggerApiServiceComponent.builder()
                .apiServiceModule(new ApiServiceModule(getApplicationContext()))
                .build();
    }

    public ApiServiceComponent getApiServiceComponent() {
        return mApiServiceComponent;
    }
}
