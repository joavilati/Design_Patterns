package com.example.design_patterns.strategy.frete;

public interface TipoFreteStrategy {
    public double calcularPreco(double distancia);
}

class Normal implements TipoFreteStrategy {

    @Override
    public double calcularPreco(double distancia) {
        return distancia * 1.25 + 10;
    }
}

class Sedex implements TipoFreteStrategy {

    @Override
    public double calcularPreco(double distancia) {
        return distancia * 1.45 + 12;
    }
}
