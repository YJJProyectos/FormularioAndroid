package com.android.jyang.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class FinActivity extends AppCompatActivity {

    private ImageButton compartirBoton;
    String nombre;
    String edad;
    String opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        getSupportActionBar().setTitle("Saludo Fin");
        compartirBoton = (ImageButton) findViewById(R.id.compartir);
        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("nombre");
        edad = bundle.getString("edad");
        opcion = bundle.getString("opcion");
        Toast.makeText(this, "Nombre: " + nombre + " edad: " + edad + " eligio: " + opcion , Toast.LENGTH_LONG).show();
    }


    public void compartirEnRedes(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, " Nombre: " + nombre + " Edad " + edad);
        startActivity(intent);
    }

}
