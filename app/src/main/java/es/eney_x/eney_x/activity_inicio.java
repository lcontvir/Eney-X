package es.eney_x.eney_x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class activity_inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);

        ImageView logoImageView = findViewById(R.id.logoeney);

        // Cargar la animación desde el archivo XML
        Animation slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.animacion_logo);

        // Aplicar la animación a la ImageView
        logoImageView.startAnimation(slideUpAnimation);


    }
}