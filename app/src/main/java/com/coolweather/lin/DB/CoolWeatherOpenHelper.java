package com.coolweather.lin.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lin on 2016/10/13.
 */

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{
    /*
     *创建province表
     */
    private static final String  CREATE_PROVINCE= "create table province(" +
            "id integer primary key autoincrement," +
            "province_name text" +
            "province_code text)";

    /*
     * 创建city表
     */
    private static final String CREATE_CITY="create table city(" +
            "id integer primary key autoincrement" +
            "city_name text" +
            "city_code text" +
            "province_id integer)";

    /*
     *创建country表
     */
    private static final String CREATE_COUNTRY="create table country(" +
            "id integer primary key autoincrement" +
            "country_name text" +
            "country_code text" +
            "city_id integer)";

    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
