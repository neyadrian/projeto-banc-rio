
package com.mycompany.projeto.bancario.Model;

/**
 *
 * @author neyad
 */
public class ContaPoupanca extends Conta{

    public ContaPoupanca(String numeroConta, double saldo, Cliente titutlar) {
        super(numeroConta, saldo, titutlar);
    }
    
    @Override
    public double taxaSaque(double valorDesejado) {
        return valorDesejado; 
    }
    
}
