package es.eney_x.eney_x;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_componente_unico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componente_unico);

        ImageButton backButton = findViewById(R.id.boton_atras);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define la nueva actividad que quieres abrir (activity_componente_main)
                Intent intent = new Intent(activity_componente_unico.this, activity_componente_main.class);

                // Inicia la nueva actividad y cierra la actual
                startActivity(intent);
                finish();
            }
        });
    }
}