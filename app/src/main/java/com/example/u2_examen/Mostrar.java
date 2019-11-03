package com.example.u2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Mostrar extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Restaurant_class[] restaurantes = {
            new Restaurant_class(),
            new Restaurant_class(R.drawable.a2, "on the Bridge", "cena bajo un puente", "Juan escutia, 5501232"),
            new Restaurant_class(R.drawable.a3, "Sushi kito", "comida japonesa/peruana", "Periferico, 5501432"),
            new Restaurant_class(R.drawable.a4, "El Hormigero", "coma como oso hormigero","Calle degollado, 5501232"),
            new Restaurant_class(R.drawable.a5, "on the Bridge", "cena bajo un puente", "Calle 12, 5501232"),
            new Restaurant_class(R.drawable.a1, "Sushi kito", "comida japonesa/peruana", "Calle Vicente Guerrero, 5501232"),
    };

    ListView listaRestaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        listaRestaurantes = findViewById(R.id.listaRestaurants);
        listaRestaurantes.setAdapter(new Restaurant_Adapter(this, R.layout.res_layout, restaurantes));
        listaRestaurantes.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, restaurantes[i].getNombre(), Toast.LENGTH_SHORT).show();
        /*String restaurant = restaurantes[i].getNombre() + "\n" + restaurantes[i].getDescripcion();
        int imagen = restaurantes[i].getImagen();
        Intent intent = new Intent();
        intent.putExtra("res", restaurant);
        intent.putExtra("ima", imagen);
        setResult(RESULT_OK, intent);*/
        finish();
    }

}
