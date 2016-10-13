package com.coolweather.lin.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.lin.entity.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/10/13.
 */

public class CoolWeatherDB {
    private CoolWeatherOpenHelper helper;
    private SQLiteDatabase db;
    private static CoolWeatherDB coolWeatherDB;
    private static final String DN_NAME = "cool_weather";
    private static final int VERSION = 1;

    private CoolWeatherDB(Context context) {
        helper = new CoolWeatherOpenHelper(context, DN_NAME, null, VERSION);
        db = helper.getWritableDatabase();
    }

    public synchronized static CoolWeatherDB getInstance(Context context) {
        if (coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    public void insertProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            db.insert("province", null, values);
        }
    }

    public List<Province> queryProvince() {
        List<Province> list = new ArrayList<>();
        Cursor cursor = db.query("province", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));

                list.add(province);
            } while (cursor.moveToNext());
        }
        return list;
    }

}
