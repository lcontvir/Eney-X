package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.Firebase;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.controlador.AdminFirebase;
import es.eney_x.eney_x.controlador.FirebaseCallback;
import es.eney_x.eney_x.modelo.Usuario;

public class activity_login extends AppCompatActivity implements FirebaseCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button go_to_register = findViewById(R.id.BttonRegistrarme);
        Button go_to_mainplace = findViewById(R.id.BttonRegister);

        EditText correo = findViewById(R.id.EtMail);
        EditText contraseña = findViewById(R.id.EtPassw);

        go_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_register.class);
                startActivity(intent);
                finish();

            }
        });
        go_to_mainplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = Usuario.getInstance();
                usuario.setCorreo(correo.getText().toString());
                usuario.setPassword(contraseña.getText().toString());
                LoginUsuario();
            }
        });
    }

    public void LoginUsuario(){
        AdminFirebase.ComprobarExistenciaUsuario(this);
    }

    @Override
    public void onSucceed() {
        AdminFirebase.RecuperarUsuario(this);
    }

    @Override
    public void onFail(Exception e) {
        //No hace falta implementarlo
    }

    @Override
    public void onRecover() {
        Intent intent = new Intent(activity_login.this, activity_CheckIn.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onNotFound() {
        //No hay un usuario en la BBDD!! Quizas un Toast??
    }

    @Override
    public void onRegister() {

    }
}