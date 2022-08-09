package br.com.renatoschlogel.dojos.fizzbuzz;

import java.util.List;

public class FizzBuzz {

    private final List<Integer> numeros;

    public FizzBuzz(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public String getExibir() {

        return numeros
                .stream()
                .map(this::prepararExibicao)
                .reduce(String::concat)
                .orElseThrow();

    }

    private String prepararExibicao (Integer n) {

        String valorTratado = "";

        if (n % 3 == 0) {
            valorTratado = "Fizz";
        }

        if (n % 5 == 0) {
            valorTratado += "Buzz";
        }

        if (valorTratado.isEmpty()){
            valorTratado = n.toString();
        }

        return valorTratado;
    }

}
