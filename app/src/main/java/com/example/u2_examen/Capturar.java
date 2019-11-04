package com.example.u2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Capturar extends AppCompatActivity {
    EditText etName,etDescripcion, etDirYTel;
    ImageView ivImagen;
    Intent intento , inDatos;
    Button btn;
    int imagen = R.drawable.a2;
    int imagenMandar = 0;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        intento = new Intent(this,Seleccion.class);
        btn = findViewById(R.id.btnGuardar);
        ivImagen = findViewById(R.id.ivImagen);
        etName = findViewById(R.id.etNombre);
        etDescripcion = findViewById(R.id.etDescripcion);
        etDirYTel = findViewById(R.id.etDirYTel);
        inDatos = new Intent(getApplicationContext(),Mostrar.class);
        ivImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intento,SECOND_ACTIVITY_REQUEST_CODE);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString() != "" && etDescripcion.getText().toString() != "" && etDirYTel.getText().toString() != "" ){
                    agregarRestaurant();
                }else{
                    Toast.makeText(getApplicationContext(),"ingrese un dato",Toast.LENGTH_LONG).show();
                }
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
                switch(imagen){
                    case(R.drawable.a2):
                        imagenMandar = 1;
                        break;
                    case(R.drawable.a3):
                        imagenMandar = 2;
                        break;
                    case(R.drawable.a4):
                        imagenMandar = 3;
                        break;
                    default:
                        imagenMandar = 4;
                        break;
                }
                // Set text view with string
                ivImagen = findViewById(R.id.ivImagen);
                ivImagen.setImageResource(imagen);
            }
        }
    }
    public void agregarRestaurant(){
        Bundle bundle = new Bundle();
        bundle.putString("nombre",etName.getText().toString());
        bundle.putString("descripcion",etDescripcion.getText().toString());
        bundle.putString("dirYtel",etDirYTel.getText().toString());
        bundle.putInt("estrellas",3);
        bundle.putInt("imagen",imagenMandar);
        bundle.putInt("bandera",2);
        inDatos.putExtras(bundle);
        startActivity(inDatos);
    }

}