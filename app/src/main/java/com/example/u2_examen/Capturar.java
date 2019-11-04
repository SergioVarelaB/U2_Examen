package com.example.u2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Capturar extends AppCompatActivity {
    ImageView ivImagen;
    Intent intento;
    Button btn;
    int imagen = R.drawable.a2;
    public ArrayList<Restaurant_class> resta = new ArrayList<>();
    public Capturar(){
        resta.add(new Restaurant_class());
        resta.add(new Restaurant_class(R.drawable.a2, "on the Bridge", "cena bajo un puente", "Juan escutia, 5501232"));
        resta.add(new Restaurant_class(R.drawable.a3, "Sushi kito", "comida japonesa/peruana", "Periferico, 5501432"));
        resta.add(new Restaurant_class(R.drawable.a4, "El Hormigero", "coma como oso hormigero","Calle degollado, 5501232"));
        resta.add(new Restaurant_class(R.drawable.a5, "on the Bridge", "cena bajo un puente", "Calle 12, 5501232"));
        resta.add(new Restaurant_class(R.drawable.a1, "Sushi kito", "comida japonesa/peruana", "Calle Vicente Guerrero, 5501232"));
    }
    public ArrayList<Restaurant_class> getResta() {
        return resta;
    }

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        intento = new Intent(this,Seleccion.class);
        btn = findViewById(R.id.btnGuardar);
        ivImagen = findViewById(R.id.ivImagen);
        ivImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intento,SECOND_ACTIVITY_REQUEST_CODE);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarRestaurant(R.id.ivImagen,"juan","hola", "direccion y telefono");
                //Toast.makeText(getApplicationContext(),"" + imagen,Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");
                imagen = data.getIntExtra("imagen",R.drawable.a1);
                // Set text view with string
                ivImagen = findViewById(R.id.ivImagen);
                ivImagen.setImageResource(imagen);
            }
        }
    }
    public void agregarRestaurant(int imagen, String nombre, String descripcion, String dirYtel){
        resta.add(new Restaurant_class(imagen, nombre , descripcion, dirYtel));
        Toast.makeText(getApplicationContext(),resta+"",Toast.LENGTH_LONG).show();
    }

}