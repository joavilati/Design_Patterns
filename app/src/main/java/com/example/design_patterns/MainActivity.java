package com.example.design_patterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.design_patterns.strategy.frete.FreteActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnStrategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStrategy = findViewById(R.id.btn_strategy);
        btnStrategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaFrete();
            }
        });

    }
    private void irParaFrete(){
        startActivity(new Intent(this, FreteActivity.class));
    }
}