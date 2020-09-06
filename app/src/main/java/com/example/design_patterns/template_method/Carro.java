package com.example.design_patterns.template_method;

public class Carro {

    private double multiplicadorValorPorTipo;


    public Carro( double multiplicadorValorPorTipo) {

        this.multiplicadorValorPorTipo = multiplicadorValorPorTipo;
    }

    public double getMultiplicadorValorPorTipo() {
        return multiplicadorValorPorTipo;
    }
}
