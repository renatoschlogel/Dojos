package br.com.renatoschlogel.dojos.caixaeletronico;

import java.util.ArrayList;
import java.util.List;

public class CaixaEletronico {

    public List<EnumNota> sacar(int valor) {

        ArrayList<EnumNota> notasSaque = new ArrayList<>();

        while (valor > 0) {

            EnumNota maiorNota = EnumNota.findMaiorNotaMenorQue(valor);
            notasSaque.add(maiorNota);
            valor -= maiorNota.getValor();
        }

        return notasSaque;
    }

    public static void main(String[] args) {
        int valor = 10;
        while (valor > 0) {
            valor -= 1;
            System.out.println(valor);
        }

    }
}
