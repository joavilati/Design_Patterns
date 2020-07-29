package com.example.design_patterns.strategy.frete;

public class Frete {

    private int tipo;

    public Frete(int tipo) {
        this.tipo = tipo;
    }

    public double calcularPreco(int distancia) {
        double preco = 0;
        if (tipo == TipoFrete.NORMAL) {
            preco = distancia * 1.25 + 10;
        } else if (tipo == TipoFrete.SEDEX) {
            preco = distancia * 1.45 + 12;
        }
        return preco;
    }

}
