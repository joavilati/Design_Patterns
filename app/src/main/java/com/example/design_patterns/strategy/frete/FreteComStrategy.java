package com.example.design_patterns.strategy.frete;

public class FreteComStrategy {

    private TipoFreteStrategy tipoFrete;

    public FreteComStrategy(TipoFreteStrategy tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public double calcularFrete(int distancia) {
        return tipoFrete.calcularPreco(distancia);
    }

}
