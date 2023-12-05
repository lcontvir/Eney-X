package es.eney_x.eney_x;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class activity_componente_unico extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad, por ejemplo, cargar un diseño XML
        setContentView(R.layout.activity_componente_unico);

        // Puedes agregar más lógica de inicialización aquí si es necesario

        // Llamada al método para cargar imágenes
        cargarImagenes();
    }

    // Otros métodos del ciclo de vida de la actividad, si es necesario

    @Override
    protected void onResume() {
        super.onResume();
        // Lógica adicional cuando la actividad se reanuda
    }

    // Otros métodos del ciclo de vida de la actividad, si es necesario

    // Método para cargar imágenes en ImageView
    private void cargarImagenes() {
        cargarImagen(R.id.logo, R.drawable.logoeneyx);
        cargarImagen(R.id.check1, R.drawable.check);
        cargarImagen(R.id.check2, R.drawable.check);
        cargarImagen(R.id.check3, R.drawable.check);
        cargarImagen(R.id.check4, R.drawable.check);
        cargarImagen(R.id.check5, R.drawable.check);
        cargarImagen(R.id.check6, R.drawable.cross);
        cargarImagen(R.id.boton_atras, R.drawable.flechamoradablancarellenaizquierda);
    }

    // Método auxiliar para cargar imágenes en un ImageView específico
    private void cargarImagen(int imageViewId, int imagenId) {
        ImageView imageView = findViewById(imageViewId);
        imageView.setImageResource(imagenId);
    }
}