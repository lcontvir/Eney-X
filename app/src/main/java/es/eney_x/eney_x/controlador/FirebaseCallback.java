package es.eney_x.eney_x.controlador;

public interface FirebaseCallback {
    void onSucceed();
    void onFail(Exception e);
    void onRecover();
    void onNotFound();
    void onRegister();
}
