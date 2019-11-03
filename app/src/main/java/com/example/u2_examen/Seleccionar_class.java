package com.example.u2_examen;

public class Seleccionar_class {
    private int img;

        public Seleccionar_class(){
            img = R.drawable.a2;
        }
        public Seleccionar_class(int imagen) {
            this.img = imagen;
        }
        public int getImagen() {
            return img;
        }

        public void setImagen(int imagen) {
            this.img = imagen;
        }
}

