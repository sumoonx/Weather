package cn.edu.seu.jeremy.weather.inject.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Jeremy Xu on 2016/7/29 09:47
 * E-mail: jeremy_xm@163.com
 */

@Module
public final class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
