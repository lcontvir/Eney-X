package es.eney_x.eney_x.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import es.eney_x.eney_x.R;

public class activity_componente_main extends AppCompatActivity {

    ImageView casa, escudo, ajustes, logo;
    ConstraintLayout constraintLayoutPadre, constraintLayoutHijo;
    boolean isExpanded = false;
    TextView nombreVpn1, estadoVpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componente_main);

        setupExpandableLayout();

        Button button = findViewById(R.id.mas_info);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_componente_main.this, activity_componente_unico.class);
                startActivity(intent);
                finish();
            }
        });


        ImageButton ajustesButton = findViewById(R.id.botonAjustes);
        ajustesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_componente_main.this, activity_perfilUsuario.class);
                startActivity(intent);
                finish();
            }
        });


        ImageButton escudoButton = findViewById(R.id.botonEscudo);
        escudoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_componente_main.this, activity_CheckIn.class);
                startActivity(intent);
                finish();

            }
        });

        ImageButton casitaButton = findViewById(R.id.botonCasa);

        casitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_componente_main.this, activity_componente_main.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setupExpandableLayout() {
        constraintLayoutPadre = findViewById(R.id.constrainLayoutPadre);
        constraintLayoutHijo = findViewById(R.id.constraintLayoutHijo);
        constraintLayoutPadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isExpanded = !isExpanded;
                animateLayoutChanges(constraintLayoutHijo);
            }
        });
    }

    private void animateLayoutChanges(View expandableLayout) {
        if (isExpanded) {
            expandableLayout.setVisibility(View.VISIBLE);
        } else {
            expandableLayout.setVisibility(View.GONE);
        }
    }
}