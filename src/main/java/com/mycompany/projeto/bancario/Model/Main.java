package com.mycompany.projeto.bancario.Model;

import com.mycompany.projeto.bancario.Controler.Conta;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o CPF do titular: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a senha do titular: ");
        String senha = scanner.nextLine();

        Conta conta = new Conta(cpf, senha);

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;

                case 2:
                    System.out.print("Valor para saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;

                case 3:
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
