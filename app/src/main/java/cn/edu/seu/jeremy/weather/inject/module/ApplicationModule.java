package cn.edu.seu.jeremy.weather.inject.module;

import android.content.Context;

import javax.inject.Singleton;

import cn.edu.seu.jeremy.weather.repository.CityInfoDB;
import dagger.Module;
import dagger.Provides;

/**
 * Author: Jeremy Xu on 2016/7/29 09:47
 * E-mail: jeremy_xm@163.com
 */

@Module
public final class ApplicationModule {

    private final Context mContext;

    private final CityInfoDB cityInfoDB;

    public ApplicationModule(Context context) {
        mContext = context;
        cityInfoDB = new CityInfoDB(context);
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton @Provides
    CityInfoDB provideCityInfoDB() {
        return cityInfoDB;
    }
}
