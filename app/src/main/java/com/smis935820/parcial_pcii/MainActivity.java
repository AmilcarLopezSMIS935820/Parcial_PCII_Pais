package com.smis935820.parcial_pcii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btmain = findViewById(R.id.button);
        btmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Registros.class);
            }
        });
    }

    public void ini(View view){
        Intent i = new Intent(MainActivity.this, formulario.class);
        startActivity(i);
        finish();




    }
}