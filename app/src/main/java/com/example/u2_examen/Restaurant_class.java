package com.example.u2_examen;

public class Restaurant_class{
    private int imagen;
    private String nombre;
    private String descripcion;
    private String DirYTel;

    public Restaurant_class(){
        imagen = R.drawable.a1;
        nombre = "Golden bridge";
        descripcion = "El infierno";
        DirYTel = "Simon Bolivar, 5501010";
    }
    public Restaurant_class(int imagen, String nombre, String descripcion, String dirYTel) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.DirYTel = dirYTel;
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
        return DirYTel;
    }

    public void setDirYTel(String dirYTel) {
        DirYTel = dirYTel;
    }
}

