package cn.edu.seu.jeremy.weather.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jeremy Xu on 2016/7/28 20:32
 * E-mail: jeremy_xm@163.com
 */
public class WeatherInfoRaw {

    @SerializedName("HeWeather data service 3.0") @Expose
    private List<WeatherInfo> mWeatherInfo
            = new ArrayList<>();

    public List<WeatherInfo> getWeatherInfos() {
        return mWeatherInfo;
    }
}
