package br.com.fiap.on.questoes;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class CalculadoraIMC {
    private Scanner scanner;
    private double peso;
    private double altura;
    private double imc;
    public CalculadoraIMC(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executar() {
        mostarEnunciado();
        caputrarDados();
        calcula();
        mostrarResultado();
    }

    private void mostarEnunciado() {
        System.out.println(
"""
Segunda questão:

2) Você foi contratado para elaborar um programa em Java que calcule o IMC, Índice de Massa Corporal de um usuário.
 O IMC é uma medida internacional usada para calcular se uma pessoa está no peso ideal.
 Para determinar o IMC, basta dividir o peso da pessoa (massa) pela sua altura ao quadrado.
 A massa deve ser definida em quilogramas (kg) e a altura, em metros (m).
 A unidade de medida do IMC é kg/m2 (metro quadrado).
 A classificação do índice de massa corporal (IMC) pode ajudar a identificar obesidade ou desnutrição em crianças,
 adolescentes, adultos e idosos. Pesquise na internet essa classificação e faça seu programa,
 além de retornar o IMC do usuário, dizer qual é a classificação resultante.
 As entradas de usuário são: peso e altura. A saída do programa deve ser o IMC e a classificação.
"""
        );
    }

    private void caputrarDados() {
        System.out.print("Digite o peso da pessoa em quilogramas (Kg): ");
        peso = parseDouble(scanner.nextLine());

        System.out.print("Digite a altura da pessoa em metros (m): ");
        String alturaStr = scanner.nextLine();
        try {
            altura = parseDouble(alturaStr);
        } catch (NumberFormatException e) {
            altura = parseDouble(
                    alturaStr.replace(",", ".")
            );
        }
    }

    private void calcula(){
        imc = peso / (altura * altura);
    }

    private String pegarClassificacao() {
        if (imc < 18.5) {
            return "magreza";
        } else if (imc <= 24.9) {
            return "normal";
        } else if (imc <= 29.9) {
            return "sobrepeso e obesidade grau 1";
        } else if (imc <= 39.9) {
            return "obesidade grau 2";
        } else {
            return "obesidade grave grau 3";
        }
    }

    private void mostrarResultado(){
        System.out.printf("Seu imc é %.2f e sua classificão é %s.\n", imc, pegarClassificacao());
    }
}
