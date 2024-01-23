package es.eney_x.eney_x.controlador;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import es.eney_x.eney_x.modelo.Usuario;

public class AdminFirebase {

    public static void RecuperarUsuario(final FirebaseCallback callback){
        DatabaseReference usuarioRef = FirebaseDatabase.getInstance().getReference(Usuario.getInstance().RecuperarIdentificador());
        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    Usuario.setSingleton(dataSnapshot.getValue(Usuario.class));
                    callback.onRecover();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("FirebaseError", "Error al obtener datos del usuario: " + databaseError.getMessage());
                callback.onFail(databaseError.toException());
            }
        });
    }

    public static void ActualizarUsuario(final FirebaseCallback callback){
        DatabaseReference usuarioRef = FirebaseDatabase.getInstance().getReference(Usuario.getInstance().RecuperarIdentificador());
        usuarioRef.setValue(Usuario.getInstance(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference ref) {
                if (databaseError != null) {
                    Log.e("Firebase", "Error al actualizar el registro: " + databaseError.getMessage());
                    callback.onFail(databaseError.toException());
                } else {
                    Log.d("Firebase", "Registro actualizado correctamente.");
                    callback.onSucceed();
                }
            }
        });
    }

    public static void AltaUsuario(final FirebaseCallback callback){
        DatabaseReference BBDD = FirebaseDatabase.getInstance().getReference();
        Usuario usuario = Usuario.getInstance();
        BBDD.child(usuario.RecuperarIdentificador()).setValue(usuario, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@NonNull DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.d("Firebase", "Usuario dado de alta");
                    callback.onRegister();
                } else {
                    Log.e("Firebase", "Error al conectar a la base de datos: " + databaseError.getMessage());
                    callback.onFail(databaseError.toException());
                }
            }
        });
    }

    public static void ComprobarExistenciaUsuario(final FirebaseCallback callback){
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(Usuario.getInstance().RecuperarIdentificador())){
                    callback.onSucceed();
                    Log.d("Firebase", "Identificador encontrado en la base de datos.");
                } else {
                   callback.onNotFound();
                    Log.d("Firebase", "Identificador no encontrado en la base de datos.");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Maneja el error si ocurre.
                Log.e("Firebase", "Error al leer datos: " + databaseError.getMessage());
                callback.onFail(databaseError.toException());
            }
        });
    }
}
