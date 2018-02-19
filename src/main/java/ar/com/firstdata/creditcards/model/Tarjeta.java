package ar.com.firstdata.creditcards.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Tarjeta implements Serializable{

    private String numero;
    private String cardHoler;
    private Marca marca;
    private LocalDate fechaExpiracion;


    public boolean esValida() {
        return LocalDate.now().isBefore(getFechaExpiracion());
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCardHoler() {
        return cardHoler;
    }

    public void setCardHoler(String cardHoler) {
        this.cardHoler = cardHoler;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public LocalDate getFechaExpiracion() {
        return this.fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.getNumero())
                .append(this.getCardHoler())
                .append(this.getMarca())
                .append(this.getFechaExpiracion())
                .toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) o;
        return new EqualsBuilder()
                .append(this.getNumero(), other.getNumero())
                .append(this.getCardHoler(), other.getCardHoler())
                .append(this.getMarca(), other.getMarca())
                .append(this.getFechaExpiracion(), other.getFechaExpiracion())
                .isEquals();
    }

    @Override
    public String toString() {
        return "Tarjeta {" +
                "numero='" + getNumero() + '\'' +
                ", cardHoler='" + getCardHoler() + '\'' +
                ", marca=" + ((getMarca()!=null)?getMarca().getNombre():"S/M") +
                ", fechaExpiracion=" + getFechaExpiracion().format(DateTimeFormatter.ofPattern("MM/yy")) +
                '}';
    }

}
