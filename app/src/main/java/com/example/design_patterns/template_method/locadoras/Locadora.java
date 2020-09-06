package com.example.design_patterns.template_method.locadoras;

import com.example.design_patterns.template_method.Carro;

public abstract class Locadora {
    private Carro carro;
    private double valorTotal;
    private double valorSeguro = 0;
    protected double franquia = 0;

    public double getValorTotal() {
        return valorTotal;
    }

    public final static String TIPO_CARRO = "com.example.design_patterns.template_method.locadoras.TIPO_CARRO";

    public Locadora(Carro carro) {
        this.carro = carro;
    }


    protected abstract double getValorFranquiaBase();

    protected abstract double calcularSeguro();

    protected  abstract double getValorKmBase();

    public abstract String getName();
    public abstract String getDescricao();
    public abstract String getAgradecimento();

    public void criarContrato(int dias) {
        calcularValorKm();
        calcularValorTotal(dias);
    }

    public void inserirSeguro(){
        calcularSeguro();
        calcularFranquia();
    }

    public void retirarSeguro() {
        franquia = 0;
        valorSeguro = 0;
    }

    private void calcularValorTotal(int dias) {
        this.valorTotal = (calcularValorKm() + valorSeguro) * dias;
    }

    private void calcularFranquia(){
        franquia =  getValorFranquiaBase() * carro.getMultiplicadorValorPorTipo();
    }

    protected  double calcularValorKm(){
        return (getValorKmBase() + valorSeguro) * carro.getMultiplicadorValorPorTipo();
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public double getFranquia() {
        return franquia;
    }

    public Carro getCarro() {
        return carro;
    }

    public double getValorTotal(int dias) {
        return valorTotal;
    }


}
