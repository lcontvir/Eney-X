package es.eney_x.eney_x.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent = new Intent(this, Activity_perfilUsuario.class);
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
