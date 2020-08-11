package com.example.design_patterns.strategy.frete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.design_patterns.R;

public class FreteActivity extends AppCompatActivity {

    private FreteViewHolder holder;
    private FreteComStrategy frete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frete_acitivy);
        holder = new FreteViewHolder();
        clicksDosBotoes();
    }

    private void clicksDosBotoes() {
        // Declarando os listeners do click dos botões

        holder.btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frete = new FreteComStrategy(new Normal());
                inserirValorFinal();
            }
        });

        holder.btnSedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frete = new FreteComStrategy(new Sedex());
                inserirValorFinal();
            }
        });
    }

    private void inserirValorFinal() {

        // Pegando o valor de distancia digitado
        int distancia = Integer.parseInt(holder.etDistancia.getText().toString());

        // Pegando o valor final e passando para tipo String
        String valorFinal = String.valueOf(frete.calcularPreco(distancia));

        // Inserindo o valor final na View(elemento) de Valor Final
        holder.tvValotFinal.setText(valorFinal) ;
    }

    class FreteViewHolder {
        // Pegando as Views(Elementos) no xml e criando elas no codigo.
        private Button btnSedex = findViewById(R.id.btn_sedex);
        private Button btnNormal = findViewById(R.id.btn_normal);
        private EditText etDistancia = findViewById(R.id.et_distancia);
        private TextView tvValotFinal = findViewById(R.id.tv_resuldado);
    }
}