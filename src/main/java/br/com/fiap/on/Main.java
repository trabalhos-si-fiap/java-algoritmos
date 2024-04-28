package br.com.fiap.on;

import br.com.fiap.on.questoes.CalculaSoma;
import br.com.fiap.on.questoes.CalculadoraIMC;
import br.com.fiap.on.questoes.Pagamento;
import br.com.fiap.on.questoes.SerieNumerica;
import br.com.fiap.on.questoes.Aposentador;

import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main {
        public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var pagamento = new Pagamento(scanner);
        var calculadoraIMC = new CalculadoraIMC(scanner);
        var calculaSoma = new CalculaSoma(scanner);
        var serieNumerica = new SerieNumerica(scanner);
        var aposentador = new Aposentador(scanner);

        while (true) {
            System.out.println();
            System.out.println("Escolha uma questão:");
            System.out.println("1) Folha de pagamendo");
            System.out.println("2) Calculadora de IMC");
            System.out.println("3) Calcula Soma S=1/1 + 1/2 + ... + 1/n");
            System.out.println("4) Tabuada do 3.");
            System.out.println("5) Avaliação de aposentadoria.");
            System.out.println("Digite 0 para sair.");

            int questao = parseInt(scanner.nextLine());

            switch (questao){
                case 1 -> pagamento.executar();
                case 2 -> calculadoraIMC.executar();
                case 3 -> calculaSoma.executar();
                case 4 -> serieNumerica.executar();
                case 5 -> aposentador.executar();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
            }
        }
    }
}
