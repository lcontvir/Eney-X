package es.eney_x.eney_x.modelo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.controlador.AdminFirebase;
import es.eney_x.eney_x.controlador.DispositivosAdaptador;
import es.eney_x.eney_x.controlador.FacturacionFacturaAdaptador;
import es.eney_x.eney_x.controlador.FacturacionMetodoPagoAdaptador;
import es.eney_x.eney_x.controlador.FirebaseCallback;
import es.eney_x.eney_x.controlador.LicenciasAdaptador;
import es.eney_x.eney_x.controlador.PrivacidadAdaptador;
import es.eney_x.eney_x.vista.*;

public class Activity_datos extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LicenciasAdaptador LicenciaAdaptr;
    private PrivacidadAdaptador PrivacidadAdaptr;
    private DispositivosAdaptador DispositivosAdaptr;
    private FacturacionFacturaAdaptador FacturaciaAdaptr;
    private FacturacionMetodoPagoAdaptador PagoAdaptr;

    private TextView textViewBoton;
    private ImageButton boton_atras;
    FirebaseCallback firebaseCallback;



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
                Intent intent = new Intent(Activity_datos.this, Activity_perfilUsuario.class);

                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerViw);

        if ("      Licencias  ".equals(textoLicencia)) {

            List<Licencia> listaLicencias = new ArrayList<>();


            for (Licencia licencia: Usuario.getInstance().getLicencias()){
                listaLicencias.add(new Licencia(licencia.getCaducidad(), licencia.getClave_licencia(), licencia.getDispositivos_maximos(), licencia.getTipo_licencia()));
            }

            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            LicenciaAdaptr = new LicenciasAdaptador(this, listaLicencias, textoLicencia);
            recyclerView.setAdapter(LicenciaAdaptr);

        } else if ("     Dispositivos  ".equals(textoLicencia)) {

            List<Dispositivo> listaDispositivos = new ArrayList<>();



            for(Dispositivo dispositivo: Usuario.getInstance().getDispositivos()){
                listaDispositivos.add(new Dispositivo(dispositivo.isActivo(), dispositivo.getLicencia(), dispositivo.getModelo()));
            }



            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            DispositivosAdaptr = new DispositivosAdaptador(this, listaDispositivos,textoLicencia);
            recyclerView.setAdapter(DispositivosAdaptr);

        } else if ("      Privacidad  ".equals(textoLicencia)) {

            List<Privacidad> listaPrivacidad = new ArrayList<>();
            listaPrivacidad.add(new Privacidad(Usuario.getInstance().getPrivacidad().isCookies_analiticas(), Usuario.getInstance().getPrivacidad().isCookies_marketing(), Usuario.getInstance().getPrivacidad().isNotificaciones_publicidad(), Usuario.getInstance().getPrivacidad().isUbicacion()));

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            PrivacidadAdaptr = new PrivacidadAdaptador(this, listaPrivacidad,textoLicencia);
            recyclerView.setAdapter(PrivacidadAdaptr);

        }else if ("      Factura  ".equals(textoLicencia)) {

            List<Factura> listaFacturas = new ArrayList<>();

            for (Factura factura: Usuario.getInstance().getFacturacion().getFacturas()){
                listaFacturas.add(new Factura(factura.getUbicacion_factura()));
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(Activity_datos.this));
            FacturaciaAdaptr = new FacturacionFacturaAdaptador(Activity_datos.this, listaFacturas, textoLicencia);
            recyclerView.setAdapter(FacturaciaAdaptr);


        } else if ("      Pago  ".equals(textoLicencia)) {

            Usuario usuario = Usuario.getInstance();
            List<MetodoPago> listaPagos = usuario.getFacturacion().getMetodos_pago();

            // Verificar si la lista de métodos de pago no está vacía
            if (listaPagos != null && !listaPagos.isEmpty()) {
                Log.d("Activity_datos", "Tamaño de listaPagos: " + listaPagos.size());
                // Crear una nueva lista para almacenar los métodos de pago clonados
                List<MetodoPago> listaClonada = new ArrayList<>();

                for (MetodoPago pago : listaPagos) {
                    listaClonada.add(new MetodoPago(pago.getCaducidad(), pago.getCsv(), pago.getNombre(), pago.getTarjeta()));
                }

                recyclerView = findViewById(R.id.recyclerViw);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                PagoAdaptr = new FacturacionMetodoPagoAdaptador(this, listaClonada, textoLicencia);
                recyclerView.setAdapter(PagoAdaptr);
            } else {
                // Manejar el caso en que no haya métodos de pago disponibles
                Toast.makeText(this, "No hay métodos de pago disponibles", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
