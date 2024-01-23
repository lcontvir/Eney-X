package es.eney_x.eney_x.controlador;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.modelo.Licencia;

public class LicenciasAdaptador extends RecyclerView.Adapter<LicenciasAdaptador.LicenciasViewHolder> {

    private List<Licencia> listaLicencias;
    private Context context;
    private String textoLicencia;

    public LicenciasAdaptador(Context context, List<Licencia> listaLicencias, String textoLicencia) {
        this.context = context;
        this.listaLicencias = listaLicencias;
        this.textoLicencia = textoLicencia;
    }

    @NonNull
    @Override
    public LicenciasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        return new LicenciasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LicenciasViewHolder holder, int position) {
        Licencia licencia = listaLicencias.get(position);

        holder.tvIdLicencia.setText("Clave:                            " +(licencia.getClave_licencia()));
        holder.tvNombreLicencia.setText("Tipo:                 " + licencia.getTipo_licencia());
        holder.tvCodigoLicencia.setText("Dispositivos Maximos:                    " + licencia.getDispositivos_maximos());
        holder.tvDescripcionLicencia.setText("Fecha de Caducidad:  " + licencia.getCaducidad());
        holder.estado.setText(textoLicencia);

        holder.tvIdLicencia.setTypeface(null, Typeface.BOLD);
        holder.tvCodigoLicencia.setTypeface(null, Typeface.BOLD);
        holder.tvDescripcionLicencia.setTypeface(null, Typeface.BOLD);

        holder.tvIdLicencia.setTextColor(context.getResources().getColor(R.color.rojo));
        holder.tvCodigoLicencia.setTextColor(context.getResources().getColor(R.color.botonVerde));
        holder.tvNombreLicencia.setTextColor(context.getResources().getColor(R.color.amarillito));

        holder.cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.toggleHijoVisibility();
            }
        });

        // Manejar clic en el elemento si es necesario
    }

    @Override
    public int getItemCount() {
        return listaLicencias.size();
    }

    public class LicenciasViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdLicencia;
        TextView tvNombreLicencia;
        TextView tvCodigoLicencia;
        TextView tvDescripcionLicencia;

        TextView estado;

        ConstraintLayout cp;
        ConstraintLayout ch;
        private boolean isHijoVisible = false;

        public LicenciasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdLicencia = itemView.findViewById(R.id.tvinfo1);
            tvNombreLicencia = itemView.findViewById(R.id.tvinfo2);
            tvCodigoLicencia = itemView.findViewById(R.id.tvinfo3);
            tvDescripcionLicencia = itemView.findViewById(R.id.tvinfo4);
            cp = itemView.findViewById(R.id.constrainLayoutPadre);
            ch = itemView.findViewById(R.id.constraintLayoutHijo);
            estado = itemView.findViewById(R.id.estadoVpn);
        }

        public void toggleHijoVisibility() {
            // Cambiar la visibilidad del ConstraintLayout hijo
            if (isHijoVisible) {
                ch.setVisibility(View.GONE);
            } else {
                ch.setVisibility(View.VISIBLE);
            }

            // Cambiar el estado de visibilidad
            isHijoVisible = !isHijoVisible;
        }
    }
}
