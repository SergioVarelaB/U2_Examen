package com.example.u2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Mostrar extends AppCompatActivity implements AdapterView.OnItemClickListener, Serializable {
    ListView listaRestaurantes;
    ArrayList<Restaurant_class> resta;

    Button Agregar;
    int imagen = R.drawable.a1;
    String nombre = "";
    String descripcion = "";
    String dirYtel = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        Intent intent = getIntent();
        loadData();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            imagen = bundle.getInt("imagen");
            nombre = bundle.getString("nombre");
            descripcion = bundle.getString("descripcion");
            dirYtel = bundle.getString("dirYtel");
            resta.add(new Restaurant_class(imagen,nombre,descripcion,dirYtel));
            savedData();
        }
        listaRestaurantes = findViewById(R.id.listaRestaurants);
        listaRestaurantes.setAdapter(new Restaurant_Adapter(this, R.layout.res_layout, resta));
        listaRestaurantes.setOnItemClickListener(this);
    }
    private void savedData(){
        SharedPreferences sp = getSharedPreferences("shared",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(resta);
        editor.putString("lista",json);
        editor.apply();
        //Toast.makeText(getApplicationContext(),"salvado por la campana",Toast.LENGTH_LONG).show();

    }
    private void loadData(){
        SharedPreferences sp = getSharedPreferences("shared",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString("lista",null);
        Type typ = new TypeToken<ArrayList<Restaurant_class>>(){}.getType();
        resta = gson.fromJson(json,typ);
        if (resta == null){
            resta = new ArrayList<>();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        finish();
    }
}
