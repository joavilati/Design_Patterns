package com.example.design_patterns.template_method;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.design_patterns.R;

import static com.example.design_patterns.template_method.locadoras.Locadora.TIPO_CARRO;

public class ContratosActivity extends AppCompatActivity {

    TipoCarro carro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratos);

        Bundle extras = getIntent().getExtras();
        if (extras != null) carro = (TipoCarro) extras.get(TIPO_CARRO);
        System.out.println("ninja: " + carro);
    }
}