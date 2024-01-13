package es.eney_x.eney_x;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

 // Implementar esto a posteriori
    private void iniciarSesion(String correo, String contraseña) {
        mAuth.signInWithEmailAndPassword(correo, contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // El inicio de sesión fue exitoso
                            Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                            // Aquí puedes realizar acciones adicionales después del inicio de sesión
                        } else {
                            // Si el inicio de sesión falla, muestra un mensaje al usuario.
                            Toast.makeText(MainActivity.this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show();

                            // También puedes obtener información detallada sobre el error
                            Exception exception = task.getException();
                            if (exception != null) {
                                Log.e("FirebaseAuth", "Error: " + exception.getMessage());
                            }
                        }
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdminFirebase.writeDataToFirebase();
        AdminFirebase.RecuperarUsuario("palval");
        Usuario user = Usuario.getInstance();
        while (user.isSyncing()){

        }
        Log.d("Prueba", user.getCorreo());
    }
}
