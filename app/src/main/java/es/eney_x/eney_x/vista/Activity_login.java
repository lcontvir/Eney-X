package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

public class Activity_login extends AppCompatActivity implements FirebaseCallback {

    protected Button go_to_register;
    protected Button login_user;
    protected EditText correo;
    protected EditText contraseña;
    protected TextView usuario_no_encontrado;

    /**
     * Método llamado cuando se crea la actividad.
     * Configura los elementos de la interfaz de usuario y establece los listeners necesarios.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        go_to_register = findViewById(R.id.BttonGoToRegistrarme);
        login_user = findViewById(R.id.BttonLogMeIn);

        correo = findViewById(R.id.EtMail);
        contraseña = findViewById(R.id.EtPassw);

        usuario_no_encontrado = findViewById(R.id.tv_usernotfound);
        usuario_no_encontrado.setVisibility(View.GONE);
        // Configuración del listener para quitar el "no encontrado"

        correo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //No hace falta implementarlo
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    usuario_no_encontrado.setVisibility(View.GONE);
                    login_user.setBackgroundColor(getResources().getColor(R.color.botonMorado, getTheme()));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //No hace falta implementarlo
            }
        });

        // Configuración del listener para el botón de ir a registrarse.
        go_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try {
                    intent = new Intent(Activity_login.this, Activity_register.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        // Configuración del listener para el botón de inicio de sesión.
        login_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario;
                try{
                    usuario = Usuario.getInstance();
                    usuario.setCorreo(correo.getText().toString());
                    usuario.setPassword(contraseña.getText().toString());
                    LoginUsuario();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Método que valida el formato del correo electrónico utilizando expresiones regulares.
     *
     * @param email El correo electrónico a validar.
     * @return true si el formato es válido, false de lo contrario.
     */
    public boolean ValidateEmail(String email) {
        final Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = null;
        Boolean result = false;
        try {
            matcher = pattern.matcher(email);
            result = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Método para llevar a cabo el inicio de sesión del usuario.
     * Se encarga de comprobar la existencia del usuario y realizar el inicio de sesión.
     */
    public void LoginUsuario() {
        try{
            AdminFirebase.ComprobarExistenciaUsuario(this);
            login_user.setText("Iniciando Sesion");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Implementación de métodos de la interfaz FirebaseCallback
    @Override
    public void onSucceed() {
        try{
            AdminFirebase.RecuperarUsuario(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFail(Exception e) {
        //No hace falta implementarlo
    }

    @Override
    public void onRecover() {
        Intent intent;
        try{
            intent = new Intent(Activity_login.this, Activity_checkin.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onNotFound() {
        try{
            usuario_no_encontrado.setVisibility(View.VISIBLE);
            login_user.setBackgroundColor(Color.rgb(217, 17, 37));
            login_user.setText("Iniciar Sesion");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRegister() {
        //No hace falta implementarlo
    }
}