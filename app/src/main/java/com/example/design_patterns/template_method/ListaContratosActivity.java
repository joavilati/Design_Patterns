package com.example.design_patterns.template_method;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.design_patterns.databinding.ActivityContratosBinding;
import com.example.design_patterns.template_method.locadoras.Locadora;
import com.example.design_patterns.template_method.locadoras.Locarro;
import com.example.design_patterns.template_method.locadoras.Loucarros;
import com.example.design_patterns.template_method.locadoras.VrumVrumLocadora;

import java.util.ArrayList;

import static com.example.design_patterns.template_method.locadoras.Locadora.TIPO_CARRO;

public class ListaContratosActivity extends AppCompatActivity {

    private ActivityContratosBinding binding;
    TipoCarro tipoCarro;
    private ContratosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContratosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        if (extras != null) tipoCarro = (TipoCarro) extras.get(TIPO_CARRO);

        configRecycler();
    }

    private void configRecycler() {
        Carro carro = tipoCarro.carroBuilder();
        ArrayList<Locadora> locadoras = new ArrayList<Locadora>();
        locadoras.add(new Locarro(carro));
        locadoras.add(new Loucarros(carro));
        locadoras.add(new VrumVrumLocadora(carro));
        adapter = new ContratosAdapter(locadoras);
        binding.rvContratos.setLayoutManager(new LinearLayoutManager(this));
        binding.rvContratos.setAdapter(adapter);
    }
}