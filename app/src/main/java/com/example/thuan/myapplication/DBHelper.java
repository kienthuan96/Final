package com.example.thuan.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by IT on 1/5/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_person";
    private static final int DB_VERSION = 1;

    private static final String TB_NAME = "tb_person";
    private static final String TB_COL_ID = "id";
    private static final String TB_COL_NAME = "ten";
    private static final String TB_COL_DIACHI = "diachi";
    private static final String TB_COL_TINHTRANG= "tinhtrang";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TB_NAME + "( " +
                TB_COL_NAME + " TEXT, " +
                TB_COL_DIACHI + " TEXT) "
        );
    }

    public void loadData(ArrayList<Bus> arrPersion){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TB_NAME,null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(TB_COL_NAME));
                String diachi = cursor.getString(cursor.getColumnIndex(TB_COL_DIACHI));
                arrPersion.add(new Bus(name,diachi));
            }while (cursor.moveToNext());
        }
        db.close();
    }

    public void saveData(ArrayList<Bus> personArrayList){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + TB_NAME);
        for (Bus nv : personArrayList){
            ContentValues values = new ContentValues();
            values.put(TB_COL_NAME,nv.getMaXe());
            values.put(TB_COL_DIACHI, nv.getTenXe());
            db.insert(TB_NAME,null,values);
        }
        db.close();
    }

    public void delete(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TB_NAME,TB_COL_ID + " =?",new String[]{id});
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TB_NAME);

        // Create tables again
        onCreate(sqLiteDatabase);
    }
}
