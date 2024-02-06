package es.eney_x.eney_x.vista;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.eney_x.eney_x.R;
import es.eney_x.eney_x.controlador.AdminFirebase;
import es.eney_x.eney_x.controlador.FirebaseCallback;
import es.eney_x.eney_x.modelo.Usuario;

public class Activity_register extends AppCompatActivity implements FirebaseCallback {

    protected Button go_to_login;
    protected Button register_user;
    protected EditText nombre;
    protected EditText apellidos;
    protected EditText correo;
    protected EditText fechaNacimiento;
    protected EditText contrasena;
    protected TextView error;

    /**
     * Método llamado cuando se crea la actividad.
     * Configura los elementos de la interfaz de usuario y establece los listeners necesarios.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        go_to_login = findViewById(R.id.BttonGoToIniciarSesion);
        register_user = findViewById(R.id.BttonRegisterMe);

        nombre = findViewById(R.id.EtNombre);
        apellidos = findViewById(R.id.EtApellidos);
        correo = findViewById(R.id.EtMail);
        fechaNacimiento = findViewById(R.id.EtNacimiento);
        contrasena = findViewById(R.id.EtPassw);
        error = findViewById(R.id.TvError);
        error.setVisibility(View.GONE);

        try {
            // Configuración del listener para el botón de ir a iniciar sesión.
            go_to_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent;
                    try {
                        intent = new Intent(Activity_register.this, Activity_login.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            // Configuración del listener para el botón de registro de usuario.
            register_user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Usuario usuario;

                    try {
                        if (nombre.getText().toString().isEmpty() || apellidos.getText().toString().isEmpty() || fechaNacimiento.getText().toString().isEmpty() || correo.getText().toString().isEmpty() || contrasena.getText().toString().isEmpty()) {
                            error.setText("Tienes que rellenar todos los campos");
                            error.setVisibility(View.VISIBLE);
                            register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                            register_user.setClickable(false);
                        } else {
                            usuario = Usuario.getInstance();
                            usuario.setCorreo(correo.getText().toString());
                            usuario.setNombre(nombre.getText().toString());
                            usuario.setApellidos(apellidos.getText().toString());
                            usuario.setFecha_nacimiento(fechaNacimiento.getText().toString());
                            usuario.setPassword(contrasena.getText().toString());
                            RegistrarUsuario();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            // Configuración de listeners para validar la entrada del usuario en los campos de texto.
            nombre.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    //No hace falta implementarlo
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String nombreTexto;

                    try {
                        nombreTexto = s.toString();
                        if (nombreTexto.length() <= 0) {
                            register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                            register_user.setClickable(false);
                            nombre.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                            nombre.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        } else {
                            register_user.setBackgroundColor(getResources().getColor(R.color.botonMorado, getTheme()));
                            register_user.setClickable(true);
                            nombre.setBackground(getDrawable(R.drawable.edit_text_boder_green));
                            nombre.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    //No hace falta implementarlo
                }
            });
            // Configuración de listeners para validar la entrada del usuario en los campos de texto.
            apellidos.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    //No hace falta implementarlo
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String apellidosTexto;

                    try {
                        apellidosTexto = s.toString();
                        if (apellidosTexto.length() <= 0) {
                            register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                            register_user.setClickable(false);
                            apellidos.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                            apellidos.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        } else {
                            register_user.setBackgroundColor(getResources().getColor(R.color.botonMorado, getTheme()));
                            register_user.setClickable(true);
                            apellidos.setBackground(getDrawable(R.drawable.edit_text_boder_green));
                            apellidos.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    //No hace falta implementarlo
                }
            });

            // Configuración de listeners para validar la entrada del usuario en los campos de texto.
            fechaNacimiento.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    //No hace falta implementarlo
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String fechaNacimientoTexto;

                    try {
                        fechaNacimientoTexto = s.toString();
                        if (fechaNacimientoTexto.length() <= 0) {
                            register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                            register_user.setClickable(false);
                            fechaNacimiento.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                            fechaNacimiento.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        } else {
                            register_user.setBackgroundColor(getResources().getColor(R.color.botonMorado, getTheme()));
                            register_user.setClickable(true);
                            fechaNacimiento.setBackground(getDrawable(R.drawable.edit_text_boder_green));
                            fechaNacimiento.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    //No hace falta implementarlo
                }
            });

            // Configuración de listeners para validar la entrada del usuario en los campos de texto.

            correo.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    //No hace falta implementarlo
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String correoTexto;

                    try {
                        correoTexto = s.toString();
                        if (correoTexto.length() <= 0) {
                            register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                            register_user.setClickable(false);
                            correo.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                            correo.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        } else {
                            register_user.setBackgroundColor(getResources().getColor(R.color.botonMorado, getTheme()));
                            register_user.setClickable(true);
                            correo.setBackground(getDrawable(R.drawable.edit_text_boder_green));
                            correo.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    //No hace falta implementarlo
                }
            });

            // Configuración de listeners para validar la entrada del usuario en los campos de texto.

            contrasena.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    //No hace falta implementarlo
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String contrasenaTexto;
                    Pattern mayuscula;
                    Pattern minuscula;
                    Pattern numero;
                    Pattern simbolo;

                    Matcher mayusculaMatcher;
                    Matcher minusculaMatcher;
                    Matcher numeroMatcher;
                    Matcher simboloMatcher;

                    try {

                        contrasenaTexto = s.toString();
                        if (contrasenaTexto.length() > 0) {
                            mayuscula = Pattern.compile("[A-Z]");
                            minuscula = Pattern.compile("[a-z]");
                            numero = Pattern.compile("[0-9]");
                            simbolo = Pattern.compile("[!\\?*/\\-@#\\|]");

                            mayusculaMatcher = mayuscula.matcher(contrasenaTexto);
                            minusculaMatcher = minuscula.matcher(contrasenaTexto);
                            numeroMatcher = numero.matcher(contrasenaTexto);
                            simboloMatcher = simbolo.matcher(contrasenaTexto);

                            if (contrasenaTexto.length() < 8) {
                                error.setText("La contraseña debe contener al menos 8 caracteres");
                                error.setVisibility(View.VISIBLE);
                                register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                                register_user.setClickable(false);
                                contrasena.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                                contrasena.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                            } else if (!mayusculaMatcher.find()) {
                                error.setText("La contraseña debe contener al menos una letra mayúscula");
                                error.setVisibility(View.VISIBLE);
                                register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                                register_user.setClickable(false);
                                contrasena.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                                contrasena.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                            } else if (!minusculaMatcher.find()) {
                                error.setText("La contraseña debe contener al menos una letra minúscula");
                                error.setVisibility(View.VISIBLE);
                                register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                                register_user.setClickable(false);
                                contrasena.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                                contrasena.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                            } else if (!numeroMatcher.find()) {
                                error.setText("La contraseña debe contener al menos un número");
                                error.setVisibility(View.VISIBLE);
                                register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                                register_user.setClickable(false);
                                contrasena.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                                contrasena.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                            } else if (!simboloMatcher.find()) {
                                error.setText("La contraseña debe contener al menos un símbolo (!?*/-@#|)");
                                error.setVisibility(View.VISIBLE);
                                register_user.setBackgroundColor(Color.rgb(217, 17, 37));
                                register_user.setClickable(false);
                                contrasena.setBackground(getDrawable(R.drawable.edit_text_boder_red));
                                contrasena.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                            } else {
                                error.setVisibility(View.GONE);
                                register_user.setBackgroundColor(getResources().getColor(R.color.botonMorado, getTheme()));
                                register_user.setClickable(true);
                                contrasena.setBackground(getDrawable(R.drawable.edit_text_boder_green));
                                contrasena.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    //No hace falta implementarlo
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para llevar a cabo el registro del usuario.
     * Se encarga de comprobar la existencia del usuario y realizar el registro.
     */
    public void RegistrarUsuario() {
        try {
            AdminFirebase.ComprobarExistenciaUsuario(this);
            register_user.setText("Registrando Usuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implementación de métodos de la interfaz FirebaseCallback

    @Override
    public void onSucceed() {
        error.setText("Ya existe una cuenta con ese correo!");
        error.setVisibility(View.VISIBLE);
        register_user.setBackgroundColor(Color.rgb(217, 17, 37));
        register_user.setText("Registrarse");
        correo.setBackground(getDrawable(R.drawable.edit_text_boder_red));
        correo.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public void onFail(Exception e) {
        //No hace falta implementarlo
    }

    @Override
    public void onRecover() {
        //No hace falta implementarlo
    }

    @Override
    public void onNotFound() {
        try {
            AdminFirebase.AltaUsuario(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRegister() {
        try {
            Intent intent = new Intent(Activity_register.this, Activity_checkin.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}