package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import es.eney_x.eney_x.R;

public class activity_Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        // Obtén la referencia al botón VueltaAtras
        ImageButton vueltaAtrasButton = findViewById(R.id.VueltaAtras);


        vueltaAtrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_Ajustes.this, activity_perfilUsuario.class);
                startActivity(intent);
                finish();
            }
        });
    }

}