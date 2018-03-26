package com.android.jyang.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText textoNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_spider);
        getSupportActionBar().setTitle("Inicio");
    }

    public void pasarSaludo(View view) {
        textoNombre = (EditText) findViewById(R.id.nombre);
        String nombre = textoNombre.getText().toString();
        if ( nombre != null && !nombre.isEmpty()) {
//            Toast.makeText(this, "Continuar", Toast.LENGTH_LONG).show();
            Intent intentSaludo = new Intent(this, SaludoActivity.class);
            intentSaludo.putExtra("nombre", nombre);
            startActivity(intentSaludo);
        } else {
            Toast.makeText(this, "Ingrese un nombre para poder continuar", Toast.LENGTH_LONG).show();
        }
    }
}
