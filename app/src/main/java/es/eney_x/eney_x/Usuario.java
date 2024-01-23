package es.eney_x.eney_x;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private static Usuario singleton; //Jaja, Explicar luego esto va a ser una bomba, son las 2:31 am

    private String Nombre = "";
    private String Correo = "";
    private List<Licencias> licenciasList = new ArrayList<>();
    private Usuario() {
    }

    public static synchronized Usuario getInstance(){
        if (singleton == null) {
            singleton = new Usuario();
        }
        return singleton;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
    public List<Licencias> getLicenciasList() {
        return licenciasList;
    }

    public void setLicenciasList(List<Licencias> licenciasList) {
        this.licenciasList = licenciasList;
    }
}
