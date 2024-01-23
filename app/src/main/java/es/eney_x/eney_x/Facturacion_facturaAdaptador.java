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

public class Facturacion_facturaAdaptador extends RecyclerView.Adapter<Facturacion_facturaAdaptador.FacturacionViewHolder> {

    private List<Facturacion_factura> listaFacturas;
    private Context context;
    private String textoLicencia;

    public Facturacion_facturaAdaptador(Context context, List<Facturacion_factura> listaFacturas, String textoLicencia) {
        this.context = context;
        this.listaFacturas = listaFacturas;
        this.textoLicencia = textoLicencia;
    }

    @NonNull
    @Override
    public FacturacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
        return new FacturacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacturacionViewHolder holder, int position) {
        Facturacion_factura factura = listaFacturas.get(position);

        holder.tvIdFactura.setText("ID Factura: " + factura.getIdFactura());
        holder.tvArchivosFactura.setText("Archivos Factura: " + factura.getArchivosFactura());
        holder.info.setText("A continuacion le presentamos información importante relacionada con la facturación");

        holder.tvIdFactura.setTypeface(null, Typeface.BOLD);
        holder.tvArchivosFactura.setTypeface(null, Typeface.BOLD);

        holder.tvIdFactura.setTextColor(context.getResources().getColor(R.color.botonVerde));
        holder.tvArchivosFactura.setTextColor(context.getResources().getColor(R.color.amarillito));

        holder.estado.setText(textoLicencia);

        holder.cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.toggleHijoVisibility();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementa la lógica para manejar el clic en un elemento si es necesario
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaFacturas.size();
    }

    public static class FacturacionViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdFactura;
        TextView tvArchivosFactura;
        TextView estado;
        TextView info;

        ConstraintLayout cp;
        ConstraintLayout ch;
        private boolean isHijoVisible = false;

        public FacturacionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdFactura = itemView.findViewById(R.id.tvinfo1);
            info =itemView.findViewById(R.id.tvinfo4);
            tvArchivosFactura = itemView.findViewById(R.id.tvinfo2);
            estado = itemView.findViewById(R.id.estadoVpn);
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
