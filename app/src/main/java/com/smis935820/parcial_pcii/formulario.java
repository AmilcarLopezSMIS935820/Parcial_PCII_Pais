package com.smis935820.parcial_pcii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smis935820.parcial_pcii.interfaces.paisAPI;
import com.smis935820.parcial_pcii.models.Pais;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class formulario extends AppCompatActivity {
    EditText etid, etname, etdescripcion;
    TextView tvResponse;
    Button btnsave, btnedit, btdelete;

    private paisAPI paisAPI;
    private GsonConverterFactory GsonConverterFactory;
    public Retrofit Retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        etid = findViewById(R.id.et_id);
        etname = findViewById(R.id.et_name);
        etdescripcion = findViewById(R.id.et_descripcion);
        btnsave = findViewById(R.id.btnsave);
        btnedit = findViewById(R.id.btnedit);
        btdelete = findViewById(R.id.btdelete);
        tvResponse = findViewById(R.id.tvResponse);







        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etname.getText().toString().trim().isEmpty() && etdescripcion.getText().toString().trim().isEmpty() && etid.getText().toString().trim().isEmpty()){
                    Toast.makeText(formulario.this, "Los campos no deben quedar vacios", Toast.LENGTH_SHORT).show();
                    return;

                    //Llamado al metodo

                }
                savePais(etname.getText().toString(), etdescripcion.getText().toString());

            }
        });

        //actualizar
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPais(etid.getText().toString(),etname.getText().toString(), etdescripcion.getText().toString());

            }
        });

        //delete
        btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            deletePais(etid.getText().toString(), etname.getText().toString(), etdescripcion.getText().toString());
            }
        });
    }


    public void savePais(String nombre, String descripcion){
        //llamando interfaz
        Pais pais = new Pais(nombre, descripcion);
        paisAPI.savePais(pais).enqueue(new Callback<Pais>() {
            @Override
            public void onResponse(Call<Pais> call, Response<Pais> response) {
                Pais responsePais = response.body();
                String responseString = "Response code: " + response.code() +
                        "\nData: "+ pais.toString();

                //mostrar respuesta
                showResponse(responseString.toString());

            }

            @Override
            public void onFailure(Call<Pais> call, Throwable t) {
                showResponse(t.getMessage());

            }
        });

    }
    public void editPais(String id, String nombre, String descripcion){
        //llamando interfaz
        Pais pais = new Pais(nombre, descripcion);
        paisAPI.updatePais(pais).enqueue(new Callback<Pais>() {
            @Override
            public void onResponse(Call<Pais> call, Response<Pais> response) {
                Pais responsePais = response.body();
                String responseString = "Response code: " + response.code() +
                        "\nData: "+ pais.toString();

                //mostrar respuesta
                showResponse(responseString.toString());

            }

            @Override
            public void onFailure(Call<Pais> call, Throwable t) {
                showResponse(t.getMessage());

            }
        });



    }
    // hacer visible el textview-tvResponse
    public void showResponse(String response){
        if (tvResponse.getVisibility()==View.GONE){
            tvResponse.setVisibility(View.VISIBLE);
        }
        tvResponse.setText(response);
    }

    public void deletePais(String id, String nombre, String descripcion){
        Pais pais = new Pais(id,nombre, descripcion );
        paisAPI.updatePais(pais).enqueue(new Callback<Pais>() {
            @Override
            public void onResponse(Call<Pais> call, Response<Pais> response) {
                Pais responsePais = response.body();
                String responseString = "Response code: " + response.code() +
                        "\nData: "+ pais.toString();

                //mostrar respuesta
                showResponse(responseString.toString());

            }

            @Override
            public void onFailure(Call<Pais> call, Throwable t) {
                showResponse(t.getMessage());

            }
        });
    }

    public void v1(View view){
        Intent i = new Intent(this, Registros.class);
        startActivity(i);
        finish();
    }

    public void v2(View view){
        Intent a = new Intent(this, Busqueda.class);
        startActivity(a);
        finish();
    }
}