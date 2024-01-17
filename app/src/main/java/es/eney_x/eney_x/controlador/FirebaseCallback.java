package es.eney_x.eney_x.controlador;

import com.google.firebase.database.DataSnapshot;

public interface FirebaseCallback {
    void onCallback();
    void onFailure(Exception e);
}
