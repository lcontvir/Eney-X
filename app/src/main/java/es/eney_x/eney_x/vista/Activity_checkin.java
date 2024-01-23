package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import es.eney_x.eney_x.R;

public class Activity_checkin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        ImageButton Ajustes = findViewById(R.id.botonAjustes);
        ImageButton Home = findViewById(R.id.botonCasa);
        ImageButton Seguridad = findViewById(R.id.botonEscudo);

        Ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el bot贸n, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_checkin.this, Activity_perfilUsuario.class);

                startActivity(intent);
                finish();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el bot贸n, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_checkin.this, Activity_componente_main.class);

                startActivity(intent);
                finish();
            }
        });

        Seguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el bot贸n, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_checkin.this, Activity_checkin.class);

                startActivity(intent);
                finish();
            }
        });
    }
}