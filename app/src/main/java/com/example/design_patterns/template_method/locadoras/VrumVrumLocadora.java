package com.example.design_patterns.template_method.locadoras;

import com.example.design_patterns.template_method.Carro;

public class VrumVrumLocadora extends  Locadora{

    private double manutencao = 15;
    private double lucro = 10;
    private double impostos = 5;
    private double comissaoCorretor = 2.5;

    public VrumVrumLocadora(Carro carro) {
        super(carro);
    }

    @Override
    protected double getValorFranquiaBase() {
        return 1500.0;
    }

    @Override
    protected double calcularSeguro() {
        return 10.0 * getCarro().getMultiplicadorValorPorTipo() + comissaoCorretor;
    }

    @Override
    protected double getValorKmBase() {
        return manutencao + impostos + lucro;
    }

    @Override
    public String getName() {
        return "VrumVrumLocadora";
    }
}
