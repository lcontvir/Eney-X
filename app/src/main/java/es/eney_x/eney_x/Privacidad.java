package es.eney_x.eney_x;

public class Privacidad {
    private boolean ubicacion;
    private boolean notificaciones;
    private boolean galletasAnaliticas;
    private boolean galletasMarketing;

    public Privacidad(boolean ubicacion, boolean notificaciones, boolean galletasAnaliticas, boolean galletasMarketing) {
        this.ubicacion = ubicacion;
        this.notificaciones = notificaciones;
        this.galletasAnaliticas = galletasAnaliticas;
        this.galletasMarketing = galletasMarketing;
    }

    public Privacidad() {
    }

    public boolean isUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(boolean ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public boolean isGalletasAnaliticas() {
        return galletasAnaliticas;
    }

    public void setGalletasAnaliticas(boolean galletasAnaliticas) {
        this.galletasAnaliticas = galletasAnaliticas;
    }

    public boolean isGalletasMarketing() {
        return galletasMarketing;
    }

    public void setGalletasMarketing(boolean galletasMarketing) {
        this.galletasMarketing = galletasMarketing;
    }
}
