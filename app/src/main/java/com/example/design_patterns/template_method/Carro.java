package com.example.design_patterns.template_method;

import java.io.Serializable;

public class Carro implements Serializable {

    private double multiplicadorValorPorTipo;


    public Carro( double multiplicadorValorPorTipo) {

        this.multiplicadorValorPorTipo = multiplicadorValorPorTipo;
    }

    public double getMultiplicadorValorPorTipo() {
        return multiplicadorValorPorTipo;
    }
}
