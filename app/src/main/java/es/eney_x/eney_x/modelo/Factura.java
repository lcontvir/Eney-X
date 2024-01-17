package es.eney_x.eney_x.modelo;

public class Factura {

    private String ubicacion_factura = "";

    public Factura() {
    }

    public Factura(String ubicacion_factura) {
        this.ubicacion_factura = ubicacion_factura;
    }

    public String getUbicacion_factura() {
        return ubicacion_factura;
    }

    public void setUbicacion_factura(String ubicacion_factura) {
        this.ubicacion_factura = ubicacion_factura;
    }
}
