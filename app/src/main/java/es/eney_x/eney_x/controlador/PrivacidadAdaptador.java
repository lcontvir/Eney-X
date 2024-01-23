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
import es.eney_x.eney_x.modelo.Privacidad;

public class PrivacidadAdaptador extends RecyclerView.Adapter<PrivacidadAdaptador.PrivacidadViewHolder> {

    private List<Privacidad> listaPrivacidad;
    private Context context;
    private String textoLicencia;

    public PrivacidadAdaptador(Context context, List<Privacidad> listaPrivacidad, String textoLicencia) {
        this.context = context;
        this.listaPrivacidad = listaPrivacidad;
        this.textoLicencia = textoLicencia;
    }

    @NonNull
    @Override
    public PrivacidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        return new PrivacidadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrivacidadViewHolder holder, int position) {
        Privacidad privacidad = listaPrivacidad.get(position);

        holder.tvUbicacion.setText("Ubicación:               " + privacidad.isUbicacion());
        holder.tvNotificaciones.setText("Notificaciones:                 " + privacidad.isNotificaciones_publicidad());
        holder.tvGalletasAnaliticas.setText("Galletas Analíticas:             " + privacidad.isCookies_analiticas());
        holder.tvGalletasMarketing.setText("Galletas de Marketing:            " + privacidad.isCookies_marketing());

        holder.tvUbicacion.setTypeface(null, Typeface.BOLD);
        holder.tvNotificaciones.setTypeface(null, Typeface.BOLD);
        holder.tvGalletasAnaliticas.setTypeface(null, Typeface.BOLD);
        holder.tvGalletasMarketing.setTypeface(null, Typeface.BOLD);


        if (privacidad.isNotificaciones_publicidad()) {
            holder.tvNotificaciones.setTextColor(context.getResources().getColor(R.color.botonVerde));
        } else {
            holder.tvNotificaciones.setTextColor(context.getResources().getColor(R.color.rojo));
        }
        if (privacidad.isCookies_analiticas()) {
            holder.tvGalletasAnaliticas.setTextColor(context.getResources().getColor(R.color.botonVerde));
        } else {
            holder.tvGalletasAnaliticas.setTextColor(context.getResources().getColor(R.color.rojo));
        }
        if (privacidad.isCookies_marketing()) {
            holder.tvGalletasMarketing.setTextColor(context.getResources().getColor(R.color.botonVerde));
        } else {
            holder.tvGalletasMarketing.setTextColor(context.getResources().getColor(R.color.rojo));
        }
        if (privacidad.isUbicacion()) {
            holder.tvUbicacion.setTextColor(context.getResources().getColor(R.color.botonVerde));
        } else {
            holder.tvUbicacion.setTextColor(context.getResources().getColor(R.color.rojo));
        }


        holder.estado.setText(textoLicencia);

        holder.cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.toggleHijoVisibility();
            }
        });

        // Manejar clic en el elemento si es necesario
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Puedes personalizar este mensaje según tus necesidades
                Toast.makeText(context, "Privacidad seleccionada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPrivacidad.size();
    }

    public static class PrivacidadViewHolder extends RecyclerView.ViewHolder {
        TextView tvUbicacion;
        TextView tvNotificaciones;
        TextView tvGalletasAnaliticas;
        TextView tvGalletasMarketing;
        TextView estado;

        ConstraintLayout cp;
        ConstraintLayout ch;
        private boolean isHijoVisible = false;

        public PrivacidadViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUbicacion = itemView.findViewById(R.id.tvinfo4);
            tvNotificaciones = itemView.findViewById(R.id.tvinfo1);
            tvGalletasAnaliticas = itemView.findViewById(R.id.tvinfo3);
            tvGalletasMarketing = itemView.findViewById(R.id.tvinfo2);
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
