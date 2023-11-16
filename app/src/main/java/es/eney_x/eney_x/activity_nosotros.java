package es.eney_x.eney_x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class activity_nosotros extends AppCompatActivity {
    ImageView casa, escudo, ajustes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);
    }
    private void cargaImagenes(){
        casa = (ImageView) findViewById(R.id.botonCasita);
        casa.setImageResource(R.drawable.casa);

        escudo = (ImageView) findViewById(R.id.escudo);
        escudo.setImageResource(R.drawable.escudo);

        ajustes = (ImageView) findViewById(R.id.ajustes);
        ajustes.setImageResource(R.drawable.ajustes);
    }

}