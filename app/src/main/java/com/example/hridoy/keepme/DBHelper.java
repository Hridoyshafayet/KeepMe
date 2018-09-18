package com.example.hridoy.keepme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String databaseName = "notedb";
    private static final String tableName = "notetbl";
    private static final String idField = "id";
    private static final String titleField = "title";
    private static final String descriptionField = "description";


    public DBHelper(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+tableName+"( id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void insertData (String title, String description){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(titleField,title);
        cv.put(descriptionField,description);

        db.insert(tableName,null,cv);

    }

    public Cursor getData(){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM "+tableName,null);

        return result;

    }

}
