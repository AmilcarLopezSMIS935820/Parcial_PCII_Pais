package com.smis935820.parcial_pcii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.smis935820.parcial_pcii.interfaces.paisAPI;
import com.smis935820.parcial_pcii.models.Pais;
import com.smis935820.parcial_pcii.remote.APIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registros extends AppCompatActivity {
    paisAPI paisAPI;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);
        listView = findViewById(R.id.listview);
        paisAPI = APIUtils.getAPI();

        getpais();
    }

    private void getpais() {
        Call<List<Pais>> listCall = paisAPI.getPais();
        listCall.enqueue(new Callback<List<Pais>>() {
            @Override
            public void onResponse(Call<List<Pais>> call, Response<List<Pais>> response) {
                List<Pais> paisList = response.body();
                String[] pais = new String[paisList.size()];


                for (int i=0; i<paisList.size(); i++){
                    pais[i] = paisList.get(i).getNombre();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, pais));
            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {
                Toast.makeText(Registros.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void form(View view){
        Intent i = new Intent(this, formulario.class);
        startActivity(i);

    }
}