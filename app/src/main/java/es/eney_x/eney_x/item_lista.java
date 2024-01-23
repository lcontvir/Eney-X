package es.eney_x.eney_x;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class item_lista extends AppCompatActivity {
    private ConstraintLayout constraintLayoutPadre;
    private ConstraintLayout constraintLayoutHijo;
    private boolean isHijoVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_lista);

        // Obtener referencias a los ConstraintLayouts
        constraintLayoutPadre = findViewById(R.id.constrainLayoutPadre);
        constraintLayoutHijo = findViewById(R.id.constraintLayoutHijo);

        // Configurar el click listener para el ConstraintLayout padre
        constraintLayoutPadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleHijoVisibility();
            }
        });
    }

    private void toggleHijoVisibility() {
        // Cambiar la visibilidad del ConstraintLayout hijo
        if (isHijoVisible) {
            constraintLayoutHijo.setVisibility(View.GONE);
        } else {
            constraintLayoutHijo.setVisibility(View.VISIBLE);
        }

        // Cambiar el estado de visibilidad
        isHijoVisible = !isHijoVisible;
    }
}