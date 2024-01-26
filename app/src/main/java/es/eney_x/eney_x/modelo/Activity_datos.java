package es.eney_x.eney_x.modelo;

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
            List<Factura> listFacturacion = new ArrayList<>();
            listFacturacion.add(new Factura("Licencia Profesional"));
            listFacturacion.add(new Factura("Licencia Profesional"));
            listFacturacion.add(new Factura("Licencia Profesional"));


            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            FacturaciaAdaptr = new FacturacionFacturaAdaptador(this, listFacturacion,textoLicencia);
            recyclerView.setAdapter(FacturaciaAdaptr);
        }else if ("      Pago  ".equals(textoLicencia)) {
            List<MetodoPago> listaPago = new ArrayList<>();
            listaPago.add(new MetodoPago("8/10", 789, "Martin Cristo Buda" , "46666666B"));
            listaPago.add(new MetodoPago("9/10", 457, "Martin Cristo Buda" , "123456789012"));
            listaPago.add(new MetodoPago("10/10", 146, "Martin Cristo Buda" , "1423456789041234"));


            recyclerView = findViewById(R.id.recyclerViw);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            PagoAdaptr = new FacturacionMetodoPagoAdaptador(this, listaPago,textoLicencia);
            recyclerView.setAdapter(PagoAdaptr);
        }
    }
}
