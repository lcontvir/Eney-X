package es.eney_x.eney_x.modelo;

public class Privacidad {

    private boolean cookies_analiticas = false;
    private boolean cookies_marketing = false;
    private boolean notificaciones_publicidad = false;
    private boolean ubicacion = false;

    public Privacidad() {
    }

    public Privacidad(boolean cookies_analiticas, boolean cookies_marketing, boolean notificaciones_publicidad, boolean ubicacion) {
        this.cookies_analiticas = cookies_analiticas;
        this.cookies_marketing = cookies_marketing;
        this.notificaciones_publicidad = notificaciones_publicidad;
        this.ubicacion = ubicacion;
    }

    public boolean isCookies_analiticas() {
        return cookies_analiticas;
    }

    public void setCookies_analiticas(boolean cookies_analiticas) {
        this.cookies_analiticas = cookies_analiticas;
    }

    public boolean isCookies_marketing() {
        return cookies_marketing;
    }

    public void setCookies_marketing(boolean cookies_marketing) {
        this.cookies_marketing = cookies_marketing;
    }

    public boolean isNotificaciones_publicidad() {
        return notificaciones_publicidad;
    }

    public void setNotificaciones_publicidad(boolean notificaciones_publicidad) {
        this.notificaciones_publicidad = notificaciones_publicidad;
    }

    public boolean isUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(boolean ubicacion) {
        this.ubicacion = ubicacion;
    }
}
