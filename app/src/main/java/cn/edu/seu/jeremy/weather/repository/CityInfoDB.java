package cn.edu.seu.jeremy.weather.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cn.edu.seu.jeremy.weather.entity.CityInfo;

/**
 * Author: Jeremy Xu on 2016/8/5 10:04
 * E-mail: jeremy_xm@163.com
 */
public class CityInfoDB {

    private static final String DB_NAME = "city_info";

    private static final int VERSION = 1;

    private SQLiteDatabase db;

    @Inject
    public CityInfoDB(Context context) {
        CityOpenHelper openHelper = new CityOpenHelper(context, DB_NAME, null, VERSION);
        db = openHelper.getWritableDatabase();
    }

    public void saveCity(CityInfo cityInfo) {
        if (cityInfo != null) {
            ContentValues values = new ContentValues();
            values.put("id", cityInfo.getId());
            values.put("city", cityInfo.getCity());
            values.put("cnty", cityInfo.getCnty());
            values.put("lat", cityInfo.getLat());
            values.put("lon", cityInfo.getLat());
            values.put("prov", cityInfo.getProv());
            db.insertWithOnConflict("city", null, values, SQLiteDatabase.CONFLICT_REPLACE);
        }
    }

    public void saveCities(List<CityInfo> cityInfos) {
        for (CityInfo city :
                cityInfos) {
            saveCity(city);
        }
    }

    public List<String> loadProvinces() {
        List<String> ret = new ArrayList<>();
        Cursor cursor = db.query(true, "city", new String[]{"prov"}, null, null, null, null, "prov", null);
        if (cursor.moveToFirst()) {
            do {
                ret.add(cursor.getString(cursor.getColumnIndex("prov")));
            } while (cursor.moveToNext());
        }
        return ret;
    }

    public List<String> loadCity(String province) {
        List<String> ret = new ArrayList<>();
        Cursor cursor = db.query("city", new String[]{"city"}, "prov=?", new String[]{province}, null, null, "city");
        if (cursor.moveToFirst()) {
            do {
                ret.add(cursor.getString(cursor.getColumnIndex("city")));
            } while (cursor.moveToNext());
        }
        return ret;
    }

    public boolean isEmpty() {
        Cursor cursor = db.query("city", new String[]{"prov"}, null, null, null, null, null, null);
        return cursor.getCount() == 0;
    }
}
