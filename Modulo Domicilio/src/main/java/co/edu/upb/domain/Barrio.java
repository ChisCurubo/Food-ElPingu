package co.edu.upb.domain;

import java.io.Serializable;

public class Barrio implements Serializable {
    private String nombre;
    private int ubicacion;

    public Barrio(String nombre, int ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    public Barrio(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
}
