package ar.com.firstdata.creditcards;

import ar.com.firstdata.creditcards.commons.exceptions.FechaExpiracionException;
import ar.com.firstdata.creditcards.enums.TypeTasa;
import ar.com.firstdata.creditcards.model.Marca;
import ar.com.firstdata.creditcards.model.Tarjeta;
import ar.com.firstdata.creditcards.model.Tasa;
import ar.com.firstdata.creditcards.service.TarjetaService;
import ar.com.firstdata.creditcards.service.impl.TarjetaServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CreditCardsExecute {

    static TarjetaService service = new TarjetaServiceImpl();
    private static final Logger logger = LogManager.getLogger(CreditCardsExecute.class);

    public static void main(String[] args) {

        Marca squa = new Marca("SQUA", new Tasa(TypeTasa.AnioEntreMes));
        Marca sco = new Marca("SCO", new Tasa(TypeTasa.DiaMesPor05));
        Marca pere = new Marca("PERE", new Tasa(TypeTasa.MesPor01));

        Tarjeta SQUATarjeta = null;
        Tarjeta SCOTarjeta = null;
        Tarjeta PERETarjeta = null;
        logger.info("=================================================");
        try {
            SQUATarjeta = service.crearTarjeta("23123123123", "PRIMER NOMBRE PRIMER APELLIDO", squa, "01/19s");
        } catch (FechaExpiracionException e) {
            logger.error(e.getMessage());
        }
        logger.info("=================================================");
        try {
            SCOTarjeta = service.crearTarjeta("98765098744", "PRIMER NOMBRE PRIMER APELLIDO", sco, "10/18");
        } catch (FechaExpiracionException e) {
            logger.error(e.getMessage());
        }
        logger.info("=================================================");
        try {
            PERETarjeta = service.crearTarjeta("4435345345345", "PRIMER NOMBRE PRIMER APELLIDO", null, "10/20");
        } catch (FechaExpiracionException e) {
            logger.error(e.getMessage());
        }

        logger.info("=================================================");
        service.imprimirDatosTarjeta(SQUATarjeta);
        service.imprimirDatosTarjeta(SCOTarjeta);
        service.imprimirDatosTarjeta(PERETarjeta);
        logger.info("=================================================");
        service.validarTarjeta(SQUATarjeta);
        service.validarTarjeta(SCOTarjeta);
        service.validarTarjeta(PERETarjeta);
        logger.info("=================================================");
        service.compararTarjetas(SQUATarjeta,SQUATarjeta);
        service.compararTarjetas(SQUATarjeta,SCOTarjeta);
        service.compararTarjetas(SQUATarjeta,PERETarjeta);
        logger.info("=================================================");
        service.compararTarjetas(SCOTarjeta,SCOTarjeta);
        service.compararTarjetas(SCOTarjeta,SQUATarjeta);
        service.compararTarjetas(SCOTarjeta,PERETarjeta);
        logger.info("=================================================");
        service.compararTarjetas(PERETarjeta,PERETarjeta);
        service.compararTarjetas(PERETarjeta,SCOTarjeta);
        service.compararTarjetas(PERETarjeta,SQUATarjeta);
        logger.info("=================================================");
        service.consumir(SQUATarjeta, 500D);
        service.consumir(SQUATarjeta, 12000D);
        logger.info("=================================================");
        service.consumir(SCOTarjeta, 400D);
        service.consumir(SCOTarjeta, 1000D);
        logger.info("=================================================");
        service.consumir(PERETarjeta, 400D);
        service.consumir(PERETarjeta, 1000D);
        logger.info("=================================================");
        service.getTasaOperacion(squa, 100D);
        logger.info("=================================================");
        service.getTasaOperacion(sco, 5000D);
        logger.info("=================================================");
        service.getTasaOperacion(pere, 1000D);
        logger.info("=================================================");
    }
}
