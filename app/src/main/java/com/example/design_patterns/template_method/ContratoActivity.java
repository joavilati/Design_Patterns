package com.example.design_patterns.template_method;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.design_patterns.databinding.ActivityContratoBinding;
import com.example.design_patterns.template_method.locadoras.Locadora;

import java.text.NumberFormat;
import java.util.Locale;

import static com.example.design_patterns.template_method.ListaLocadorasActivity.LOCADORA;

public class ContratoActivity extends AppCompatActivity {

    ActivityContratoBinding binding;
    private Locadora locadora;
    private Boolean franquia = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContratoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        if (extras != null) locadora = (Locadora) extras.get(LOCADORA);
        bind();
        registerClickEvents();
        setValor(0);
    }

    private void registerClickEvents() {

        binding.etDias.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    criaContrato();
                }
            }
        });

        binding.cbSeguro.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                locadora.inserirSeguro(cb.isChecked());
                franquia = cb.isChecked();
            }
        });

        binding.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaContrato();
            }
        });

        binding.btnContratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criaContrato();
                sucesso();
            }
        });
    }

    private void sucesso() {
        new AlertDialog.Builder(this).setTitle(locadora.getAgradecimento()).show();
        Toast.makeText(this, "Tudo certo!", Toast.LENGTH_SHORT).show();
    }

    private void criaContrato() {
        int dias;
        if ( binding.etDias.getText() != null ) {
           try {
               dias = Integer.parseInt(binding.etDias.getText().toString());
               binding.btnContratar.setEnabled(true);
           } catch (NumberFormatException e) {
               dias = 0;
               Toast.makeText(this, "Insira um valor valido para os dias",Toast.LENGTH_SHORT).show();
           }
        } else {
            dias = 0;
            binding.btnContratar.setEnabled(false);
        }
        locadora.criarContrato(dias);
        setValor(locadora.getValorTotal());
    }

    private void setValor(double valor) {
        Locale ptBr = new Locale("pt", "BR");
        if(franquia) {
            String valorFranquiaString = NumberFormat.getCurrencyInstance(ptBr).format(locadora.getFranquia());
            binding.tvFranquia.setText("Franquia " + valorFranquiaString);
        } else binding.tvFranquia.setText("");
        String valorTotalString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
        binding.tvValorTotal.setText(valorTotalString);
    }

    private void bind() {
        binding.btnContratar.setEnabled(false);
        binding.tvTituloLocadora.setText(locadora.getName());
    }
}