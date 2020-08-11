package com.example.design_patterns.template_method.locadoras;

import com.example.design_patterns.template_method.Carro;

public abstract class Locadora {
    private Carro carro;
    private double valorTotal;
    private double valorSeguro = 0;

    public Locadora(Carro carro) {
        this.carro = carro;
    }

    protected abstract double getValorFranquiaBase();

    protected abstract double calcularSeguro();

    protected  abstract double getValorKmBase();

    public void criarContrato(int dias) {
        calcularValorKm();
        calcularValorTotal(dias);
    }

    public void inserirSeguro(){
        calcularSeguro();
        calcularValorFranquia();
    }

    public double getValorFranquiaSimulado() {
        return getCalculoFranquia();
    }

    public double getValorTotalSimulado(int dias) {
        return getCalculoValorTotal(dias);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Carro getCarro() {
        return carro;
    }

    private void calcularValorTotal(int dias) {
        this.valorTotal = getCalculoValorTotal(dias);
    }

    private double getCalculoValorTotal(int dias) {
        return carro.getValorKm() + valorSeguro * dias;
    }

    protected void calcularValorFranquia() {
        carro.setFranquia(getCalculoFranquia());
    }

    protected double getCalculoFranquia(){
        return getValorFranquiaBase() * carro.getMultiplicadorValorPorTipo();
    }

    protected  void calcularValorKm(){
        carro.setValorKm((getValorKmBase() + valorSeguro) * carro.getMultiplicadorValorPorTipo());
    }
}
