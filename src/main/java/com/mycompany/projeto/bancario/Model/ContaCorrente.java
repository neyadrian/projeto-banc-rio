
package com.mycompany.projeto.bancario.Model;

/**
 *
 * @author neyad
 */
public class ContaCorrente extends Conta{

    public ContaCorrente(String numeroConta, double saldo, Cliente titutlar) {
        super(numeroConta, saldo, titutlar);
    }
    
    @Override
    public double taxaSaque(double valorDesejado) {
        return valorDesejado + 5.00;
    }    
}
