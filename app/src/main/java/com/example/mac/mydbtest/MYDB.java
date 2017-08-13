package com.example.mac.mydbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mac on 2017/8/13.
 */

public class MYDB extends SQLiteOpenHelper {
    private static final String creatSQL=
            "CREATE TABLE CUST(_ID INTEGER PRIMARY KEY AUTOINCREMENT,CNAME TEXT,TEL TEXT,BIRTHDAY DATE)";
    public MYDB(Context context, String name,
                SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creatSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
