package es.eney_x.eney_x;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Facturacion_pagoAdaptador extends RecyclerView.Adapter<Facturacion_pagoAdaptador.FacturacionPagoViewHolder> {

    private List<Facturacion_pago> listaPagos;
    private Context context;
    private String textoLicencia;

    public Facturacion_pagoAdaptador(Context context, List<Facturacion_pago> listaPagos, String textoLicencia) {
        this.context = context;
        this.listaPagos = listaPagos;
        this.textoLicencia = textoLicencia;
    }

    @NonNull
    @Override
    public FacturacionPagoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        return new FacturacionPagoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacturacionPagoViewHolder holder, int position) {
        Facturacion_pago pago = listaPagos.get(position);

        holder.tvTarjeta.setText("Tarjeta: " + pago.getTarjeta());
        holder.tvCaducidad.setText("Caducidad: " + pago.getCaducidad());
        holder.tvCsv.setText("CSV: " + pago.getCsv());
        holder.tvNombre.setText("Nombre: " + pago.getNombre());

        holder.tvTarjeta.setTypeface(null, Typeface.BOLD);
        holder.tvCaducidad.setTypeface(null, Typeface.BOLD);
        holder.tvCsv.setTypeface(null, Typeface.BOLD);
        holder.tvNombre.setTypeface(null, Typeface.BOLD);

        holder.tvCaducidad.setTextColor(context.getResources().getColor(R.color.rojo));
        holder.tvCsv.setTextColor(context.getResources().getColor(R.color.amarillito));
        holder.tvNombre.setTextColor(context.getResources().getColor(R.color.botonVerde));

        holder.estado.setText(textoLicencia);


        // Puedes personalizar la apariencia de los elementos según tus necesidades

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
                // Implementa la lógica para manejar el clic en un elemento si es necesario
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPagos.size();
    }

    public static class FacturacionPagoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTarjeta;
        TextView tvCaducidad;
        TextView tvCsv;
        TextView tvNombre;

        ConstraintLayout cp;
        ConstraintLayout ch;
        private boolean isHijoVisible = false;

        TextView estado;

        public FacturacionPagoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTarjeta = itemView.findViewById(R.id.tvinfo4);
            tvCaducidad = itemView.findViewById(R.id.tvinfo2);
            tvCsv = itemView.findViewById(R.id.tvinfo3);
            tvNombre = itemView.findViewById(R.id.tvinfo1);
            estado= itemView.findViewById(R.id.estadoVpn);
            cp = itemView.findViewById(R.id.constrainLayoutPadre);
            ch = itemView.findViewById(R.id.constraintLayoutHijo);
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
