package br.com.fiap.on.utils;

import static java.lang.Integer.parseInt;

public class ValidaInteiroPositivo {
    public static boolean validarInteiroPositivo(String valor) {

        boolean incluiNegativo = valor.contains("-");
        boolean flutuanteComVirgula = valor.contains(",");
        boolean flutuanteComPonto = valor.contains(".");

        boolean incluiFlutuante = flutuanteComVirgula || flutuanteComPonto;

        if (incluiNegativo || incluiFlutuante) {
            System.out.println("Digite apenas números inteiros e positivos.");
            return false;
        }

        try {
            parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Digite apenas números.");
        }

        return false;
    }
}
