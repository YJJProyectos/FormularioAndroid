package com.android.jyang.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SaludoActivity extends AppCompatActivity {

    private String nombre;
    private int edad = 18;
    private static int SALUDO = 1;
    private static int DESPEDIDA = 2;
    private SeekBar seekBar;
    private TextView anio;
    private RadioGroup radioGroup;
    private Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Tipo de Saludo");
        Bundle bundle = getIntent().getExtras();
        nombre =bundle.getString("nombre");
        anio = (TextView) findViewById(R.id.anio);
        Toast.makeText(this, "Nombre : " + nombre, Toast.LENGTH_LONG).show();
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        anio.setText(edad + "");
        seekBar.setProgress(edad);
        siguiente = (Button) findViewById(R.id.fin);
        siguiente.setVisibility(View.VISIBLE);
        radioGroup = (RadioGroup) findViewById(R.id.opciones);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                edad = progress;
                anio.setText(edad + "");
                if ( edad < 18 ) {
                    siguiente.setVisibility(View.INVISIBLE);

                } else if ( edad > 60 ) {
                    siguiente.setVisibility(View.INVISIBLE);
                } else {
                    siguiente.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if ( edad < 18 ) {
                    siguiente.setVisibility(View.INVISIBLE);
                    Toast.makeText(SaludoActivity.this, "Edad no puede ser menor que 18 ", Toast.LENGTH_SHORT).show();
                } else if ( edad > 60 ) {
                    siguiente.setVisibility(View.INVISIBLE);
                    Toast.makeText(SaludoActivity.this, "Edad no puede ser mayor que 60", Toast.LENGTH_SHORT).show();
                } else {
                    siguiente.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    public void irASaludo(View view) {
        Intent intentFin = new Intent(this, FinActivity.class);
        RadioButton opcionSeleccionado = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String seleccionado = opcionSeleccionado.getText().toString();
        intentFin.putExtra("edad", Integer.toString(edad));
        intentFin.putExtra("nombre", nombre);
        intentFin.putExtra("opcion", seleccionado);
        startActivity(intentFin);
    }
}
