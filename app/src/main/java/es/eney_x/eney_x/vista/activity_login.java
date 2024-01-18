package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        TextView usuario_no_encontrado = findViewById(R.id.tv_usernotfound);
        usuario_no_encontrado.setVisibility(View.GONE);

        correo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView usuario_no_encontrado = findViewById(R.id.tv_usernotfound);
                usuario_no_encontrado.setVisibility(View.GONE);
                Button go_to_mainplace = findViewById(R.id.BttonRegister);
                go_to_mainplace.setBackgroundColor(getResources().getColor(R.color.botonMorado, getTheme()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


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

    public boolean ValidateEmail(String email){
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void LoginUsuario(){
        AdminFirebase.ComprobarExistenciaUsuario(this);
        Button go_to_mainplace = findViewById(R.id.BttonRegister);
        go_to_mainplace.setText("Iniciando Sesion");

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
        TextView usuario_no_encontrado = findViewById(R.id.tv_usernotfound);
        usuario_no_encontrado.setVisibility(View.VISIBLE);
        Button go_to_mainplace = findViewById(R.id.BttonRegister);
        go_to_mainplace.setBackgroundColor(Color.rgb(217, 17, 37));
        go_to_mainplace.setText("Iniciar Sesion");
    }

    @Override
    public void onRegister() {

    }
}