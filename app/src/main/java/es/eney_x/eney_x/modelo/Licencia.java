package es.eney_x.eney_x.modelo;

public class Licencia {

    private String caducidad = "";
    private String clave_licencia = "";
    private int dispositivos_maximos = 12;
    private int tipo_licencia = 0;

    public Licencia() {
    }

    public Licencia(String caducidad, String clave_licencia, int dispositivos_maximos, int tipo_licencia) {
        this.caducidad = caducidad;
        this.clave_licencia = clave_licencia;
        this.dispositivos_maximos = dispositivos_maximos;
        this.tipo_licencia = tipo_licencia;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public String getClave_licencia() {
        return clave_licencia;
    }

    public void setClave_licencia(String clave_licencia) {
        this.clave_licencia = clave_licencia;
    }

    public int getDispositivos_maximos() {
        return dispositivos_maximos;
    }

    public void setDispositivos_maximos(int dispositivos_maximos) {
        this.dispositivos_maximos = dispositivos_maximos;
    }

    public int getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(int tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }
}
