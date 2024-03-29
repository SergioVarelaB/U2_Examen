package com.example.u2_examen;

public class Restaurant_class{
    private int imagen;
    private String nombre;
    private String descripcion;
    private String dirYTel;
    private int estrellas;

    public Restaurant_class(){
        imagen = R.drawable.a2;
        nombre = "Golden bridge";
        descripcion = "El infierno";
        dirYTel = "Calle Degollado, 5750229";
        estrellas = 3;
    }

    public Restaurant_class(int imagen, String nombre, String descripcion, String dirYTel, int estrellas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dirYTel = dirYTel;
        this.estrellas = estrellas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirYTel() {
        return dirYTel;
    }

    public void setDirYTel(String dirYTel) {
        dirYTel = dirYTel;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
}

