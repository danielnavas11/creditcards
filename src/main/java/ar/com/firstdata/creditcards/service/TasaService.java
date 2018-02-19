package ar.com.firstdata.creditcards.service;

import ar.com.firstdata.creditcards.enums.TypeTasa;
import ar.com.firstdata.creditcards.model.Marca;

public interface TasaService {

    public Double calcularTasa(Marca marca, Double importe);


}
