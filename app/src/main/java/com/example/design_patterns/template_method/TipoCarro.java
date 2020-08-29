package com.example.design_patterns.template_method;

import java.io.Serializable;

public enum TipoCarro implements Serializable {
    POPULAR {
        @Override
        public Carro carroBuilder() {
            return new Carro(1.0);
        }
    },
    ESPORTE {
        @Override
        public Carro carroBuilder() {
            return new Carro(1.4);
        }
    },
    SUV {
        @Override
        public Carro carroBuilder() {
            return new Carro(1.8);
        }
    };

    public abstract Carro carroBuilder();
}
