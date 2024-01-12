package es.eney_x.eney_x;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminFirebase {

    public static boolean RecuperarUsuario(String UID){
        DatabaseReference usuarioRef = FirebaseDatabase.getInstance().getReference(UID);
        boolean recuperado = false;
        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    Usuario user = dataSnapshot.getValue(Usuario.class);
                    Log.d("Ejemplo", user.getApellidos());
                    Usuario.setSingleton(user);
                    Log.d("Ejemplo2", Usuario.getInstance().getApellidos());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("FirebaseError", "Error al obtener datos del usuario: " + databaseError.getMessage());
            }
        });
        if(Usuario.getInstance() != null){
            recuperado = true;
        }
        return recuperado;
    }

    public static boolean ActualizarUsuario(String UID){
        return false;
    }

    public static boolean AltaUsuario(String UID){
        return false;
    }

}
