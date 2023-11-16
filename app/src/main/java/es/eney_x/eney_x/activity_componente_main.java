package es.eney_x.eney_x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class activity_componente_main extends AppCompatActivity {
    ImageView casa, escudo, ajustes, logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componente_main);

        cargaImagenes();

    }

    private void cargaImagenes(){
        casa = (ImageView) findViewById(R.id.botonCasita);
        casa.setImageResource(R.drawable.casa);

        escudo = (ImageView) findViewById(R.id.boton_escudo);
        escudo.setImageResource(R.drawable.escudo);

        logo = (ImageView) findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logoeneyx);

        ajustes = (ImageView) findViewById(R.id.ajustes);
        ajustes.setImageResource(R.drawable.ajustes);
/*
        casa = (ImageView) findViewById(R.id.botonCasita);
        casa.setImageResource(R.drawable.casa);


*/
    }
}