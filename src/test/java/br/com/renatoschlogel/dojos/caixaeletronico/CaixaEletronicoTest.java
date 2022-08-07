package br.com.renatoschlogel.dojos.caixaeletronico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JuizTest - Juiz de Jokenpo")
@ExtendWith({})
public class CaixaEletronicoTest {

    CaixaEletronico caixaEletronico;

    @BeforeEach
    void setUp() {
        caixaEletronico = new CaixaEletronico();
    }

    @Test
    @DisplayName("Deve sacar R$10,00 em apenas uma nota")
    void deveSacar10ReaisEmUmaNota() {
        List<EnumNota> notasSacadas =  caixaEletronico.sacar(10);

        assertThat(getValorTotal(notasSacadas)).isEqualTo(10);
        assertThat(notasSacadas.get(0)).isEqualTo(EnumNota.DEZ);
    }

    @Test
    @DisplayName("Dece sacar apenas uma nota de 20")
    void deveSacar20ReaisEmUmaNota() {
        List<EnumNota> notasSacadas =  caixaEletronico.sacar(20);

        assertThat(getValorTotal(notasSacadas)).isEqualTo(20);
        assertThat(notasSacadas.get(0)).isEqualTo(EnumNota.VINTE);
    }

    @Test
    @DisplayName("Deve sacar apenas uma nota de 50")
    void deveSacar50ReaisEmUmaNota() {
        List<EnumNota> notasSacadas =  caixaEletronico.sacar(50);

        assertThat(getValorTotal(notasSacadas)).isEqualTo(50);
        assertThat(notasSacadas.get(0)).isEqualTo(EnumNota.CINCUENTA);
    }

    @Test
    @DisplayName("Deve sacar apenas uma nota de 100")
    void deveSacar100ReaisEmUmaNota() {
        List<EnumNota> notasSacadas =  caixaEletronico.sacar(100);

        assertThat(getValorTotal(notasSacadas)).isEqualTo(100);
        assertThat(notasSacadas.get(0)).isEqualTo(EnumNota.CEM);
    }

    @Test
    @DisplayName("Deve sacar 30 reais")
    void deveSacar30Reais() {
        List<EnumNota> notasSacadas =  caixaEletronico.sacar(30);

        assertThat(getValorTotal(notasSacadas)).isEqualTo(30);
        assertThat(filterByTipoNota(notasSacadas, EnumNota.DEZ)).size().isEqualTo(1);
        assertThat(filterByTipoNota(notasSacadas, EnumNota.VINTE)).size().isEqualTo(1);
    }

    @Test
    @DisplayName("Deve Sacar 280 reais")
    void deveSacar280Reais() {
        List<EnumNota> notasSacadas =  caixaEletronico.sacar(280);

        assertThat(getValorTotal(notasSacadas)).isEqualTo(280);
        assertThat(filterByTipoNota(notasSacadas, EnumNota.CEM)).size().isEqualTo(2);
        assertThat(filterByTipoNota(notasSacadas, EnumNota.CINCUENTA)).size().isEqualTo(1);
        assertThat(filterByTipoNota(notasSacadas, EnumNota.VINTE)).size().isEqualTo(1);
        assertThat(filterByTipoNota(notasSacadas, EnumNota.DEZ)).size().isEqualTo(1);
    }

    private Integer getValorTotal(List<EnumNota> notas) {
        return notas.stream()
                .map(EnumNota::getValor)
                .reduce(Integer::sum)
                .orElseThrow();
    }

    private List<EnumNota> filterByTipoNota(List<EnumNota> notas, EnumNota dez) {
        return notas.stream().filter(n -> n.equals(dez)).collect(Collectors.toList());
    }
}
