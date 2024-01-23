package es.eney_x.eney_x;


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


public class DispositivosAdaptador extends RecyclerView.Adapter<DispositivosAdaptador.DispositivosViewHolder> {

    private List<Dispositivos> listaDispositivos;
    private Context context;

    private String textoLicencia;

    public DispositivosAdaptador(Context context, List<Dispositivos> listaDispositivos,  String textoLicencia) {
        this.context = context;
        this.listaDispositivos = listaDispositivos;
        this.textoLicencia = textoLicencia;
    }

    @NonNull
    @Override
    public DispositivosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        return new DispositivosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DispositivosViewHolder holder, int position) {
        Dispositivos dispositivo = listaDispositivos.get(position);

        holder.tvIdDispositivo.setText("Dispositivo:            " + dispositivo.getId_Dispositivo());
        holder.tvProtegido.setText("Protegido:               " + (dispositivo.isProtegido() ? "Sí" : "No"));
        holder.tvLicencia.setText("Licencia:                 " + dispositivo.getLicencia());
        holder.tvModelo.setText("Modelo:                  " + dispositivo.getModelo());
        //Poner en negrita datos dinamicos
        holder.tvProtegido.setTypeface(null, Typeface.BOLD);
        holder.tvLicencia.setTypeface(null, Typeface.BOLD);
        holder.tvIdDispositivo.setTypeface(null, Typeface.BOLD);
        holder.tvModelo.setTypeface(null, Typeface.BOLD);

        holder.tvIdDispositivo.setTextColor(context.getResources().getColor(R.color.rojo));
        holder.tvProtegido.setTextColor(context.getResources().getColor(R.color.amarillito));
        holder.tvLicencia.setTextColor(context.getResources().getColor(R.color.botonVerde));

        holder.estado.setText(textoLicencia);


        holder.cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.toggleHijoVisibility();
            }
        });

        // Handle item click if needed
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "ID: " + dispositivo.getId_Dispositivo(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDispositivos.size();
    }

    public static class DispositivosViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdDispositivo;
        TextView tvProtegido;
        TextView tvLicencia;
        TextView tvModelo;
        TextView estado;

        ConstraintLayout cp;
        ConstraintLayout ch;
        private boolean isHijoVisible = false;

        public DispositivosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdDispositivo = itemView.findViewById(R.id.tvinfo1);
            tvProtegido = itemView.findViewById(R.id.tvinfo2);
            tvLicencia = itemView.findViewById(R.id.tvinfo3);
            tvModelo = itemView.findViewById(R.id.tvinfo4);
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
