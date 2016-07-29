package cn.edu.seu.jeremy.weather.util;

/**
 * Author: Jeremy Xu on 2016/7/29 19:29
 * E-mail: jeremy_xm@163.com
 */
public class UnitUtil {

    public static String temprature(String temp) {
        return temp + "°";
    }

    public static String percentage(String percent) {
        return percent + '%';
    }

    public static String windSpeed(String speed) {
        return speed + "公里/小时";
    }

    public static String centiMeter(String distance) {
        return distance + "厘米";
    }

    public static String kiloMeter(String distance) {
        return distance + "公里";
    }

    public static String windPress(String press) {
        return press + "百帕";
    }
}
