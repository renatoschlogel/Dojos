package br.com.renatoschlogel.dojos.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({})
public class FizzBuzzTest {

    @Test
    void deveExibirApenasONumeroPara1() {
        String valorExibicao = new FizzBuzz(List.of(1)).getExibir();
        assertThat(valorExibicao).isEqualTo("1");
    }

    @Test
    void deveExibirFizzParaOdivisivelPor3() {
        String valorExibicao = new FizzBuzz(List.of(3)).getExibir();
        assertThat(valorExibicao).isEqualTo("Fizz");
    }

    @Test
    void deveExibirBuzzParaOdivisivelPor3() {
        String valorExibicao = new FizzBuzz(List.of(5)).getExibir();
        assertThat(valorExibicao).isEqualTo("Buzz");
    }

    @Test
    void deveExibirFizzBuzzParaOdivisivelPor3E5() {
        String valorExibicao = new FizzBuzz(List.of(15)).getExibir();
        assertThat(valorExibicao).isEqualTo("FizzBuzz");
    }

    @Test
    void deveExibirANumeracaoMaisComplexa() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 22; i++) {
            numeros.add(i);
        }

        String valorExibicao = new FizzBuzz(numeros).getExibir();
        assertThat(valorExibicao).isEqualTo("12Fizz4BuzzFizz78FizzBuzz11Fizz1314FizzBuzz1617Fizz19BuzzFizz22");
    }
}
