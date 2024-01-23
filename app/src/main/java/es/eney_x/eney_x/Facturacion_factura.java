package es.eney_x.eney_x;

public class Facturacion_factura {
    private String idFactura;
    private String ArchivosFactura;

    public Facturacion_factura() {
    }

    public Facturacion_factura(String idFactura, String archivosFactura) {
        this.idFactura = idFactura;
        ArchivosFactura = archivosFactura;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getArchivosFactura() {
        return ArchivosFactura;
    }

    public void setArchivosFactura(String archivosFactura) {
        ArchivosFactura = archivosFactura;
    }



}
