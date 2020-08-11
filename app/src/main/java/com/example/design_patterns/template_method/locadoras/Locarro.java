package com.example.design_patterns.template_method.locadoras;

import com.example.design_patterns.template_method.Carro;

public class Locarro extends Locadora {

    private boolean descontavel = true;
    private double desconto = 0.8;
    public Locarro(Carro carro) {
        super(carro);
    }

    @Override
    protected double getValorFranquiaBase() {
        return 2000.0;
    }

    @Override
    protected double calcularSeguro() {
        return 8 * getCarro().getMultiplicadorValorPorTipo();
    }

    @Override
    protected double getValorKmBase() {
        return 13.0 * descontar();
    }

    private double descontar() {
        return (descontavel)? desconto : 1;
    }
}