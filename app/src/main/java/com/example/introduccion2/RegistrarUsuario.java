package com.example.introduccion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity {

    private TextView entradaNombre;
    private TextView entradaApellido;
    private TextView entradaContraseña;

    private Contacto contactoNuevo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        entradaNombre=findViewById(R.id.entradaNombre);
        entradaApellido=findViewById(R.id.entradaApellido);



    }

    public void Envioformulario(View view){

        String nombr =entradaNombre.getText().toString();
        String apellid =entradaApellido.getText().toString();


        if (nombr.equals("")|| apellid.equals("")){
            Toast.makeText(this, "Complete la totalidad de campos ",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Bienvenido "+nombr+ " "+apellid,Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("nombre",""+nombr);
            intent.putExtra("apellido",""+apellid);


            startActivity(intent);


        }



    }






}