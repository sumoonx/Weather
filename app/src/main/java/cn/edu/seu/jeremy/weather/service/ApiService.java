package cn.edu.seu.jeremy.weather.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import cn.edu.seu.jeremy.weather.entity.WeatherInfo;
import cn.edu.seu.jeremy.weather.entity.WeatherInfoRaw;
import cn.edu.seu.jeremy.weather.rest.WeatherApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Author: Jeremy Xu on 2016/7/28 17:57
 * E-mail: jeremy_xm@163.com
 */
public class ApiService implements WeatherService {

    private Context mContext;

    private OkHttpClient mOkHttpClient;

    private Retrofit mRetrofit;

    private WeatherApi mWeatherApi;

    @Inject
    public ApiService(Context context) {
        mContext = context;
        initOkHttp();
        initRetrofit();
        mWeatherApi = mRetrofit.create(WeatherApi.class);
    }

    @Override
    public Observable<WeatherInfo> getWeatherInfo(String city) {
        return mWeatherApi.getWeather(city, WeatherApi.KEY)
                .flatMap(new Func1<WeatherInfoRaw, Observable<WeatherInfoRaw>>() {
                    @Override
                    public Observable<WeatherInfoRaw> call(WeatherInfoRaw weatherInfoRaw) {
                        if (weatherInfoRaw.getWeatherInfos().get(0).getStatus().equals("no more requests")) {
                            return Observable.error(new RuntimeException("/(ㄒoㄒ)/~~,API免费次数已用完"));
                        }
                        return Observable.just(weatherInfoRaw);
                    }
                })
                .map(new Func1<WeatherInfoRaw, WeatherInfo>() {
                    @Override
                    public WeatherInfo call(WeatherInfoRaw weatherInfoRaw) {
                        return weatherInfoRaw.getWeatherInfos().get(0);
                    }
                })
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//            builder.addInterceptor(interceptor);
//        }
//
//        File cacheFile = new File(mContext.getExternalCacheDir(), "/WeatherCache");
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 20);   //20M cache
//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Response ret;
//                Request request = chain.request();
//                if (!isNetWorkConnected()) {
//                    request = request.newBuilder()
//                            .cacheControl(CacheControl.FORCE_CACHE)
//                            .build();
//                    ret = chain.proceed(request);
//                    int maxStale = 60 * 60 * 24 * 28;
//                    ret.newBuilder()
//                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                            .build();
//                } else {
//                    int maxAge = 0;
//                    ret = chain.proceed(request);
//                    ret.newBuilder()
//                            .header("Cache-Control", "public, max-age=" + maxAge)
//                            .build();
//                }
//                return ret;
//            }
//        };
//        mOkHttpClient = builder.cache(cache).addInterceptor(interceptor)
//                .connectTimeout(15, TimeUnit.SECONDS)
//                .readTimeout(20, TimeUnit.SECONDS)
//                .writeTimeout(20, TimeUnit.SECONDS)
//                .retryOnConnectionFailure(true)
//                .build();
        mOkHttpClient = builder.connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(WeatherApi.BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
                .build();
    }

    private boolean isNetWorkConnected() {
        if (mContext != null) {
            ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }
        return false;
    }
}
