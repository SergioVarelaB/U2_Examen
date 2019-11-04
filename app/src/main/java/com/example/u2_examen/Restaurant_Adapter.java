package com.example.u2_examen;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        int imagen  =  R.drawable.a1;

        if(convertView == null){
            //Crear nuestro layout que representa una fila en la lista
            //INFLATER
            LayoutInflater lInflator = ((Activity) context).getLayoutInflater();
            convertView = lInflator.inflate(resource, parent, false);
        }
        imageView = convertView.findViewById(R.id.ivResLay);
        txtNombre = convertView.findViewById(R.id.txt_nombre);
        txtDesc = convertView.findViewById(R.id.txt_descripcion);
        estrellas = convertView.findViewById(R.id.tvEst);
        textDirYTel = convertView.findViewById(R.id.txt_dirYtel);
        //estrellas = convertView.findViewById(R.id.txt_dirYtel);
        imagen = restaurantes[position].getImagen();
        //Toast.makeText(getContext(),restaurantes[position].getImagen()+"",Toast.LENGTH_LONG).show();
        switch (imagen){
            case(0):
                imageView.setImageResource(R.drawable.a1);
                break;
            case(1):
                imageView.setImageResource(R.drawable.a2);
                break;
            case(2):
                imageView.setImageResource(R.drawable.a3);
                break;
            case(3):
                imageView.setImageResource(R.drawable.a4);
                break;
            default:
                imageView.setImageResource(R.drawable.a5);
                break;
        }
        txtNombre.setText(restaurantes[position].getNombre());
        txtDesc.setText(restaurantes[position].getDescripcion());
        textDirYTel.setText(restaurantes[position].getDirYTel());
        estrellas.setText(restaurantes[position].getEstrellas()+"");
        //Toast.makeText(getContext(),restaurantes[position].getEstrellas()+"",Toast.LENGTH_LONG).show();

        return convertView;
    }
}