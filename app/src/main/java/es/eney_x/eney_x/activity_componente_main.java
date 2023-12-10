package es.eney_x.eney_x;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class activity_componente_main extends AppCompatActivity {

    ImageView casa, escudo, ajustes, logo;
    ConstraintLayout expandableLayout, constraintLayout;
    boolean isExpanded = false;
    TextView nombreVpn1, estadoVpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componente_main);

        cargaImagenes();
        setupExpandableLayout();


        Button button = findViewById(R.id.mas_info);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_componente_main.this, activity_componente_unico.class);
                startActivity(intent);
            }
        });


        ImageButton ajustesButton = findViewById(R.id.ajustes);


        ajustesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_componente_main.this, activity_Ajustes.class);

                startActivity(intent);
            }
        });


        ImageButton escudoButton = findViewById(R.id.boton_escudo);


        escudoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_componente_main.this, activity_CheckIn.class);


                startActivity(intent);
            }
        });

        ImageButton casitaButton = findViewById(R.id.botonCasita);

        casitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_componente_main.this, activity_componente_main.class);
                startActivity(intent);
            }
        });
    }

    private void cargaImagenes() {
        casa = findViewById(R.id.botonCasita);
        casa.setImageResource(R.drawable.casa);

        escudo = findViewById(R.id.boton_escudo);
        escudo.setImageResource(R.drawable.escudo);

        logo = findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logoeneyx);

        ajustes = findViewById(R.id.ajustes);
        ajustes.setImageResource(R.drawable.ajustes);


        nombreVpn1 = findViewById(R.id.nombreVpn1);
        estadoVpn = findViewById(R.id.estadoVpn);


        constraintLayout = findViewById(R.id.constraintLayout_vpn);
    }

    private void setupExpandableLayout() {
        expandableLayout = findViewById(R.id.expandableLayout);

        expandableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isExpanded = !isExpanded;

                animateLayoutChanges(expandableLayout);
            }
        });
    }

    private void animateLayoutChanges(View expandableLayout) {
        // Muestra u oculta la información dependiendo del estado de isExpanded
        if (isExpanded) {
            // Muestra el constraintLayout interno
            constraintLayout.setVisibility(View.VISIBLE);
        } else {
            // Oculta el constraintLayout interno
            constraintLayout.setVisibility(View.GONE);
        }
    }
}