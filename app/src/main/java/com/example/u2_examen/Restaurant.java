package com.example.u2_examen;

import java.util.ArrayList;
public class Restaurant extends ArrayList {
    public ArrayList<Restaurant_class> resta = new ArrayList<>();
    public Restaurant(){
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
    public ArrayList agregarRestaurant(int imagen, String nombre, String descripcion, String dirYtel){
        resta.add(new Restaurant_class(imagen, nombre , descripcion, dirYtel));
        return resta;
    }
}