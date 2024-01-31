package es.eney_x.eney_x.controlador;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.modelo.Privacidad;
import es.eney_x.eney_x.modelo.Usuario;

// Clase del adaptador para la RecyclerView
public class PrivacidadAdaptador extends RecyclerView.Adapter<PrivacidadAdaptador.PrivacidadViewHolder> {
    // Lista de objetos Privacidad

    //lista de objetos de tipo Privacidad. Esta lista se utilizará para almacenar los datos que se mostrarán en la RecyclerView.
    private List<Privacidad> listaPrivacidad;

    //Este contexto se utilizará para acceder a recursos y servicios de Android
    private Context context;

    //Este texto se utilizará para mostrar información sobre la licencia en la interfaz de usuario
    private String textoLicencia;

    // Esta interfaz se utilizará para manejar las respuestas de las operaciones relacionadas con Firebase, como la actualización de datos de usuario.
    private FirebaseCallback firebaseCallback;

    //Constructor
    public PrivacidadAdaptador(Context context, List<Privacidad> listaPrivacidad, String textoLicencia) {
        this.context = context;
        this.listaPrivacidad = listaPrivacidad;
        this.textoLicencia = textoLicencia;
    }


    @NonNull
    @Override
    public PrivacidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        try {
            // Se infla el diseño para crear la vista del elemento de la lista
            View view = LayoutInflater.from(context).inflate(R.layout.item_lista_privacidad, parent, false);

            // Se verifica si la vista inflada es nula
            if (view == null) {
                // Si la vista inflada es nula, se lanza una excepción
                throw new NullPointerException("Error inflating view: View is null");
            }

            // Se crea un nuevo ViewHolder con la vista inflada y se devuelve
            return new PrivacidadViewHolder(view);
        } catch (Exception e) {
            // Se captura cualquier excepción y se imprime el rastreo de la pila en la consola
            e.printStackTrace();
            // Se devuelve un valor nulo en caso de excepción
            return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull PrivacidadViewHolder holder, int position) {
        // Se obtiene el contexto de la vista del elemento actual
        Context context = holder.itemView.getContext();

        // Se obtienen los colores definidos en los recursos
        int colorVerde = ContextCompat.getColor(context, R.color.botonVerde);
        int colorRojo = ContextCompat.getColor(context, R.color.rojo);

        // Se obtiene el objeto Privacidad correspondiente a la posición del elemento en la lista
        Privacidad privacidad = listaPrivacidad.get(position);

        // Se establece el texto para el TextView de permisos
        holder.permisos.setText(" Configuración de permisos:");

        // Se establece el tipo de letra en negrita para los TextView relevantes
        holder.tvUbicacion.setTypeface(null, Typeface.BOLD);
        holder.tvNotificaciones.setTypeface(null, Typeface.BOLD);
        holder.tvGalletasAnaliticas.setTypeface(null, Typeface.BOLD);
        holder.tvGalletasMarketing.setTypeface(null, Typeface.BOLD);
        holder.enviar_privacidad.setTypeface(null, Typeface.BOLD);

        // Se establece el tamaño de texto para los TextView relevantes
        holder.tvUbicacion.setTextSize(20);
        holder.tvNotificaciones.setTextSize(20);
        holder.tvGalletasAnaliticas.setTextSize(20);
        holder.tvGalletasMarketing.setTextSize(20);

        // Se establece el relleno interno (padding) para los TextView relevantes
        holder.tvUbicacion.setPadding(5, 0, 5, 15);
        holder.tvNotificaciones.setPadding(5, 15, 5, 15);
        holder.tvGalletasAnaliticas.setPadding(5, 15, 5, 35);
        holder.tvGalletasMarketing.setPadding(5, 15, 5, 15);

        // Se establece el relleno interno (padding) para el ConstraintLayout y se hace visible
        holder.ch.setPadding(20, 20, 20, 20);
        holder.ch.setVisibility(View.VISIBLE);

        // Se hace visible el botón enviar_privacidad
        holder.enviar_privacidad.setVisibility(View.VISIBLE);


        // Se cambia el color del textView y el texto segun el estado
        if (privacidad.isNotificaciones_publicidad()) {
            holder.tvNotificaciones.setTextColor(colorVerde);
            holder.tvNotificaciones.setText("- Notificaciones publicidad permitida");

        } else {
            holder.tvNotificaciones.setTextColor(colorRojo);
            holder.tvNotificaciones.setText("- Notificaciones publicidad denegada");
        }

        if (privacidad.isCookies_analiticas()) {
            holder.tvGalletasAnaliticas.setTextColor(colorVerde);
            holder.tvGalletasAnaliticas.setText("- Coockies analiticas permitida");
        } else {
            holder.tvGalletasAnaliticas.setTextColor(colorRojo);
            holder.tvGalletasAnaliticas.setText("- Coockies analiticas denegada");
        }

        if (privacidad.isCookies_marketing()) {
            holder.tvGalletasMarketing.setTextColor(colorVerde);
            holder.tvGalletasMarketing.setText("- Marketing permitida");
        } else {
            holder.tvGalletasMarketing.setTextColor(colorRojo);
            holder.tvGalletasMarketing.setText("- Marketing denegada");
        }

        if (privacidad.isUbicacion()) {
            holder.tvUbicacion.setTextColor(colorVerde);
            holder.tvUbicacion.setText("- Ubicación permitida");
        } else {
            holder.tvUbicacion.setTextColor(colorRojo);
            holder.tvUbicacion.setText("- Ubicación denegada");
        }


        holder.swubicacion.setOnCheckedChangeListener(null); // Desactiva el escuchador de eventos
        holder.swubicacion.setChecked(privacidad.isUbicacion()); // Actualiza el estado del interruptor
        holder.swubicacion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    privacidad.setUbicacion(isChecked);
                    Usuario.getInstance().setPrivacidad(privacidad);
                    notifyItemChanged(holder.getAdapterPosition());
                } catch (Exception e) {
                    Log.e("PrivacidadAdaptador", "Error al cambiar estado de ubicación: " + e.getMessage());
                }
            }
        });

        holder.swnotificaciones.setOnCheckedChangeListener(null);
        holder.swnotificaciones.setChecked(privacidad.isNotificaciones_publicidad());
        holder.swnotificaciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    privacidad.setNotificaciones_publicidad(isChecked);
                    Usuario.getInstance().setPrivacidad(privacidad);
                    notifyItemChanged(holder.getAdapterPosition());
                } catch (Exception e) {
                    Log.e("PrivacidadAdaptador", "Error al cambiar estado de notificaciones de publicidad: " + e.getMessage());
                }
            }
        });

        holder.swgalletasanaliticas.setOnCheckedChangeListener(null);
        holder.swgalletasanaliticas.setChecked(privacidad.isCookies_analiticas());
        holder.swgalletasanaliticas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    privacidad.setCookies_analiticas(isChecked);
                    Usuario.getInstance().setPrivacidad(privacidad);
                    notifyItemChanged(holder.getAdapterPosition());
                } catch (Exception e) {
                    Log.e("PrivacidadAdaptador", "Error al cambiar estado de cookies analíticas: " + e.getMessage());
                }
            }
        });

        holder.swgalletasmarketing.setOnCheckedChangeListener(null);
        holder.swgalletasmarketing.setChecked(privacidad.isCookies_marketing());
        holder.swgalletasmarketing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    privacidad.setCookies_marketing(isChecked);
                    Usuario.getInstance().setPrivacidad(privacidad);
                    notifyItemChanged(holder.getAdapterPosition());
                } catch (Exception e) {
                    Log.e("PrivacidadAdaptador", "Error al cambiar estado de cookies de marketing: " + e.getMessage());
                }
            }
        });

        // Se establece un OnClickListener para el botón enviar_privacidad
        holder.enviar_privacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Intenta realizar la operación de actualización del usuario
                    AdminFirebase.ActualizarUsuario(new FirebaseCallback() {
                        @Override
                        public void onSucceed() {
                            // Si la actualización tiene éxito, se muestra un mensaje de éxito mediante un Toast
                            Toast.makeText(context, "Se actualizó correctamente", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFail(Exception e) {
                            // Si la actualización falla, se muestra un mensaje de error mediante un Toast
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
                } catch (Exception e) {
                    // Captura cualquier excepción que pueda ocurrir durante la actualización del usuario
                    e.printStackTrace(); // Imprime el rastreo de la pila para depuración
                    Toast.makeText(context, "Error al intentar actualizar: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
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
        Switch swubicacion;
        Switch swgalletasanaliticas;
        Switch swgalletasmarketing;
        Switch swnotificaciones;
        Button enviar_privacidad;

        ConstraintLayout cp;
        ConstraintLayout ch;


        public PrivacidadViewHolder(@NonNull View itemView) {
            super(itemView);
            enviar_privacidad = itemView.findViewById(R.id.enviar_privacidad);
            tvUbicacion = itemView.findViewById(R.id.tvubicacion);
            tvNotificaciones = itemView.findViewById(R.id.tvnotificaciones);
            tvGalletasAnaliticas = itemView.findViewById(R.id.tvgalletasanaliticas);
            tvGalletasMarketing = itemView.findViewById(R.id.tvgalletasmarketing);
            swubicacion = itemView.findViewById(R.id.swubicacion);
            swgalletasanaliticas = itemView.findViewById(R.id.swgalletasanaliticas);
            swgalletasmarketing = itemView.findViewById(R.id.swgalletasmarketing);
            swnotificaciones = itemView.findViewById(R.id.swnotificaciones);
            cp = itemView.findViewById(R.id.constrainLayoutPadre);
            ch = itemView.findViewById(R.id.constraintLayoutHijo);
            permisos = itemView.findViewById(R.id.nombreVpn1);
        }


    }
}
