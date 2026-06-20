
package com.mycompany.projeto.bancario.Model;

/**
 *
 * @author neyad
 */
public abstract class Conta {
    protected String numeroConta;
    protected double saldo;
    
    protected Cliente titutlar;

    public Conta(String numeroConta, double saldo, Cliente titutlar) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.titutlar = titutlar;
    }
    
    public abstract double taxaSaque(double valorDesejado);
}
