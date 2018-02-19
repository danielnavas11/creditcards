package ar.com.firstdata.creditcards.model;

import ar.com.firstdata.creditcards.enums.TypeTasa;

import java.io.Serializable;

public class Tasa implements Serializable {


    public Tasa(TypeTasa tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    private TypeTasa tipoTasa;

    public TypeTasa getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(TypeTasa tipoTasa) {
        this.tipoTasa = tipoTasa;
    }
}
