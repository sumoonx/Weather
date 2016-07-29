package cn.edu.seu.jeremy.weather.rest;

import cn.edu.seu.jeremy.weather.entity.WeatherInfoRaw;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author: Jeremy Xu on 2016/7/28 16:54
 * E-mail: jeremy_xm@163.com
 */
public interface WeatherApi {

    String BASE_URL = "https://api.heweather.com/x3/";

    String KEY = "91f83356a8134719bbd575df56056ec1";

    @GET("weather")
    Observable<WeatherInfoRaw> getWeather(@Query("city") String city, @Query("key") String key);
}
