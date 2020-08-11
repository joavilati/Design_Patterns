package com.example.design_patterns.template_method.locadoras;

import androidx.annotation.Nullable;

import com.example.design_patterns.template_method.Carro;

import java.util.Random;

public class Loucarros extends Locadora {
    private double PrecoQueOGerenteMalucoDecidiuColocarComBaseNasVozesDaSuaCabeca = 8000.0;
    private double diasLuaEmSaturno = 50.0;
    private double sorte = -1;

    public Loucarros(Carro carro) {
        super(carro);
    }

    @Override
    protected double getValorFranquiaBase() {
        return PrecoQueOGerenteMalucoDecidiuColocarComBaseNasVozesDaSuaCabeca;
    }

    @Override
    protected double calcularSeguro() {
        return (sorte != -1)? 2 * sorte: 2 * tentarASorte();
    }

    @Override
    protected double getValorKmBase() {
        return diasLuaEmSaturno;
    }

    private double tentarASorte(){
        Random random = new Random();
        sorte = random.nextDouble() * random.nextInt(30);
        return sorte;
    }
}
