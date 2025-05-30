package es.eney_x.eney_x;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class activity_perfilUsuario extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        ImageButton Ajustes = findViewById(R.id.botonAjustes);
        ImageButton Home = findViewById(R.id.botonCasa);
        ImageButton Seguridad = findViewById(R.id.botonEscudo);

        Button Facturacion = findViewById(R.id.BotonFacturacion);
        Button Licencias = findViewById(R.id.BotonLicencias);
        Button Privacidad = findViewById(R.id.BotonPrivacidad);
        Button Dispositivos = findViewById(R.id.BotonDispositivos);
        Button Informacion = findViewById(R.id.BotonInformacion);

        TextView Nombre = findViewById(R.id.Nombre);
        TextView Correo = findViewById(R.id.Dispositivo);

        Usuario usuario = Usuario.getInstance();

        Nombre.setText(usuario.getNombre());
        Correo.setText(usuario.getCorreo());

        Ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_perfilUsuario.class);

                startActivity(intent);
                finish();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_componente_main.class);

                startActivity(intent);
                finish();
            }
        });

        Seguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_CheckIn.class);

                startActivity(intent);
                finish();
            }
        });

        Licencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_Ajustes.class);

                startActivity(intent);
                finish();
            }
        });
        Facturacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_Ajustes.class);

                startActivity(intent);
                finish();
            }
        });

        Privacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_Ajustes.class);

                startActivity(intent);
                finish();
            }
        });

        Dispositivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_Ajustes.class);

                startActivity(intent);
                finish();
            }
        });

        Informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(activity_perfilUsuario.this, activity_SomosNosotros.class);

                startActivity(intent);
                finish();
            }
        });
    }
}
