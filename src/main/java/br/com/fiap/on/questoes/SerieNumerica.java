package br.com.fiap.on.questoes;

import br.com.fiap.on.utils.ValidaInteiroPositivo;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SerieNumerica {

    private Scanner scanner;
    private int limitador;

    public SerieNumerica(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executar() {
        capturarDados();
        calcular();
    }

    public void capturarDados() {

        boolean invalido = true;
        while (invalido) {
            System.out.print("Digite um numero inteiro positivo: ");
            String valor = scanner.nextLine();

            boolean inputValido = ValidaInteiroPositivo.validarInteiroPositivo(valor);

            if (inputValido) {
                invalido = false;
                limitador = parseInt(valor);
            }
        }
    }

    public void calcular() {
        for (int i = 0; i <= limitador; i++) {
            int multiplicacao = 3 * i;
            System.out.println(multiplicacao);
        }
    }
}
