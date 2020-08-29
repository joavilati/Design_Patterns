package com.example.design_patterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.design_patterns.strategy.frete.FreteActivity;
import com.example.design_patterns.template_method.AluguelCarrosActivity;

public class MainActivity extends AppCompatActivity {

    private PatternsViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewHolder = new PatternsViewHolder();
        registerClickListeners();
    }
    public void registerClickListeners() {
        viewHolder.btnStrategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaPattern(FreteActivity.class);
            }
        });

        viewHolder.btnTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaPattern(AluguelCarrosActivity.class);
            }
        });
    }

    private void irParaPattern(Class<?> classe){
        startActivity(new Intent(this, classe));
    }

    class PatternsViewHolder {
        Button btnStrategy = findViewById(R.id.btn_strategy);
        Button btnTemplate = findViewById(R.id.btn_template);
    }
}