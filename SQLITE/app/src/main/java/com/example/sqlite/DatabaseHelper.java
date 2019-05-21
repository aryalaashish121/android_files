package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="sampleDb";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME ="tbl_meaning";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_MEANING = "meaning";


    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_NAME+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                COLUMN_WORD+" TEXT,"+
                COLUMN_MEANING+" TEXT )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean saveDictionary(Dictionary dictionary,SQLiteDatabase db){
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WORD,dictionary.getWord());
        contentValues.put(COLUMN_MEANING,dictionary.getMeaning());

        id=db.insert(TABLE_NAME,null,contentValues);
        if(id>-1){
            Log.d("SQLITE","DATA SAVED SUCESSFULLY");
            return true;
        }
        Log.d("SQLITE","ERROR SAVING DATA");
        return false;
    }

    public List<Dictionary> getDictionary(SQLiteDatabase db){
        List<Dictionary> dictionaryList = new ArrayList<>();
        Cursor cursor = db.
                rawQuery("SELECT * FROM "+TABLE_NAME,null);
        cursor.move(-1);
        while (cursor.moveToNext()){
            dictionaryList.add(
                    new Dictionary(
                            (cursor.getString(cursor.getColumnIndex(COLUMN_WORD))),
                            (cursor.getString(cursor.getColumnIndex(COLUMN_MEANING)))
                    ));
        }
        return dictionaryList;
    }
}
