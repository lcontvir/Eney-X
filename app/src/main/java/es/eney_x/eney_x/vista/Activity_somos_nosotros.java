package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import es.eney_x.eney_x.R;

public class Activity_somos_nosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somos_nosotros);

        ImageButton volver = findViewById(R.id.IbVolver);
        ImageButton Ajustes = findViewById(R.id.botonAjustes);
        ImageButton Home = findViewById(R.id.botonCasa);
        ImageButton Seguridad = findViewById(R.id.botonEscudo);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior

                Intent intent = new Intent(Activity_somos_nosotros.this, Activity_perfilUsuario.class);

                startActivity(intent);
                finish();
                //finish() destruye una actividad y no podrás acceder a ella hasta que la vuelvas a crear.
            }


        });
        Ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_somos_nosotros.this, Activity_ajustes.class);

                startActivity(intent);
                finish();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_somos_nosotros.this, Activity_componente_main.class);

                startActivity(intent);
                finish();
            }
        });

        Seguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_somos_nosotros.this, Activity_checkin.class);

                startActivity(intent);
                finish();
            }
        });
    }
}