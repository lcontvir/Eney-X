package es.eney_x.eney_x.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import es.eney_x.eney_x.R;

public class activity_inicio_eney extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_eney);

        Handler handler = new Handler();
        int delayMillis = 10000;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(activity_inicio_eney.this, activity_CheckIn.class);
                startActivity(intent);
                finish();
            }
        };

        handler.postDelayed(runnable, delayMillis);
    }
}