package com.codepatrick.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTel;
    private TextView tvEmail;
    private TextView tvFecha;
    private TextView tvDescri;

    private  String nombre;
    private String tel;
    private String email;
    private  long fecha;
    private  String descri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofirmar_datos);
        this.capturoBoton();

        Bundle parametros = this.getIntent().getExtras();
        nombre = parametros.getString(String.valueOf(R.string.pNombre));
        tel = parametros.getString(String.valueOf(R.string.pTel));
        email = parametros.getString(String.valueOf(R.string.pEmail));
        fecha = parametros.getLong(String.valueOf(R.string.pFecha));
        descri = parametros.getString(String.valueOf(R.string.pDescri));

        Date date=new Date(fecha);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        String dateText = df2.format(date);

        tvNombre = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        tvEmail = findViewById(R.id.tvEmail);
        tvFecha = findViewById(R.id.tvNacim);
        tvDescri = findViewById(R.id.tvDescri);

        tvNombre.setText(nombre);
        tvTel.setText("Tel: "+tel);
        tvEmail.setText("Email: "+email);
        tvFecha.setText("Fecha de Nacimiento: "+dateText);
        tvDescri.setText("Descripción: "+descri);
    }

    private void capturoBoton(){
        Button btn = findViewById(R.id.tvBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(String.valueOf(R.string.pNombre),nombre);
                intent.putExtra(String.valueOf(R.string.pTel),tel);
                intent.putExtra(String.valueOf(R.string.pEmail),email);
                intent.putExtra(String.valueOf(R.string.pFecha),fecha);
                intent.putExtra(String.valueOf(R.string.pDescri),descri);

                startActivity(intent);
                finish();
            }
        });


    }
}