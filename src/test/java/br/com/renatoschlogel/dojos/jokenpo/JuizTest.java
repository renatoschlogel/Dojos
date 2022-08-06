package br.com.renatoschlogel.dojos.jokenpo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JuizTest - Juiz de Jokenpo")
@ExtendWith({})
public class JuizTest {

    Jogo jogoComPedra = new Jogo("Renato Joga Pedra", EnumItem.PEDRA);
    Jogo jogoComPapel = new Jogo("Daiza Joga Papel", EnumItem.PAPEL);
    Jogo jogoComTesoura = new Jogo("Ragael Joga Tesoura", EnumItem.TESOUSA);

    @Test
    @DisplayName("Quando Jogar igual, deve dar empate.")
    void deveDarEmpatePoisJogaraIgual() {
        assertThat(Juiz.conferir(jogoComPedra, jogoComPedra)).isEqualTo("Empate");
        assertThat(Juiz.conferir(jogoComPapel, jogoComPapel)).isEqualTo("Empate");
        assertThat(Juiz.conferir(jogoComTesoura, jogoComTesoura)).isEqualTo("Empate");
    }

    @Test
    @DisplayName("O Papel deve ganhar da Pedra.")
    void oPapelDeveGanharDPedra() {
        assertThat(Juiz.conferir(jogoComPedra, jogoComPapel)).isEqualTo(jogoComPapel.getNome());
        assertThat(Juiz.conferir(jogoComPapel, jogoComPedra)).isEqualTo(jogoComPapel.getNome());
    }

    @Test
    @DisplayName("A Tesoura deve ganhar do Papel.")
    void aTesouraDeveGanharDoPapel() {
        assertThat(Juiz.conferir(jogoComTesoura, jogoComPapel)).isEqualTo(jogoComTesoura.getNome());
        assertThat(Juiz.conferir(jogoComPapel, jogoComTesoura)).isEqualTo(jogoComTesoura.getNome());
    }

    @Test
    @DisplayName("A Pedra deve ganhar da Tesoura.")
    void aPedraDeveGanharDaTesoura() {
        assertThat(Juiz.conferir(jogoComTesoura, jogoComPedra)).isEqualTo(jogoComPedra.getNome());
        assertThat(Juiz.conferir(jogoComPedra, jogoComTesoura)).isEqualTo(jogoComPedra.getNome());
    }

}
