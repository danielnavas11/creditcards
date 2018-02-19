package ar.com.firstdata.creditcards.commons.util;

import ar.com.firstdata.creditcards.commons.exceptions.FechaExpiracionException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaFormatoTarjeta {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");

    public static LocalDate crearFechaExpiracion(String fecha) throws FechaExpiracionException {
        if(validateCardExpiryDate(fecha)) {
            return LocalDate.parse("01/"+fecha, FORMATTER);
        }else{
            throw new FechaExpiracionException("Fecha de Expiracion invalida ("+fecha+")");
        }

    }

    public static boolean validateCardExpiryDate(String fecha) {
        return fecha.matches("(?:0[1-9]|1[0-2])/[0-9]{2}");
    }
}
