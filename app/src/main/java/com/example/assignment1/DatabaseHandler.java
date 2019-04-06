package com.example.assignment1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.assignment1.Models.ListItem;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "listItems";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ITEM_NAME = "_name";
    public static final String COLUMN_DESCRIPTION = "_desc";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "listItems.db";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE listItems(_id INTEGER PRIMARY KEY AUTOINCREMENT,_name TEXT,_desc TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addListItem(ListItem myItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ITEM_NAME, myItem.getName());
        contentValues.put(COLUMN_DESCRIPTION, myItem.getDesc());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public Cursor getMyItem() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);
    }


}
