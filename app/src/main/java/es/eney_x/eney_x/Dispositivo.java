package es.eney_x.eney_x;

public class Dispositivo {
    private boolean activo = false;
    private String licencia = "";
    private String modelo = "";

    public Dispositivo() {
    }

    public Dispositivo(boolean activo, String licencia, String modelo) {
        this.activo = activo;
        this.licencia = licencia;
        this.modelo = modelo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
