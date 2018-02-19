package ar.com.firstdata.creditcards.service.impl;

import ar.com.firstdata.creditcards.enums.TypeTasa;
import ar.com.firstdata.creditcards.model.Marca;
import ar.com.firstdata.creditcards.service.TasaService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDate;


public class TasaServiceImpl implements TasaService {

    private static final Logger logger = LogManager.getLogger(TasaServiceImpl.class);
    private static final double PORCENTAJE5 = 0.5;
    private static final double PORCENTAJE1 = 0.1;
    @Override
    public Double calcularTasa(Marca marca, Double importe){
        if(importe==null) return null;
        double tasa = 0;
        switch (marca.getTasa().getTipoTasa()) {
            case DiaMesPor05:
                tasa = diaMesPor05(importe);
                break;
            case MesPor01:
                tasa = mesPor01(importe);
                break;
            case AnioEntreMes:
                tasa = anioEntreMes(importe);
                break;
            default:
                break;
        }
        logger.info("Tasa: "+marca.getNombre());
        logger.info("Importe: $"+importe);
        logger.info("Cobro Tasa: $"+tasa);
        return tasa;
    }


    private double diaMesPor05(Double importe){
        double diaMes = LocalDate.now().getDayOfMonth();
        double tasa = diaMes * PORCENTAJE5;

        return importe * (validarTasaMaxima(tasa)/100);
    }
    private double mesPor01(Double importe){
        double diaMes = LocalDate.now().getDayOfMonth();
        double tasa = diaMes * PORCENTAJE1;

        return importe * (validarTasaMaxima(tasa)/100);
    }
    private double anioEntreMes(Double importe){
        double year = LocalDate.now().getYear();
        double month = LocalDate.now().getMonthValue();
        double tasa = year/month;

        return importe * (validarTasaMaxima(tasa)/100);
    }

    private double validarTasaMaxima(double tasa){
        if (tasa/100 > 5.0) {
            logger.info("Tasa seteada al maximo 5%");
            tasa = 5.0;
        }
        return tasa;
    }

}
