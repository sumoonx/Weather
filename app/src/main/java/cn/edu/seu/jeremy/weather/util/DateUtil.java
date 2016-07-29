package cn.edu.seu.jeremy.weather.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Author: Jeremy Xu on 2016/7/29 15:01
 * E-mail: jeremy_xm@163.com
 */
public class DateUtil {

    public static final String[] WEEK = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    public static int getWeekInt() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static String getWeekString() {
        return WEEK[getWeekInt() - 1];
    }

    public static List<String> getNextSixDay() {
        int today = getWeekInt();
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            ret.add(WEEK[today++ % 7]);
        }
        return ret;
    }
}
