package es.eney_x.eney_x;

public class Usuario {

    private static Usuario singleton; //Jaja, Explicar luego esto va a ser una bomba, son las 2:31 am

    private String Nombre = "";
    private String Correo = "";

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
}
