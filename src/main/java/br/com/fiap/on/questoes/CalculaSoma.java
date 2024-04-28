package br.com.fiap.on.questoes;

import java.util.Scanner;

import static br.com.fiap.on.utils.ValidaInteiroPositivo.validarInteiroPositivo;
import static java.lang.Integer.parseInt;

public class CalculaSoma {
    private Scanner scanner;
    private int numero;
    private double soma;

    public CalculaSoma(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executar() {
        mostrarEnunciado();
        capturarDados();
        calcular();
        mostrarResultado();
    }

    private void mostrarEnunciado() {
        System.out.println("""
                Questão 3:
                Elaborar um código em Java que leia um valor n, inteiro e positivo; 
                calcule e mostre a soma da seguinte sequência numérica: S=1/1+1/2+1/3+1/4+⋯+1/n
                """);
    }

    private void capturarDados() {
        while (true){
            System.out.print("Digite um inteiro positivo: ");
            String valor = scanner.nextLine();

            boolean valido = validarInteiroPositivo(valor);

            if (valido){
                numero = parseInt(valor);
                break;
            }
        }

    }

    private void calcular() {
        soma = 0;
        for (int n = 1; n <= numero; n++) {
//            System.out.printf("n: %d \n", n);
            soma +=  1.0 / n;
//            System.out.printf("soma: %f \n", soma);
        }
    }

    private void mostrarResultado() {
        System.out.printf("A soma da sequencia é %f \n", soma);
    }
}
