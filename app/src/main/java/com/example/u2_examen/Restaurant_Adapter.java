package com.example.u2_examen;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Restaurant_Adapter extends ArrayAdapter<Restaurant_class> {
    Context context;
    int resource;
    Restaurant_class[] restaurantes;
    public Restaurant_Adapter(Context context, int resource, ArrayList<Restaurant_class> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.restaurantes = objects.toArray(new Restaurant_class[0]);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView txtNombre, txtDesc, textDirYTel, estrellas;

        if(convertView == null){
            //Crear nuestro layout que representa una fila en la lista
            //INFLATER
            LayoutInflater lInflator = ((Activity) context).getLayoutInflater();
            convertView = lInflator.inflate(resource, parent, false);
        }

        imageView = convertView.findViewById(R.id.ivResLay);
        txtNombre = convertView.findViewById(R.id.txt_nombre);
        txtDesc = convertView.findViewById(R.id.txt_descripcion);
        textDirYTel = convertView.findViewById(R.id.txt_dirYtel);
        estrellas = convertView.findViewById(R.id.txt_dirYtel);

        imageView.setImageResource(restaurantes[position].getImagen());
        txtNombre.setText(restaurantes[position].getNombre());
        txtDesc.setText(restaurantes[position].getDescripcion());
        textDirYTel.setText(restaurantes[position].getDirYTel());

        return convertView;
    }
}