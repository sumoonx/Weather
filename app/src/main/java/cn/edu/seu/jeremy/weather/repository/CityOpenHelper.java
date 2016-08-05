package cn.edu.seu.jeremy.weather.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: Jeremy Xu on 2016/8/5 09:51
 * E-mail: jeremy_xm@163.com
 */
public class CityOpenHelper extends SQLiteOpenHelper {

    private static final String CREATE_CITY = "CREATE TABLE IF NOT EXISTS city ("
            + "id TEXT PRIMARY KEY, "
            + "city TEXT, "
            + "cnty TEXT, "
            + "lat TEXT, "
            + "lon TEXT, "
            + "prov TEXT)";

    public CityOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CITY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
