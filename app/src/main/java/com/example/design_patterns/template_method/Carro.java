package com.example.design_patterns.template_method;

public class Carro {

    private double multiplicadorValorPorTipo;
    private double valorKm;
    private double franquia;


    public Carro( double multiplicadorValorPorTipo) {

        this.multiplicadorValorPorTipo = multiplicadorValorPorTipo;
    }

    public double getValorKm() {
        return valorKm;
    }

    public double getFranquia() {
        return franquia;
    }

    public void setValorKm(double valorKm) {
        this.valorKm = valorKm;
    }

    public void setFranquia(double franquia) {
        this.franquia = franquia;
    }

    public double getMultiplicadorValorPorTipo() {
        return multiplicadorValorPorTipo;
    }

    public void setMultiplicadorValorPorTipo(double multiplicadorValorPorTipo) {
        this.multiplicadorValorPorTipo = multiplicadorValorPorTipo;
    }
}
