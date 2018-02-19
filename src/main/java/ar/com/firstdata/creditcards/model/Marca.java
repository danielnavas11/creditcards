package ar.com.firstdata.creditcards.model;

import java.io.Serializable;

public class Marca implements Serializable {

    private String nombre;
    private Tasa tasa;

    public Marca() {
    }

    public Marca(String nombre, Tasa tasa) {
        this.nombre = nombre;
        this.tasa = tasa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tasa getTasa() {
        return tasa;
    }

    public void setTasa(Tasa tasa) {
        this.tasa = tasa;
    }
}
