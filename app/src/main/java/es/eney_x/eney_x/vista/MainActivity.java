package es.eney_x.eney_x.vista;

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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import es.eney_x.eney_x.controlador.AdminFirebase;
import es.eney_x.eney_x.controlador.FirebaseCallback;
import es.eney_x.eney_x.R;
import es.eney_x.eney_x.modelo.Usuario;

public class MainActivity extends AppCompatActivity implements FirebaseCallback {

    private EditText etNombre, etCorreoRegistro, etCorreoInicioSesion;

    private Button btnRegistrarse, btnIniciarSesion;
    private Usuario user;

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
                user.setNombre(etNombre.getText().toString());
                user.setCorreo(etCorreoRegistro.getText().toString());
                RecuperarUsuario();
            }
        });
    }

    public void RecuperarUsuario(){
        AdminFirebase.RecuperarUsuario(this);
    }

    public void RegistrarUsuario(){
        AdminFirebase.ComprobarExistenciaUsuario(this);
        AdminFirebase.AltaUsuario(this);
    }

    public void LogIn(){
        Intent intent = new Intent(this, activity_perfilUsuario.class);
        startActivity(intent);
    }

    @Override
    public void onSucceed() {
        LogIn();
    }

    @Override
    public void onFail(Exception e) {

    }

    @Override
    public void onRecover() {

    }

    @Override
    public void onNotFound() {

    }

    @Override
    public void onRegister() {

    }
}
