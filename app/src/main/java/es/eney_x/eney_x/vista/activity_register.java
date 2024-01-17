package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.controlador.AdminFirebase;
import es.eney_x.eney_x.controlador.FirebaseCallback;
import es.eney_x.eney_x.modelo.Usuario;

public class activity_register extends AppCompatActivity implements FirebaseCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button go_to_login = findViewById(R.id.BttonIniciarSesion);
        Button go_to_mainplace = findViewById(R.id.BttonRegister);

        EditText nombre = findViewById(R.id.EtNombre);
        EditText apellidos = findViewById(R.id.EtApellidos);
        EditText correo = findViewById(R.id.EtMail);
        EditText fechaNacimiento = findViewById(R.id.EtNacimiento);
        EditText contrasena = findViewById(R.id.EtPassw);

        go_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this, activity_login.class);
                startActivity(intent);
                finish();

            }
        });
        go_to_mainplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = Usuario.getInstance();
                usuario.setCorreo(correo.getText().toString());
                usuario.setNombre(nombre.getText().toString());
                usuario.setApellidos(apellidos.getText().toString());
                usuario.setFecha_nacimiento(fechaNacimiento.getText().toString());
                usuario.setPassword(contrasena.getText().toString());
                RegistrarUsuario();
            }
        });
    }

    public void RegistrarUsuario(){
        AdminFirebase.ComprobarExistenciaUsuario(this);
    }

    @Override
    public void onSucceed() {
        //Ya hay un usuario en la BBDD!! Quizas un Toast??
    }

    @Override
    public void onFail(Exception e) {
        //No hace falta implementarlo
    }

    @Override
    public void onRecover() {
        //No hace falta implementarlo
    }

    @Override
    public void onNotFound() {
        AdminFirebase.AltaUsuario(this);
    }

    @Override
    public void onRegister() {
        Intent intent = new Intent(activity_register.this, activity_CheckIn.class);
        startActivity(intent);
        finish();
    }
}