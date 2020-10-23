package com.example.design_patterns.template_method.locadoras;

import com.example.design_patterns.template_method.Carro;

import java.io.Serializable;
import java.util.Random;

public class Loucarros extends Locadora implements Serializable {
    private double PrecoQueOGerenteDecidiuColocarComBaseNasVozesDaSuaCabeca =
            100.0 + (10000.0 - 100.0) * new Random().nextDouble();
    private double diasLuaEmSaturno = 50.0;
    private double sorte = -1;

    public Loucarros(Carro carro) {
        super(carro);
    }

    @Override
    protected double getValorFranquiaBase() {
        return PrecoQueOGerenteDecidiuColocarComBaseNasVozesDaSuaCabeca;
    }

    @Override
    protected double calcularSeguro() {
        return (sorte != -1) ? 2 * sorte : 2 * tentarASorte();
    }

    @Override
    protected double getValorKmBase() {
        return diasLuaEmSaturno;
    }

    @Override
    public String getName() {
        return "Loucarros";
    }

    @Override
    public String getDescricao() {
        return "Não compre uma biscicleta se não souber nadar.";
    }

    @Override
    public String getAgradecimento() {
        return "Antes tarde do que mais tarde.";
    }

    private double tentarASorte() {
        Random random = new Random();
        sorte = random.nextDouble() * random.nextInt(30);
        return sorte;
    }
}
