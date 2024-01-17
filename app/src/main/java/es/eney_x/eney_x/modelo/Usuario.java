package es.eney_x.eney_x.modelo;

import java.util.ArrayList;

public class Usuario {

    private static Usuario singleton;
    private String avatar = "";
    private String correo = "";
    private ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
    private Facturacion facturacion;
    private String fecha_nacimiento = "";
    private ArrayList<Licencia> licencias = new ArrayList<Licencia>();
    private String nombre = "";
    private String apellidos = "";
    private String password = "";
    private Privacidad privacidad;

    private Usuario() {
    }

    public static synchronized Usuario getInstance(){
        if (singleton == null) {
            singleton = new Usuario();
        }
        return singleton;
    }

    public static void setSingleton(Usuario singleton) {
        Usuario.singleton = singleton;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public ArrayList<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(ArrayList<Licencia> licencias) {
        this.licencias = licencias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(Privacidad privacidad) {
        this.privacidad = privacidad;
    }
}
