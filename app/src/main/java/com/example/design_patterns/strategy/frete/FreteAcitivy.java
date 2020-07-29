package com.example.design_patterns.strategy.frete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.design_patterns.R;

public class FreteAcitivy extends AppCompatActivity {

    private FreteViewHolder holder;

    private Frete frete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frete_acitivy);
        holder  = new FreteViewHolder();
        clicksDosBotoes();
    }

    private void clicksDosBotoes() {

        holder.btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frete = new Frete(TipoFrete.NORMAL);
                inserirValorFinal();
            }
        });

        holder.btnSedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frete = new Frete(TipoFrete.SEDEX);
                inserirValorFinal();
            }
        });
    }

    private void inserirValorFinal() {
        int distancia = Integer.parseInt(holder.etDistancia.getText().toString());
        String valorFinal = String.valueOf(frete.calcularPreco(distancia));
        holder.tvValotFinal.setText(valorFinal) ;
    }

    class FreteViewHolder {
        private Button btnSedex = findViewById(R.id.btn_sedex);
        private Button btnNormal = findViewById(R.id.btn_normal);
        private EditText etDistancia = findViewById(R.id.et_distancia);
        private TextView tvValotFinal = findViewById(R.id.tv_label_valor_final);
    }
}