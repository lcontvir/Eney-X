package es.eney_x.eney_x;

public class Dispositivos {
    public String id_Dispositivo;
    public  boolean protegido;
    public String licencia;
    public String modelo;

    public Dispositivos(String id_Dispositivo, boolean protegido, String licencia, String modelo) {
        this.id_Dispositivo = id_Dispositivo;
        this.protegido = protegido;
        this.licencia = licencia;
        this.modelo = modelo;
    }

    public Dispositivos() {
    }

    public String getId_Dispositivo() {
        return id_Dispositivo;
    }

    public void setId_Dispositivo(String id_Dispositivo) {
        this.id_Dispositivo = id_Dispositivo;
    }

    public boolean isProtegido() {
        return protegido;
    }

    public void setProtegido(boolean protegido) {
        this.protegido = protegido;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
