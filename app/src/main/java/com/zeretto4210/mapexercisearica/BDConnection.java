package com.zeretto4210.mapexercisearica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BDConnection extends SQLiteOpenHelper {
    private final String creationcode = "CREATE TABLE registro (id TEXT, name TEXT, latitude REAL, longitude REAL)";
    public BDConnection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creationcode);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS registro");
        onCreate(db);
    }
    //<editor-fold desc="Código de prueba, no lo borré porque lo wa a usar despues pa probar">
    /*
    public int getTableCount(String table){
        SQLiteDatabase dbcant = this.getReadableDatabase();
        return ((int) android.database.DatabaseUtils.queryNumEntries(dbcant,table));
    }

    public void deleteTable(String table){
        SQLiteDatabase base = this.getWritableDatabase();
        long result = base.delete(table,null, null);
    }

    //adaptar a lo que corresponda
    public void saveSomething(String table, String name, double latitude, double longitude){
        SQLiteDatabase base = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //usar combo valores.put para meter las cosas
        values.put("id",getTableCount(table)+1);
        values.put("name",name);
        values.put("latitude",latitude);
        values.put("longitude",longitude);

        long result = base.insert(table,"id",values);
    }
    public ArrayList<Marker> toList(String table){
        ArrayList<Marker> tempList = new ArrayList<>();
        SQLiteDatabase base = this.getReadableDatabase();

        String[] columnas = {"id", "name","latitude","longitude"};
        Cursor c = base.query(table, columnas, null, null, null, null, null);
        while(c.moveToNext()){
            Marker b = new Marker(c.getInt(0), c.getString(1),c.getDouble(2),c.getDouble(3));
            tempList.add(b);
        }
        return tempList;
    }*/
    //</editor-fold>

}
