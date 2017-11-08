package com.benboubaker.qrcodereader.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.benboubaker.qrcodereader.models.Code;
import com.google.zxing.qrcode.encoder.QRCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fekhe on 06/11/2017.
 */

public class DBHandler extends SQLiteOpenHelper implements DB {

    private static DBHandler INSTANCE;
    private SQLiteDatabase db;

    private DBHandler(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public static DBHandler getInstance(Context context) {
        INSTANCE = INSTANCE != null ? INSTANCE : new DBHandler(context);
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATION_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    @Override
    public List<Code> getAll() {
        List<Code> list = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME+" order by id desc", null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Code code = new Code()
                    .setId(cursor.getInt(0))
                    .setContent(cursor.getString(1))
                    .setType(cursor.getString(2));
            list.add(code);
        }
        db.close();
        return list;
    }

    @Override
    public void addCode(Code code) {
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", code.getId());
        values.put("content", code.getContent());
        values.put("type", code.getType());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void removeCode(int id) {
        db = getWritableDatabase();
        db.delete(TABLE_NAME, "id = " + id, null);
        db.close();
    }
}
