package br.com.fiap.on.utils;

import java.util.Locale;
import java.text.NumberFormat;

public class FormataMoeda {
    private static Locale localBrasil = new Locale("pt", "BR");

    public static String paraBrl(double valor) {
        return NumberFormat.getCurrencyInstance(localBrasil).format(valor);
    }
}
