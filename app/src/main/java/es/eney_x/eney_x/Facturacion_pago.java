package es.eney_x.eney_x;

public class Facturacion_pago {
    public String tarjeta;
    public String caducidad;
    public int csv;
    public String nombre;

    public Facturacion_pago() {
    }

    public Facturacion_pago(String tarjeta, String caducidad, int csv, String nombre) {
        this.tarjeta = tarjeta;
        this.caducidad = caducidad;
        this.csv = csv;
        this.nombre = nombre;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
