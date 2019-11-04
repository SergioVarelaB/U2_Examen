package com.example.u2_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Modifier;

import static java.lang.Integer.parseInt;

public class Estrellas extends AppCompatActivity {
    ImageView ivE;
    TextView nE,dE,dYT,tvCal;
    int imagen, estrellas, estrellasNuevo = 3, posicion;
    EditText edE;
    Button btnGuardar;
    String nombre, descripcion, dirYtel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estrellas);
        ivE = findViewById(R.id.ivE);
        nE = findViewById(R.id.nE);
        dE = findViewById(R.id.dE);
        edE = findViewById(R.id.etCal);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estrellasNuevo = Integer.parseInt(edE.getText().toString());
                try {
                if(edE.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"ingresa un dato",Toast.LENGTH_LONG).show();
                }
                if(estrellasNuevo >= 1 && estrellasNuevo <= 3){
                    modificar(estrellasNuevo);
                }else{
                    Toast.makeText(getApplicationContext(),"que del 1 al 3", Toast.LENGTH_LONG).show();
                }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"ingrese datos validos",Toast.LENGTH_SHORT).show();
                }


            }
        });
        dYT = findViewById(R.id.dYE);
        Intent intent = getIntent();
        //recibimos los datos del bundle
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            imagen = bundle.getInt("imagen");
            posicion = bundle.getInt("posicion");
            nombre = bundle.getString("nombre");
            descripcion = bundle.getString("descripcion");
            dirYtel = bundle.getString("dirYtel");
            estrellas = bundle.getInt("estrellas");
        }
        //seteamos la imagen y los valores que se nos mandaron
        switch(imagen){
            case(1):
                ivE.setImageResource(R.drawable.a2);
                break;
            case(2):
                ivE.setImageResource(R.drawable.a3);
                break;
            case(3):
                ivE.setImageResource(R.drawable.a4);
                break;
            case(4):
                ivE.setImageResource(R.drawable.a5);
                break;
            default:
                ivE.setImageResource(R.drawable.a1);
                break;
        }
        nE.setText("Nombre :" + nombre);
        dE.setText("Descripcion :" +descripcion);
        dYT.setText("Direccion y telefono :" +dirYtel);

    }

    public void modificar(int estrellas){
        Bundle bundle = new Bundle();
        Intent intentoD = new Intent(getApplicationContext(),Mostrar.class);
        bundle.putString("n",nombre);
        bundle.putString("d",descripcion);
        bundle.putString("dYt",dirYtel);
        bundle.putInt("img",imagen);
        bundle.putInt("est",estrellas);
        bundle.putInt("bandera",1);
        bundle.putInt("pos",posicion);
        intentoD.putExtras(bundle);
        startActivity(intentoD);
        finish();
    }
}
