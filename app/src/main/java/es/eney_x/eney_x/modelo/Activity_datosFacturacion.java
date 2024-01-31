package es.eney_x.eney_x.modelo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.vista.*;

public class Activity_datosFacturacion extends AppCompatActivity {
    private TextView tvInfo;
    private ListView listpago;
    private ListView listfact;
    private Button sald;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_facturacion);

        try {
            // Inicializar vistas
            ImageButton backButton = findViewById(R.id.atras);
            Button btnpago = findViewById(R.id.pago);
            Button btnfactura = findViewById(R.id.factura);
            Button btnsaldo = findViewById(R.id.saldo);
            sald = findViewById(R.id.saldo);

            // Configurar evento de clic para el botón de retroceso
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Define la nueva actividad que quieres abrir (activity_componente_main)
                    Intent intent = new Intent(Activity_datosFacturacion.this, Activity_perfilUsuario.class);

                    // Inicia la nueva actividad y cierra la actual
                    startActivity(intent);
                    finish();
                }
            });

            // Configurar evento de clic para el botón de facturas
            btnfactura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Al hacer clic en el botón, crea un intent para ir a la actividad de datos con tipo de licencia "Factura"
                    Intent intent = new Intent(Activity_datosFacturacion.this, Activity_datos.class);
                    intent.putExtra("textolicencia", "      Factura  ");
                    startActivity(intent);
                    finish();
                }
            });

            // Configurar evento de clic para el botón de pagos
            btnpago.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Define la nueva actividad que quieres abrir (Activity_datos)
                    Intent intent = new Intent(Activity_datosFacturacion.this, Activity_datos.class);

                    // Pasa el texto como extra
                    intent.putExtra("textolicencia", "      Pago  ");

                    // Inicia la nueva actividad y cierra la actual
                    startActivity(intent);
                    finish();
                }
            });

            // Configurar evento de clic para el botón de saldo
            btnsaldo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Simulación de mostrar el saldo, cambiar el texto del botón
                    btnsaldo.setText("Le quedan 115 euros por gastar");
                }
            });

        } catch (Exception e) {
            // Capturar cualquier excepción general
            e.printStackTrace();
        }
    }
}
