package com.zeretto4210.mapexercisearica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    BDConnection data;
    RecyclerView list;
    ArrayList<Marker> markerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        data = new BDConnection(this, "systemBD", null, 1);
        list = (RecyclerView) findViewById(R.id.r_list);
        markerList = databaseToList();
        list.setLayoutManager(new LinearLayoutManager(this));
        Adapter me = new Adapter(markerList);
        list.setAdapter(me);
    }
    public void borrar(View view){
        SQLiteDatabase base = data.getWritableDatabase();
        base.delete("registro",null, null);
        finish();
        startActivity(getIntent());
    }
    public ArrayList<Marker> databaseToList(){
        ArrayList<Marker> tempList = new ArrayList<>();
        SQLiteDatabase base = data.getReadableDatabase();
        String[] columnas = {"id", "name","latitude","longitude"};
        Cursor c = base.query("registro", columnas, null, null, null, null, null);
        while(c.moveToNext()){
            Marker b = new Marker(c.getInt(0), c.getString(1),c.getDouble(2),c.getDouble(3));
            tempList.add(b);
        }
        return tempList;
    }
}