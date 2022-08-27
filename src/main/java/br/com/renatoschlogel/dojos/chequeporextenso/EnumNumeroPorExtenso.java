package br.com.renatoschlogel.dojos.chequeporextenso;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum EnumNumeroPorExtenso {
    ZERO(0, ""),
    UM(1, "um"),
    DOIS(2, "dois"),
    TRES(3, "três"),
    QUATRO(4, "quatro"),
    CINCO(5,"cinco"),
    SEIS(6, "seis"),
    SETE(7, "sete"),
    OITO(8, "oito"),
    NOVE(9, "nove"),
    DEZ(10, "dez"),
    ONZE(11, "onze"),
    DOZE(12, "doze"),
    TREZE(13, "treze"),
    QUATORZE(14, "quatorze"),
    QUINZE(15, "quinze"),
    DESESSEIS(16, "dezesseis"),
    DESESSETE(17, "dezessete"),
    DESOITO(18, "dezoito"),
    DESENOVE(19, "dezenove"),
    VINTE(20, "vinte"),
    TRINTA(30, "trinta"),
    QUARENTA(40, "quarenta"),
    CINQUENTA(50, "cinquenta"),
    SESSENTA(60, "sessenta"),
    SETENTA(70, "setenta"),
    OITENTA(80, "oitenta"),
    NOVENTA(90, "noventa"),
    CEM(100, "cem"),
    DUZENTOS(200, "duzentos"),
    TREZENTOS(300, "trezentos"),
    QUATROCENTOS(400, "quatrocentos"),
    QUINHENTOS(500, "quinhentos"),
    SEISCENTOS(600, "seiscentos"),
    SETECENTOS(700, "setecentos"),
    OITOCENTOS(800, "oitocentos"),
    NOVECENTOS(900, "novecentos"),
    MIL(1000, "mil"),

    ;

    private final int numero;

    private final String numeroExtenso;

    EnumNumeroPorExtenso(int numero, String numeroExtenso) {
        this.numero = numero;
        this.numeroExtenso = numeroExtenso;
    }

    public String getNumeroExtenso() {
        return numeroExtenso;
    }

    public static String get(int valorCentavos) {
        return Arrays.stream(values())
                .filter( v -> v.numero == valorCentavos)
                .map( v -> v.numeroExtenso)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Não Encontrado Valor Numero por externso para " + valorCentavos ));
    }
}
