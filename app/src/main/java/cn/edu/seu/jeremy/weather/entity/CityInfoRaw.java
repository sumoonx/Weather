package cn.edu.seu.jeremy.weather.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Jeremy Xu on 2016/8/5 11:17
 * E-mail: jeremy_xm@163.com
 */
public class CityInfoRaw {

    @SerializedName("city_info") @Expose
    private List<CityInfo> mCityInfo
            = new ArrayList<>();

    @SerializedName("status") @Expose
    private String status;

    public List<CityInfo> getCityInfos() {
        return mCityInfo;
    }

    public String getStatus() {
        return status;
    }
}
