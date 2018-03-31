package com.example.megry.findsynonym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by megry on 3/31/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "synonym.db";
    private static final String TABLE_NAME = "synonyms";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_SYNONYM = "synonym";
    SQLiteDatabase db;
    public static final String TABLE_CREATE = "create table synonyms , " + "(word text not null, synonym text not null);";


    public DatabaseHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public void insertSynonym(Synonym synonyms) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORD, synonyms.getWord());
        values.put(COLUMN_SYNONYM, synonyms.getSynonym());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public String searchSynonym(String s) {

        db = this.getReadableDatabase();
        String query = "select word, synonym from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "Synonym Not Found";

        if(cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if(a.equals(s)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }


    }
