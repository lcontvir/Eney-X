package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.modelo.Usuario;

public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button go_to_register = findViewById(R.id.BttonRegistrarme);
        Button go_to_mainplace = findViewById(R.id.BttonRegister);

        EditText correo = findViewById(R.id.EtMail);

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
                Intent intent = new Intent(activity_login.this, activity_CheckIn.class);

                Usuario usuario = Usuario.getInstance();
                usuario.setCorreo(correo.getText().toString());
                usuario.setNombre("Martin Buda Cristo");

                startActivity(intent);
                finish();

            }
        });
    }
}