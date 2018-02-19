package ar.com.firstdata.creditcards.service.impl;

import ar.com.firstdata.creditcards.commons.exceptions.BalanceException;
import ar.com.firstdata.creditcards.commons.exceptions.FechaExpiracionException;
import ar.com.firstdata.creditcards.commons.exceptions.ImpresoraException;
import ar.com.firstdata.creditcards.commons.exceptions.InfoException;
import ar.com.firstdata.creditcards.commons.util.FechaFormatoTarjeta;
import ar.com.firstdata.creditcards.model.Marca;
import ar.com.firstdata.creditcards.model.Tarjeta;
import ar.com.firstdata.creditcards.service.TarjetaService;
import ar.com.firstdata.creditcards.service.TasaService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;

public class TarjetaServiceImpl implements TarjetaService {


    private TasaService tasaService = new TasaServiceImpl();

    private static final Logger logger = LogManager.getLogger(TarjetaServiceImpl.class);
    private final Random random = new Random();

    @Override
    public String imprimirDatosTarjeta(Tarjeta tarjeta) {
        if (tarjeta==null) return "";
        logger.info(tarjeta.toString());
        return tarjeta.toString();
    }

    private boolean generarException(){
        return random.nextInt(10)==5;
    }

    @Override
    public void imprimirFactura() throws ImpresoraException {
        if(generarException()){
            throw new ImpresoraException("Error en la Impresora");
        }

    }

    @Override
    public void enviarInfoTC() throws InfoException {
        if(generarException()){
            throw new InfoException("Error al enviar informacion de la Tarjeta de Credito");
        }
    }

    @Override
    public void informarPago() throws InfoException {
        if(generarException()){
            throw new InfoException("Error a informar pago de la Tarjeta de Credito");
        }
    }

    @Override
    public void actualizarSaldo() throws BalanceException {
        if(generarException()){
            throw new BalanceException("Error al actualizar saldo.");
        }
    }

    @Override
    public boolean consumir(Tarjeta tarjeta, double importe) {
        if (tarjeta == null || !tarjeta.esValida()) {
            logger.error("Tarjeta Nula o invalida.");
            return false;
        }

        if (importe <= 1000D) {
            try {
                imprimirFactura();
                enviarInfoTC();
                informarPago();
                actualizarSaldo();
                logger.info("Exito en operaciones -- Importe "+importe+" con la "+tarjeta.toString());
            } catch (ImpresoraException e) {
                logger.error(e.getMessage());
            } catch (InfoException e) {
                logger.error(e.getMessage());
            } catch (BalanceException e) {
                logger.error(e.getMessage());
            }
            return true;
        }else{
            logger.error("El importe debe ser menor que 1000$");
        }
        return false;
    }

    @Override
    public boolean validarTarjeta(Tarjeta tarjeta) {
        if(tarjeta==null) return false;
        String msg = "Tarjeta Invalida";
        if (tarjeta.esValida()){
            msg = "Tarjeta Valida";
        }
        logger.info(msg);
        return tarjeta.esValida();
    }

    @Override
    public boolean compararTarjetas(Tarjeta primeraTarjeta, Tarjeta segundaTarjeta) {
        if(primeraTarjeta==null || segundaTarjeta==null) {
            logger.error("Datos nulos, verifique e intente de nuevo");
            return false;
        }
        boolean iguales = primeraTarjeta.equals(segundaTarjeta);
        if(iguales){
            logger.info("Tarjetas iguales; Tarjeta: "+primeraTarjeta.getNumero()+" es igual a "+segundaTarjeta.getNumero());
        }else{
            logger.info("Tarjetas distintas Tarjeta :"+primeraTarjeta.getNumero()+" diferente a "+segundaTarjeta.getNumero());
        }
        return iguales;
    }

    @Override
    public Double getTasaOperacion(Marca marca, Double importe) {
        return tasaService.calcularTasa(marca,importe);
    }

    @Override
    public Tarjeta crearTarjeta(String numero, String cardHolder, Marca marca, String fechaExpiracion) throws FechaExpiracionException {

        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNumero(numero);
        tarjeta.setCardHoler(cardHolder);
        tarjeta.setMarca(marca);
        tarjeta.setFechaExpiracion(FechaFormatoTarjeta.crearFechaExpiracion(fechaExpiracion));

        logger.info("Tarjeta creada: "+tarjeta.toString());
        return tarjeta;
    }
}
