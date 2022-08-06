package br.com.renatoschlogel.dojos.jokenpo;

import java.util.List;
import java.util.Optional;

public class Juiz {

    public static String conferir(Jogo jogoA, Jogo jogoB) {

        if (jogoA.getItem().equals(jogoB.getItem())) {
            return "Empate";
        }

        List<Jogo> jogos = List.of(jogoA, jogoB);

        Optional<Jogo> optPedra = jogos.stream().filter(Jogo::isPedra).findFirst();
        Optional<Jogo> optPapel = jogos.stream().filter(Jogo::isPapel).findFirst();
        Optional<Jogo> optTesoura = jogos.stream().filter(Jogo::isTesoura).findFirst();

        if (optPedra.isPresent() && optPapel.isPresent()) {
            return optPapel.get().getNome();
        }

        if (optTesoura.isPresent() && optPapel.isPresent()) {
            return optTesoura.get().getNome();
        }

        return optPedra.get().getNome();
    }

}
