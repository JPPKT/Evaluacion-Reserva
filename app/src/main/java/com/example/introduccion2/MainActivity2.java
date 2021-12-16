package com.example.introduccion2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private TextView nomCompleto;

    private int hora,minuto;

    private TextView textoHora;


    private TextView tipoCancha;
    private DatePicker calendario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tipoCancha =findViewById(R.id.tipoCancha);
////////////////////

        calendario= findViewById(R.id.calendario);
        textoHora = findViewById(R.id.etiquetaHora);

/////////////////////////////////////////
        nomCompleto = findViewById(R.id.nomCompleto);

        String nombre = getIntent().getStringExtra( "nombre");
        String apellido = getIntent().getStringExtra( "apellido");

        nomCompleto.setText(nombre+ " "+nombre);

    }

    public void seleccionarHora(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaSeleccionada, int minutoSeleccionado) {
                hora = horaSeleccionada;
                minuto = minutoSeleccionado;

                if(hora>12){
                    textoHora.setText((hora-12)+":"+minuto+" PM");
                }else{

                    textoHora.setText(hora+":"+minuto+" AM");
                }
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener,hora,minuto, false);
        timePickerDialog.show();

    }

    public void hacerReserva(View view){

        String Cancha =tipoCancha.getText().toString();
        String dia = calendario.getDayOfMonth()+"-"+(calendario.getMonth()+1)+"-"+calendario.getYear();
        String hora =textoHora.getText().toString();

        Toast.makeText(this, calendario.getDayOfMonth()+"-"+(calendario.getMonth()+1)+"-"+calendario.getYear(),Toast.LENGTH_SHORT).show();



        /*Toast.makeText(this,"Reservaste :"+Cancha+" el dia "+dia+" a las  "+hora+"", Toast.LENGTH_LONG).show();*/
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Reservación")
                .setMessage("Reservaste :"+Cancha+" el dia "+dia+" a las  "+hora+"")
                .setCancelable(true)

                .setPositiveButton("Cerar App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })

                .setNegativeButton("Re-Agendar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .create()
                .show();

    }







}