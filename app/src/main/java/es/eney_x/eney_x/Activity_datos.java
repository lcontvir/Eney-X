package es.eney_x.eney_x;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Activity_datos extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LicenciasAdaptador LicenciaAdaptr;
    private PrivacidadAdaptador PrivacidadAdaptr;
    private DispositivosAdaptador DispositivosAdaptr;
    private Facturacion_facturaAdaptador FacturaciaAdaptr;
    private Facturacion_pagoAdaptador PagoAdaptr;

    private TextView textViewBoton;
    private ImageButton boton_atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        String textoLicencia = getIntent().getStringExtra("textolicencia");
        textViewBoton = findViewById(R.id.textViewboton);
        textViewBoton.setText(textoLicencia);
        boton_atras = findViewById(R.id.atras);

        boton_atras.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Al hacer clic en el botón, crea un intent para volver a la actividad anterior
                    Intent intent = new Intent(Activity_datos.this, activity_perfilUsuario.class);

                    startActivity(intent);
                    finish();
                }
            });


        if ("      Licencias  ".equals(textoLicencia)) {
            List<Licencias> listaLicencias = new ArrayList<>();
            listaLicencias.add(new Licencias(1, "Licencia 1", "Código 1", "Descripción 1"));
            listaLicencias.add(new Licencias(2, "Licencia 2", "Código 2", "Descripción 2"));
            listaLicencias.add(new Licencias(3, "Licencia 3", "Código 3", "Descripción 3"));

            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            LicenciaAdaptr = new LicenciasAdaptador(this, listaLicencias, textoLicencia);
            recyclerView.setAdapter(LicenciaAdaptr);

        } else if ("     Dispositivos  ".equals(textoLicencia)) {

            List<Dispositivos> listaDispositivos = new ArrayList<>();
            listaDispositivos.add(new Dispositivos("01A", true, "Estándar", "Modelo profesional"));
            listaDispositivos.add(new Dispositivos("02B", false, "Avanzada", "Modelo Básico"));
            listaDispositivos.add(new Dispositivos("03C", true, "Básica", "Modelo profesional"));

            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            DispositivosAdaptr = new DispositivosAdaptador(this, listaDispositivos,textoLicencia);
            recyclerView.setAdapter(DispositivosAdaptr);


        } else if ("      Privacidad  ".equals(textoLicencia)) {
            List<Privacidad> listaPrivacidad = new ArrayList<>();
            listaPrivacidad.add(new Privacidad(true, true, true, true));
            listaPrivacidad.add(new Privacidad(true, false, true, false));
            listaPrivacidad.add(new Privacidad(false, false, false, false));


            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            PrivacidadAdaptr = new PrivacidadAdaptador(this, listaPrivacidad,textoLicencia);
            recyclerView.setAdapter(PrivacidadAdaptr);
        }else if ("      Factura  ".equals(textoLicencia)) {
            List<Facturacion_factura> listFacturacion = new ArrayList<>();
            listFacturacion.add(new Facturacion_factura("3100U","Licencia Profesional"));
            listFacturacion.add(new Facturacion_factura("3100U","Licencia Profesional"));
            listFacturacion.add(new Facturacion_factura("3100U","Licencia Profesional"));


            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            FacturaciaAdaptr = new Facturacion_facturaAdaptador(this, listFacturacion,textoLicencia);
            recyclerView.setAdapter(FacturaciaAdaptr);
        }else if ("      Pago  ".equals(textoLicencia)) {
            List<Facturacion_pago> listaPago = new ArrayList<>();
            listaPago.add(new Facturacion_pago("44444444A", "6/12", 99 , "Martin Cristo Buda"));
            listaPago.add(new Facturacion_pago("55555555A", "8/10", 79 , "Martin Cristo Buda"));
            listaPago.add(new Facturacion_pago("46666666B", "1/11", 86 , "Martin Cristo Buda"));


            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            PagoAdaptr = new Facturacion_pagoAdaptador(this, listaPago,textoLicencia);
            recyclerView.setAdapter(PagoAdaptr);
        }
    }
}
