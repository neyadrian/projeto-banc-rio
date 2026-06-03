package com.mycompany.projeto.bancario.Controler;

public class Conta {

    private String cpf;
    private String senha;
    private double saldo;

    public Conta(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if(valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(double valor) {
        if(valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return cpf;
    }
}
