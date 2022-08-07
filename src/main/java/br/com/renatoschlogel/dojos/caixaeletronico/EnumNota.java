package br.com.renatoschlogel.dojos.caixaeletronico;

import java.util.Arrays;

public enum EnumNota {
    DEZ(10),
    CINCUENTA(50),
    CEM(100),
    VINTE(20);

    private final int valor;

    EnumNota(int valor) {
        this.valor = valor;
    }

    public static EnumNota findMaiorNotaMenorQue(int valor) {
        return Arrays.stream(values())
                .filter(nota -> nota.getValor() <= valor)
                .reduce((a , b) -> {

                    if (b.getValor() > a.getValor()) {
                        return b;
                    }

                    return a;
                })
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public int getValor() {
        return this.valor;
    }
}
