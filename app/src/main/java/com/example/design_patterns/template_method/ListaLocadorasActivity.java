package com.example.design_patterns.template_method;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.design_patterns.databinding.ActivityLocadorasBinding;
import com.example.design_patterns.template_method.locadoras.Locadora;
import com.example.design_patterns.template_method.locadoras.Locarro;
import com.example.design_patterns.template_method.locadoras.Loucarros;
import com.example.design_patterns.template_method.locadoras.VrumVrumLocadora;
import com.example.design_patterns.util.Contract;

import java.io.Serializable;
import java.util.ArrayList;

import static com.example.design_patterns.template_method.locadoras.Locadora.TIPO_CARRO;

public class ListaLocadorasActivity extends AppCompatActivity implements Contract {

    public static final String LOCADORA = "com.example.design_patterns.template_method.ListaLocadorasActivity.LOCADORA";
    public static final int CONTRATAR = 41;
    private ActivityLocadorasBinding binding;
    TipoCarro tipoCarro;
    private LocadorasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocadorasBinding.inflate(getLayoutInflater());
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
        adapter = new LocadorasAdapter(locadoras, this);
        binding.rvContratos.setLayoutManager(new LinearLayoutManager(this));
        binding.rvContratos.setAdapter(adapter);
    }

    @Override
    public void startContratActivity(Locadora locadora) {
        Intent intent = new Intent(this, ContratoActivity.class);
        intent.putExtra(LOCADORA, (Serializable) locadora);
        startActivityForResult(intent, CONTRATAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK ) return;
        finish();
    }
}