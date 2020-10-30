package com.zeretto4210.mapexercisearica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView nombre, latitud, longitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (TextView) findViewById(R.id.i_nombre);
        latitud = (TextView) findViewById(R.id.i_latitud);
        longitud = (TextView) findViewById(R.id.i_longitud);
    }
    public void clickear(View view){
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("save",true);
        i.putExtra("nom",nombre.getText()+"");
        i.putExtra("lat",Double.parseDouble(latitud.getText()+""));
        i.putExtra("long",Double.parseDouble(longitud.getText()+""));
        startActivity(i);
    }
    public void listar(View view){
        Intent i = new Intent(getApplicationContext(), History.class);
        startActivity(i);
    }
}