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

public class Busqueda extends AppCompatActivity {
    EditText edtId;
    TextView tvNombre, tvDescripcion;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        edtId = findViewById(R.id.edtId);
        tvNombre = findViewById(R.id.tvName);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find(edtId.getText().toString().trim());
            }
        });
    }

    private void find(String cod){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://127.0.0.1/").addConverterFactory(GsonConverterFactory.create()).build();
    ///cambiar la url por la de nuestro equipo
        paisAPI paisAPI = retrofit.create(paisAPI.class);

        Call<Pais> call = paisAPI.find(cod);
        call.enqueue(new Callback<Pais>() {
            @Override
            public void onResponse(Call<Pais> call, Response<Pais> response) {
                try {
                    if (response.isSuccessful()){
                        Pais pais = response.body();
                        tvNombre.setText(pais.getNombre());
                        tvDescripcion.setText(pais.getDescripcion());

                    }
                } catch (Exception ex){
                    Toast.makeText(Busqueda.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pais> call, Throwable t) {

            }
        });
    }

    public void vi(View view){
        Intent i = new Intent(this, Registros.class);
        startActivity(i);
        finish();
    }
}