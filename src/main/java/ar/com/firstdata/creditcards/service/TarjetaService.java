package ar.com.firstdata.creditcards.service;

import ar.com.firstdata.creditcards.commons.exceptions.BalanceException;
import ar.com.firstdata.creditcards.commons.exceptions.FechaExpiracionException;
import ar.com.firstdata.creditcards.commons.exceptions.ImpresoraException;
import ar.com.firstdata.creditcards.commons.exceptions.InfoException;
import ar.com.firstdata.creditcards.model.Marca;
import ar.com.firstdata.creditcards.model.Tarjeta;

public interface TarjetaService {

    public String imprimirDatosTarjeta(Tarjeta tarjeta);

    public void imprimirFactura() throws ImpresoraException;

    public void enviarInfoTC() throws InfoException;

    void informarPago() throws InfoException;

    void actualizarSaldo() throws BalanceException;

    public boolean consumir(Tarjeta tarjeta, double importe);

    public boolean validarTarjeta(Tarjeta tarjeta);

    public boolean compararTarjetas(Tarjeta primeraTarjeta, Tarjeta segundaTarjeta) ;

    public Double getTasaOperacion(Marca marca, Double importe);

    public Tarjeta crearTarjeta(String numero, String cardHolder, Marca marca, String fechaExpiracion) throws FechaExpiracionException;
}
