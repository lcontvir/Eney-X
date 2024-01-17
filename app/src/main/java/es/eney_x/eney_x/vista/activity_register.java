package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.modelo.Usuario;

public class activity_register extends AppCompatActivity {

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
                Intent intent = new Intent(activity_register.this, activity_CheckIn.class);

                Usuario usuario = Usuario.getInstance();
                usuario.setCorreo(correo.getText().toString());
                usuario.setNombre(nombre.getText().toString());
                usuario.setFecha_nacimiento(fechaNacimiento.getText().toString());
                usuario.setNombre(nombre.getText().toString());
                usuario.setNombre(nombre.getText().toString());

                startActivity(intent);
                finish();

            }
        });
    }
}