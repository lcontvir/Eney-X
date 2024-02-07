package es.eney_x.eney_x.vista;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.modelo.Activity_datos;
import es.eney_x.eney_x.modelo.Usuario;
import es.eney_x.eney_x.modelo.Activity_datosFacturacion;

public class Activity_perfilUsuario extends AppCompatActivity{

    int indiceActual = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        int[] imagenes ={R.drawable.penguin, R.drawable.robot, R.drawable.wolf};



        ShapeableImageView imageButton = findViewById(R.id.PerfilUsuario);
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
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indiceActual = (indiceActual + 1) % imagenes.length;
                imageButton.setImageResource(imagenes[indiceActual]);
            }
        });
        Ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_perfilUsuario.class);

                startActivity(intent);
                finish();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_componente_main.class);

                startActivity(intent);
                finish();
            }
        });

        Seguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_checkin.class);

                startActivity(intent);
                finish();
            }
        });

        Licencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_datos.class);
                // Pasa el texto como extra
                intent.putExtra("textolicencia", "      Licencias  ");
                startActivity(intent);
                finish();
            }
        });
        Facturacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_datosFacturacion.class);

                startActivity(intent);
                finish();
            }
        });

        Privacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_datos.class);

                // Pasa el texto como extra
                intent.putExtra("textolicencia", "      Privacidad  ");
                startActivity(intent);
                finish();
            }
        });

        Dispositivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_datos.class);

                // Pasa el texto como extra
                intent.putExtra("textolicencia", "     Dispositivos  ");
                startActivity(intent);
                finish();
            }
        });

        Informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                Intent intent = new Intent(Activity_perfilUsuario.this, Activity_somos_nosotros.class);

                startActivity(intent);
                finish();
            }
        });
    }
}
