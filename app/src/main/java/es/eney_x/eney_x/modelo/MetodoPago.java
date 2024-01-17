package es.eney_x.eney_x.modelo;

public class MetodoPago {

    private String caducidad = "";
    private int csv = 000;
    private String nombre = "";
    private String tarjeta = "";

    public MetodoPago() {
    }

    public MetodoPago(String caducidad, int csv, String nombre, String tarjeta) {
        this.caducidad = caducidad;
        this.csv = csv;
        this.nombre = nombre;
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

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
}
