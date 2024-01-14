package es.eney_x.eney_x;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminFirebase {

    public static void writeDataToFirebase() {
        // Puedes cambiar 'test' por el nombre de un nodo en tu base de datos
        FirebaseDatabase.getInstance().getReference().child("test").setValue("Hello, Firebase!", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@NonNull DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.d("Firebase", "Conexión exitosa");
                } else {
                    Log.e("Firebase", "Error al conectar a la base de datos: " + databaseError.getMessage());
                }
            }
        });
    }

    public static void RecuperarUsuario(String UID){
        DatabaseReference usuarioRef = FirebaseDatabase.getInstance().getReference(UID);
        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("Import", "entra");

                if (dataSnapshot.exists()) {

                    Usuario.setSingleton(dataSnapshot.getValue(Usuario.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("FirebaseError", "Error al obtener datos del usuario: " + databaseError.getMessage());
            }
        });
    }

    public static boolean ActualizarUsuario(String UID){
        return false;
    }

    public static boolean AltaUsuario(String UID){
        return false;
    }

}
