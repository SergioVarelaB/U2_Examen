package com.example.u2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Seleccion extends AppCompatActivity implements AdapterView.OnItemClickListener {
    int hola = 5;
    Seleccionar_class[] seleccionar = {
            new Seleccionar_class(),
            new Seleccionar_class(R.drawable.a3),
            new Seleccionar_class(R.drawable.a4),
            new Seleccionar_class(R.drawable.a5),
    };
    ListView listaImagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        listaImagenes = findViewById(R.id.listaImagenes2);
        listaImagenes.setAdapter(new Seleccionar_Adapter(this, R.layout.img_layout, seleccionar));
        listaImagenes.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, seleccionar[position].getImagen(), Toast.LENGTH_SHORT).show();
        int imagen = seleccionar[position].getImagen();
        Intent intent = new Intent();
        intent.putExtra("imagen", seleccionar[position].getImagen());
        setResult(RESULT_OK, intent);
        finish();
    }
}