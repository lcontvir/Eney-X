package es.eney_x.eney_x.controlador;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import  android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.modelo.Item_lista;
import es.eney_x.eney_x.modelo.Privacidad;
import es.eney_x.eney_x.modelo.Usuario;
import es.eney_x.eney_x.vista.Activity_componente_main;

public class PrivacidadAdaptador extends RecyclerView.Adapter<PrivacidadAdaptador.PrivacidadViewHolder> {

    private List<Privacidad> listaPrivacidad;
    private Context context;
    private String textoLicencia;
    private FirebaseCallback firebaseCallback;


    public PrivacidadAdaptador(Context context, List<Privacidad> listaPrivacidad, String textoLicencia) {
        this.context = context;
        this.listaPrivacidad = listaPrivacidad;
        this.textoLicencia = textoLicencia;
    }

    @NonNull
    @Override
    public PrivacidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista_privacidad, parent, false);
        return new PrivacidadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrivacidadViewHolder holder, int position) {
        Privacidad privacidad = listaPrivacidad.get(position);
        if (privacidad.isUbicacion()) {
            holder.tvUbicacion.setText("- Ubicación permitida: pulse para denegar");
        } else {
            holder.tvUbicacion.setText("- Ubicación denegada: pulse para permitir");
        }
        if (privacidad.isCookies_marketing()) {
            holder.tvGalletasMarketing.setText("- Marketing permitida: pulse para denegar");
        } else {
            holder.tvGalletasMarketing.setText("- Marketing denegada: pulse para permitir");
        }
        if (privacidad.isCookies_analiticas()) {
            holder.tvGalletasAnaliticas.setText("- Coockies analiticas permitida: pulse para denegar");
        } else {
            holder.tvGalletasAnaliticas.setText("- Coockies analiticas denegada: pulse para permitir");
        }
        if (privacidad.isNotificaciones_publicidad()) {
            holder.tvNotificaciones.setText("- Notificaciones publicidad permitida: pulse para denegar");
        } else {
            holder.tvNotificaciones.setText("- Notificaciones publicidad denegada: pulse para permitir");
        }

        holder.permisos.setText(" Configuración de permisos:");


        holder.tvUbicacion.setTypeface(null, Typeface.BOLD);
        holder.tvNotificaciones.setTypeface(null, Typeface.BOLD);
        holder.tvGalletasAnaliticas.setTypeface(null, Typeface.BOLD);
        holder.tvGalletasMarketing.setTypeface(null, Typeface.BOLD);
        holder.enviar_privacidad.setTypeface(null, Typeface.BOLD);

        holder.tvUbicacion.setTextSize(20);
        holder.tvNotificaciones.setTextSize(20);
        holder.tvGalletasAnaliticas.setTextSize(20);
        holder.tvGalletasMarketing.setTextSize(20);

        holder.tvUbicacion.setPadding(5, 0, 5, 15);
        holder.tvNotificaciones.setPadding(5, 15, 5, 15);
        holder.tvGalletasAnaliticas.setPadding(5, 15, 5, 35);
        holder.tvGalletasMarketing.setPadding(5, 15, 5, 15);

        holder.ch.setPadding(20, 20, 20, 20);
        holder.ch.setVisibility(View.VISIBLE);
        holder.enviar_privacidad.setVisibility(View.VISIBLE);


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


        holder.tvUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privacidad.setUbicacion(!privacidad.isUbicacion());
                Usuario.getInstance().setPrivacidad(privacidad);

                notifyItemChanged(holder.getAdapterPosition());


            }
        });
        holder.tvNotificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privacidad.setNotificaciones_publicidad(!privacidad.isNotificaciones_publicidad());
                Usuario.getInstance().setPrivacidad(privacidad);

                notifyItemChanged(holder.getAdapterPosition());


            }
        });
        holder.tvGalletasAnaliticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privacidad.setCookies_analiticas(!privacidad.isCookies_analiticas());
                Usuario.getInstance().setPrivacidad(privacidad);

                notifyItemChanged(holder.getAdapterPosition());


            }
        });
        holder.tvGalletasMarketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privacidad.setCookies_marketing(!privacidad.isCookies_marketing());
                Usuario.getInstance().setPrivacidad(privacidad);

                notifyItemChanged(holder.getAdapterPosition());


            }
        });
        holder.enviar_privacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminFirebase.ActualizarUsuario(new FirebaseCallback() {
                    @Override
                    public void onSucceed() {

                        Toast.makeText(context, "Se actualizó correctamente", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFail(Exception e) {
                        Toast.makeText(context, "Error al intentar actualizar", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onRecover() {

                    }

                    @Override
                    public void onNotFound() {

                    }

                    @Override
                    public void onRegister() {

                    }
                });
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
        TextView permisos;
        Button enviar_privacidad;

        ConstraintLayout cp;
        ConstraintLayout ch;


        public PrivacidadViewHolder(@NonNull View itemView) {
            super(itemView);
            enviar_privacidad = itemView.findViewById(R.id.enviar_privacidad);
            tvUbicacion = itemView.findViewById(R.id.tvinfo5);
            tvNotificaciones = itemView.findViewById(R.id.tvinfo1);
            tvGalletasAnaliticas = itemView.findViewById(R.id.tvinfo3);
            tvGalletasMarketing = itemView.findViewById(R.id.tvinfo2);
            cp = itemView.findViewById(R.id.constrainLayoutPadre);
            ch = itemView.findViewById(R.id.constraintLayoutHijo);
            permisos = itemView.findViewById(R.id.nombreVpn1);
        }


    }
}
