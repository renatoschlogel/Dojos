package br.com.renatoschlogel.dojos.jokenpo;

public class Jogo {

    private String nome;
    private EnumItem item;

    public Jogo(String nome, EnumItem enumItem) {
        this.nome = nome;
        this.item = enumItem;
    }

    public String getNome() {
        return nome;
    }

    public EnumItem getItem() {
        return item;
    }

    public boolean isPedra() {
        return item.equals(EnumItem.PEDRA);
    }

    public boolean isPapel() {
        return item.equals(EnumItem.PAPEL);
    }

    public boolean isTesoura() {
        return item.equals(EnumItem.TESOUSA);
    }
}
