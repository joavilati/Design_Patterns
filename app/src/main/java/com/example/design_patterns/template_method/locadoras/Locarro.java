package com.example.design_patterns.template_method.locadoras;

import com.example.design_patterns.template_method.Carro;

import java.io.Serializable;

public class Locarro extends Locadora  implements Serializable {

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

    @Override
    public String getName() {
        return "Locarros";
    }

    @Override
    public String getDescricao() {
        return "Encontre aqui os melhores preços para alugueis de carro.";
    }

    @Override
    public String getAgradecimento() {
        return "Obrigado por Escolher a Locarros, aproveite sua viagem!";
    }

    private double descontar() {
        return (descontavel)? desconto : 1;
    }
}
