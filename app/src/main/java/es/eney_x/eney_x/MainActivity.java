package es.eney_x.eney_x;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText etNombre, etCorreoRegistro, etCorreoInicioSesion;

    private Button btnRegistrarse, btnIniciarSesion;
    private Usuario user;

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

        user = Usuario.getInstance();
        etNombre = findViewById(R.id.etNombre);
        etCorreoRegistro = findViewById(R.id.etCorreoRegistro);
        etCorreoInicioSesion = findViewById(R.id.etCorreoInicioSesion);

        // Botón Registrarse
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setNombre(etNombre.getText().toString());
                user.setCorreo(etCorreoRegistro.getText().toString());
                RegistrarUsuario();
            }
        });

        // Botón Iniciar Sesión
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecuperarUsuario(etCorreoInicioSesion.getText().toString().substring(0, etCorreoInicioSesion.getText().toString().indexOf("@")));
            }
        });
    }

    public void RecuperarUsuario(String UID){
        DatabaseReference usuarioRef = FirebaseDatabase.getInstance().getReference(UID);
        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Usuario.setSingleton(dataSnapshot.getValue(Usuario.class));
                    LogIn();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("FirebaseError", "Error al obtener datos del usuario: " + databaseError.getMessage());
            }
        });
    }

    public void RegistrarUsuario(){
        DatabaseReference BBDD = FirebaseDatabase.getInstance().getReference();
        BBDD.child(Usuario.getInstance().getCorreo().substring(0, Usuario.getInstance().getCorreo().indexOf("@"))).setValue(Usuario.getInstance(), new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@NonNull DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.d("Firebase", "Conexión exitosa");
                    Toast.makeText(MainActivity.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Firebase", "Error al conectar a la base de datos: " + databaseError.getMessage());
                }
            }
        });
    }

    public void LogIn(){
        Intent intent = new Intent(this, activity_perfilUsuario.class);
        startActivity(intent);
    }
}
