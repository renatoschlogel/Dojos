package br.com.renatoschlogel.dojos.chequeporextenso;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({})
public class ChequePorExtensoTest {

    @Test
    void deveRetonarOsCentavosPorExtenso() {
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.00"))).isEqualTo("");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.01"))).isEqualTo("um centavo");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.02"))).isEqualTo("dois centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.03"))).isEqualTo("três centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.04"))).isEqualTo("quatro centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.05"))).isEqualTo("cinco centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.06"))).isEqualTo("seis centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.07"))).isEqualTo("sete centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.08"))).isEqualTo("oito centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.09"))).isEqualTo("nove centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.10"))).isEqualTo("dez centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.11"))).isEqualTo("onze centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.12"))).isEqualTo("doze centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.13"))).isEqualTo("treze centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.14"))).isEqualTo("quatorze centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.15"))).isEqualTo("quinze centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.16"))).isEqualTo("dezesseis centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.17"))).isEqualTo("dezessete centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.18"))).isEqualTo("dezoito centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.19"))).isEqualTo("dezenove centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.20"))).isEqualTo("vinte centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.21"))).isEqualTo("vinte e um centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.22"))).isEqualTo("vinte e dois centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.30"))).isEqualTo("trinta centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.40"))).isEqualTo("quarenta centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.50"))).isEqualTo("cinquenta centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.60"))).isEqualTo("sessenta centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.70"))).isEqualTo("setenta centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.80"))).isEqualTo("oitenta centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.90"))).isEqualTo("noventa centavos");
        assertThat(ChequePorExtenso.execute(new BigDecimal("0.99"))).isEqualTo("noventa e nove centavos");
    }

    @Test
    void deveRetornarACentenaDeRealPorExtenso() {
        assertThat(ChequePorExtenso.execute(new BigDecimal("1.00"))).isEqualTo("um real");
        assertThat(ChequePorExtenso.execute(new BigDecimal("2.00"))).isEqualTo("dois reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("50.00"))).isEqualTo("cinquenta reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("100.00"))).isEqualTo("cem reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("101.00"))).isEqualTo("cento e um reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("200.00"))).isEqualTo("duzentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("300.00"))).isEqualTo("trezentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("400.00"))).isEqualTo("quatrocentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("500.00"))).isEqualTo("quinhentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("600.00"))).isEqualTo("seiscentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("700.00"))).isEqualTo("setecentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("800.00"))).isEqualTo("oitocentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("900.00"))).isEqualTo("novecentos reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("21.00"))).isEqualTo("vinte e um reais");
    }

    @Test
    void name() {
        assertThat(ChequePorExtenso.execute(new BigDecimal("1.00"))).isEqualTo("um real");
        assertThat(ChequePorExtenso.execute(new BigDecimal("10.00"))).isEqualTo("dez reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("100.00"))).isEqualTo("cem reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("1000.00"))).isEqualTo("mil reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("2000.00"))).isEqualTo("dois mil reais");
    }

    @Test
    void deveRetornarOMilharDeRealPorExtenso() {
        assertThat(ChequePorExtenso.execute(new BigDecimal("1000.00"))).isEqualTo("mil reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("2000.00"))).isEqualTo("dois mil reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("15000.00"))).isEqualTo("quinze mil reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("1100.00"))).isEqualTo("mil e cem reais");
        assertThat(ChequePorExtenso.execute(new BigDecimal("1101.00"))).isEqualTo("mil e cento e um reais");
    }

    @Test
    void nameaa() {
        assertThat(ChequePorExtenso.execute(new BigDecimal("100101.99"))).isEqualTo("cem mil e cento e um reais e noventa e nove centavos");
    }

}
