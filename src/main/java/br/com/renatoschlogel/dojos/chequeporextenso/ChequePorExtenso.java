package br.com.renatoschlogel.dojos.chequeporextenso;

import java.math.BigDecimal;

public class ChequePorExtenso {

    public static String execute(BigDecimal valor) {
        String reaisPorExtenso = getReaisPorExtenso(valor);
        String centavosPorExtenso = getCentavosPorExtenso(valor);
        return juntar(reaisPorExtenso, centavosPorExtenso );
    }

    private static String getReaisPorExtenso(BigDecimal valor) {
        String numeroExtenso = getValorPorExtenso(valor);

        if (!numeroExtenso.isEmpty()) {
            if (numeroExtenso.equalsIgnoreCase("um")) {
                numeroExtenso += " real";
            } else {
                numeroExtenso += " reais";
            }
        }

        return numeroExtenso;
    }

    private static String getValorPorExtenso(BigDecimal valor) {
        valor = BigDecimal.valueOf(valor.intValue());

        String numeroExtenso = "";
        BigDecimal valorRestante = valor;

        if (valorRestante.compareTo(new BigDecimal(1000)) >= 0) {
            int quantidadeMilhar = valorRestante.divide(BigDecimal.valueOf(1000)).intValue();
            numeroExtenso = juntar(numeroExtenso, getMilharPorExtenso(quantidadeMilhar));
            valorRestante = valorRestante.subtract(BigDecimal.valueOf(quantidadeMilhar).multiply(BigDecimal.valueOf(1000)));
        }

        if (valorRestante.compareTo(new BigDecimal(100)) > 0) {
            int quantidadeCentena = valorRestante.divide(BigDecimal.valueOf(100)).intValue();
            BigDecimal valorCentena = BigDecimal.valueOf(quantidadeCentena).multiply(BigDecimal.valueOf(100));
            String valorNovoExtenso = EnumNumeroPorExtenso.get(valorCentena.intValue());
            if (valorNovoExtenso.equalsIgnoreCase(EnumNumeroPorExtenso.CEM.getNumeroExtenso())) {
                valorNovoExtenso = "cento";
            }
            numeroExtenso = juntar(numeroExtenso, valorNovoExtenso);
            valorRestante = valorRestante.subtract(valorCentena);
        }

        numeroExtenso = juntar(numeroExtenso, getUnidadePorExtenso(valorRestante.intValue()));
        return numeroExtenso;
    }

    private static String juntar(String valorExistente, String valorNovo) {
        if (!valorExistente.isEmpty() && !valorNovo.isEmpty()) {
            return valorExistente + " e " + valorNovo;
        }
        return valorExistente +  valorNovo;
    }

    private static String getMilharPorExtenso(int quantidaMilhar) {
        if (quantidaMilhar > 0 ) {
            if (quantidaMilhar == 1) {
                return "mil";
            }

            return EnumNumeroPorExtenso.get(quantidaMilhar) + " mil";
        }

        return "";
    }

    private static String getCentavosPorExtenso(BigDecimal valor) {
        String numeroExtenso = getInteiroPorExtenso(valor);

        if (!numeroExtenso.isEmpty()) {
            if (numeroExtenso.equalsIgnoreCase("um") ) {
                numeroExtenso += " centavo";
            } else {
                numeroExtenso += " centavos";
            }
        }

        return numeroExtenso;
    }

    private static String getInteiroPorExtenso(BigDecimal valor) {
        BigDecimal valorInteiro = new BigDecimal(valor.toBigInteger());
        int valorCentavos = valor.subtract(valorInteiro).multiply(new BigDecimal("100")).intValue();

        return getUnidadePorExtenso(valorCentavos);
    }

    private static String getUnidadePorExtenso(int valor) {

        if (valor > 20) {
            int valorDezena = encontrarDezena(valor);
            int valorUnidade = valor - valorDezena;

            String numeroExtenso = EnumNumeroPorExtenso.get(valorDezena);
            if (valorUnidade > 0) {
                if (numeroExtenso.equalsIgnoreCase(EnumNumeroPorExtenso.CEM.getNumeroExtenso())) {
                    numeroExtenso = "cento";
                }
                numeroExtenso += " e " + EnumNumeroPorExtenso.get(valorUnidade);
            }
            return numeroExtenso;
        }

        return EnumNumeroPorExtenso.get(valor);
    }

    private static int encontrarDezena(int valorCentavos) {
        BigDecimal valor = BigDecimal.valueOf(valorCentavos).divide(BigDecimal.TEN);
        return new BigDecimal(valor.toBigInteger()).multiply(BigDecimal.TEN).intValue();
    }

    public static void main(String[] args) {
        BigDecimal valor = BigDecimal.valueOf(1045);
        valor = valor.divide(BigDecimal.valueOf(1000));

        BigDecimal valorMilhar = new BigDecimal(valor.toBigInteger()).multiply(BigDecimal.valueOf(1000));
        System.out.println(valorMilhar);
    }
}
