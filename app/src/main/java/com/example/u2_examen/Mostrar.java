package com.example.u2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listaRestaurantes;
    private Capturar resta = new Capturar();
    ArrayList<Restaurant_class> rest = resta.getResta();
    Button Agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        /*ArrayList<Restaurant_class> rest = new ArrayList<>();
        rest.add(new Restaurant_class());*/
        listaRestaurantes = findViewById(R.id.listaRestaurants);
        listaRestaurantes.setAdapter(new Restaurant_Adapter(this, R.layout.res_layout, rest));
        listaRestaurantes.setOnItemClickListener(this);
        Agregar = findViewById(R.id.btnAgregar);
        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rest.add(new Restaurant_class(R.id.ivImagen,"juan","hola", "direccion y telefono"));
                Toast.makeText(getApplicationContext(),rest + "",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, restaurant[i].getNombre(), Toast.LENGTH_SHORT).show();
        /*String restaurant = restaurantes[i].getNombre() + "\n" + restaurantes[i].getDescripcion();
        int imagen = restaurantes[i].getImagen();
        Intent intent = new Intent();
        intent.putExtra("res", restaurant);
        intent.putExtra("ima", imagen);
        setResult(RESULT_OK, intent);*/
        finish();
    }

}
