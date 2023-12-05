package es.eney_x.eney_x;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        // Encuentra las vistas dentro del expandableLayout
        nombreVpn1 = findViewById(R.id.nombreVpn1);
        estadoVpn = findViewById(R.id.estadoVpn);

        // Encuentra el constraintLayout interno
        constraintLayout = findViewById(R.id.constraintLayout_vpn);
    }

    private void setupExpandableLayout() {
        expandableLayout = findViewById(R.id.expandableLayout);

        expandableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Invierte el estado de isExpanded
                isExpanded = !isExpanded;
                // Llama a la función para animar los cambios en el diseño
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