package es.eney_x.eney_x.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import es.eney_x.eney_x.R;

public class Activity_componente_unico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componente_unico);

        ImageButton backButton = findViewById(R.id.boton_atras);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define la nueva actividad que quieres abrir (activity_componente_main)
                Intent intent = new Intent(Activity_componente_unico.this, Activity_componente_main.class);

                // Inicia la nueva actividad y cierra la actual
                startActivity(intent);
                finish();
            }
        });
    }
}