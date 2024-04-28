package br.com.fiap.on.questoes;

import br.com.fiap.on.utils.FormataMoeda;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class Pagamento {

    public Pagamento(Scanner scanner){
        this.scanner = scanner;
    }

//    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner;
    private int horasTrabalhadas;
    private double valorHora;
    private double salarioBruto;
    private double taxaImposto = 0.15;
    private double valorImposto;
    private double taxaGratificacao = 0.05;
    private double valorGratificacao;
    private double salarioLiquido;


    public void executar() {
        mostrarEnunciado();
        capturarDados();
        calculaSalario();
        mostrarHolerite();
    }

    public static void mostrarEnunciado() {
        System.out.println("Primeira questão:\n");
        System.out.println(
        "A empresa Engenheiros e Afins precisa de um sistema de software para o cálculo da folha de pagamento de seus associados." + "\n" +
        "O pagamento de um engenheiro associado se baseia nas horas de trabalho prestadas no mês e no valor da hora de trabalho." + "\n" +
        "Sobre o valor do pagamento, incide 15% de imposto. Além disso, é necessário acrescentar 5% de gratificação." + "\n" +
        "Elabore um programa em linguagem Java que leia as horas mensais trabalhadas e o valor da hora, calcule o pagamento" + "\n" +
        "e apresente o resultado ao usuário. \n");
    }

    public void capturarDados(){
        System.out.println("Sistema de pagamendo.");

        System.out.print("Digite as horas trabalhadas: ");
        horasTrabalhadas = parseInt(scanner.nextLine());

        System.out.print("Digite o valor da hora de trabalho: ");
        valorHora = parseDouble(scanner.nextLine());
    }

    public void calculaSalario(){
        salarioBruto = horasTrabalhadas * valorHora;
        valorImposto = salarioBruto * taxaImposto;
        valorGratificacao = salarioBruto * taxaGratificacao;
        salarioLiquido = salarioBruto - valorImposto + valorGratificacao;
    }

    public void mostrarHolerite(){
        System.out.println(
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" + "\n" +
                "Demonstrativo de Pagamendo de Salário" + "\n" +
                "Matrícula 010201             Cargo: Engenheiro nível 1" + "\n" +
                "Cód.       Descrição        Referência      Vencimentos       Descontos" + "\n" +
                "001        Salário Base       0001          "+ FormataMoeda.paraBrl(salarioBruto)  + "\n" +
                "002        Imposto            15%                             "+ FormataMoeda.paraBrl(valorImposto) + "\n" +
                "003        Gratificação        5%           "+ FormataMoeda.paraBrl(valorGratificacao)  + "\n" + "\n" +

                "Salário líquido: " + FormataMoeda.paraBrl(salarioLiquido) + "\n" +
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" + "\n"
        );
    }
}
