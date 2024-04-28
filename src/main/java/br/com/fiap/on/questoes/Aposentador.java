package br.com.fiap.on.questoes;

import java.util.Scanner;

import static br.com.fiap.on.utils.ValidaInteiroPositivo.validarInteiroPositivo;
import static java.lang.Integer.parseInt;

public class Aposentador {

    private Scanner scanner;
    private int anosDeContribuicao;
    private int anosDeIdade;
    private int contribuicaoMinima = 15;
    private int idadeMinima = 60;
    private String resultado;

    private boolean idadeMaiorQueAIdadeMinima;
    private boolean contribuicaoMaiorQueAContribuicaoMinima;

    public Aposentador(Scanner scanner) {
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
                5) Em certo país, um sistema de aposentadoria pública considera a idade da pessoa contribuinte e o tempo que ela 
                contribui para o Instituto de Seguridade Social daquele local. As condições para que a aposentadoria integral seja 
                liberada a uma pessoa são as seguintes: i) Ter ao menos 60 anos, E... ii) Ter um mínimo de 15 anos de contribuição. 
                Elabore um programa em Java que leia a idade e o tempo de serviço de uma pessoa e responda se ela pode ou não se aposentar.
                """);
    }

    private void capturarDados() {
        while (true) {
            System.out.print("Informe a sua idade: ");
            String idade = scanner.nextLine();

            System.out.print("Informe a quantidade de anos de contribuição: ");
            String contribuicao = scanner.nextLine();

            boolean idadeValida = validarInteiroPositivo(idade);
            boolean contribuicaoValida = validarInteiroPositivo(contribuicao);

            if (idadeValida && contribuicaoValida) {
                anosDeIdade = parseInt(idade);
                anosDeContribuicao = parseInt(contribuicao);
                break;
            }
        }
    }

    private void calcular() {
        idadeMaiorQueAIdadeMinima = anosDeIdade >= idadeMinima;
        contribuicaoMaiorQueAContribuicaoMinima = anosDeContribuicao >= contribuicaoMinima;
    }

    private void mostrarResultado() {
        resultado = "";

        if (!idadeMaiorQueAIdadeMinima) {
            resultado += "Você não pode se aposentar pois você ainda não completou 60 anos de idade.\n";
        }
        if (!contribuicaoMaiorQueAContribuicaoMinima) {
            resultado += "Você não pode se aposentar pois você ainda não completou 15 anos de contribuição.\n";
        }

        if (idadeMaiorQueAIdadeMinima && contribuicaoMaiorQueAContribuicaoMinima) {
            resultado = String.format("Parabéns, você pode se aposentar.\nIdade mínima: %d anos, sua idade: %d anos\n", idadeMinima, anosDeIdade);
            resultado += String.format("Contribuição mínima %d anos, sua contribuição: %d anos", contribuicaoMinima, anosDeContribuicao);
        }

        System.out.println("\n" + resultado);
    }
}
