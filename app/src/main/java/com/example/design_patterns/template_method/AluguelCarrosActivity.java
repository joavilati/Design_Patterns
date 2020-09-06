package com.example.design_patterns.template_method;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.design_patterns.R;

import static com.example.design_patterns.template_method.locadoras.Locadora.TIPO_CARRO;

public class AluguelCarrosActivity extends AppCompatActivity {

    CarrosViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluguel_carros);
        viewHolder = new CarrosViewHolder();
        registerClickListeners();
    }

    private void registerClickListeners() {
        viewHolder.popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContratActivity(TipoCarro.POPULAR);
            }


        });
        viewHolder.esporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContratActivity(TipoCarro.ESPORTE);
            }
        });
        viewHolder.suv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContratActivity(TipoCarro.SUV);
            }
        });
    }

    private void goToContratActivity(TipoCarro tipo) {
        Intent intent = new Intent(this, ListaLocadorasActivity.class);
        intent.putExtra(TIPO_CARRO, tipo);
        startActivity(intent);
    }

    class CarrosViewHolder {
        CardView popular = findViewById(R.id.cv_popular);
        CardView esporte = findViewById(R.id.cv_esporte);
        CardView suv = findViewById(R.id.cv_suv);
    }
}