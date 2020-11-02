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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTel;
    private TextView tvEmail;
    private DatePicker tvFecha;
    private TextView tvDescri;

    private  String nombre;
    private String tel;
    private String email;
    private  long fecha;
    private  String descri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.capturoBoton();

        Bundle parametros = this.getIntent().getExtras();
        if(parametros!=null) {
            nombre = parametros.getString(String.valueOf(R.string.pNombre));
            tel = parametros.getString(String.valueOf(R.string.pTel));
            email = parametros.getString(String.valueOf(R.string.pEmail));
            fecha = parametros.getLong(String.valueOf(R.string.pFecha));
            descri = parametros.getString(String.valueOf(R.string.pDescri));

            Date date = new Date(fecha);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int año = cal.get(Calendar.YEAR);
            int mes = cal.get(Calendar.MONTH);
            int dia = cal.get(Calendar.DAY_OF_MONTH);

            tvNombre = findViewById(R.id.editNombre);
            tvTel = findViewById(R.id.editTel);
            tvEmail = findViewById(R.id.editEmail);
            tvFecha = findViewById(R.id.editFecha);
            tvDescri = findViewById(R.id.editDesc);

            tvNombre.setText(nombre);
            tvTel.setText(tel);
            tvEmail.setText(email);
            tvFecha.updateDate(año, mes, dia);
            tvDescri.setText(descri);
        }
    }

    private void capturoBoton(){
        Button btn = findViewById(R.id.tvBoton);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);


                EditText edit = (EditText) findViewById(R.id.editNombre); ;
                String nombre = edit.getText().toString();
                intent.putExtra(String.valueOf(R.string.pNombre),nombre);

                edit = (EditText) findViewById(R.id.editTel); ;
                String num = edit.getText().toString();
                intent.putExtra(String.valueOf(R.string.pTel),num);

                edit = (EditText) findViewById(R.id.editEmail); ;
                String email = edit.getText().toString();
                intent.putExtra(String.valueOf(R.string.pEmail),email);





                DatePicker datePicker =  findViewById(R.id.editFecha);
                Calendar calendar = new GregorianCalendar(datePicker.getYear(),
                        datePicker.getMonth(),
                        datePicker.getDayOfMonth());

                  long time = calendar.getTimeInMillis();


                intent.putExtra(String.valueOf(R.string.pFecha),time);

                edit = (EditText) findViewById(R.id.editDesc); ;
                String desc = edit.getText().toString();
                intent.putExtra(String.valueOf(R.string.pDescri),desc);


                startActivity(intent);
                finish();
            }
        });


    }
}