package ar.com.firstdata.creditcards.rest.entity;

public class ResponseTasa {

    private String marca;
    private Double importe;
    private Double tasa;

    public ResponseTasa(String marca) {
        this.marca = marca;
    }

    public ResponseTasa(String marca, Double importe, Double tasa) {
        this.marca = marca;
        this.importe = importe;
        this.tasa = tasa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }
}
