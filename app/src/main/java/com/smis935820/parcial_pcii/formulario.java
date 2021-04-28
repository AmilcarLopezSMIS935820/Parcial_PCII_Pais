package com.smis935820.parcial_pcii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smis935820.parcial_pcii.interfaces.paisAPI;

public class formulario extends AppCompatActivity {
    EditText etid, etname, etdescripcion;
    TextView tvResponse;
    Button btnsave, btnedit;

    private paisAPI paisAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        etid = findViewById(R.id.et_id);
        etname = findViewById(R.id.et_name);
        etdescripcion = findViewById(R.id.et_descripcion);
        btnsave = findViewById(R.id.btnsave);
        btnedit = findViewById(R.id.btnedit);
        tvResponse = findViewById(R.id.tvResponse);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etname.getText().toString().trim().isEmpty() && etdescripcion.getText().toString().trim().isEmpty() && etid.getText().toString().trim().isEmpty()){
                    Toast.makeText(formulario.this, "Los campos no deben quedar vacios", Toast.LENGTH_SHORT).show();
                    return;

                    //Llamado al metodo POST
                }
            }
        });
    }
}