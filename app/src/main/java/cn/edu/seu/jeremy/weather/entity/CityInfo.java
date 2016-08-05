package cn.edu.seu.jeremy.weather.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Author: Jeremy Xu on 2016/8/5 09:48
 * E-mail: jeremy_xm@163.com
 */
public class CityInfo {

    /**
     * city : 南子岛
     * cnty : 中国
     * id : CN101310230
     * lat : 11.26
     * lon : 114.20
     * prov : 海南
     */

    @SerializedName("city")
    private String city;
    @SerializedName("cnty")
    private String cnty;
    @SerializedName("id")
    private String id;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("prov")
    private String prov;

    public static CityInfo objectFromData(String str) {

        return new Gson().fromJson(str, CityInfo.class);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }
}
