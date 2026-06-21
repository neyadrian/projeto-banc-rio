package com.mycompany.projeto.bancario.Controller;

import com.mycompany.projeto.bancario.Utils.conexao;
import com.mycompany.projeto.bancario.Model.Cliente;
import com.mycompany.projeto.bancario.Model.Conta;
import com.mycompany.projeto.bancario.Model.ContaCorrente;
import com.mycompany.projeto.bancario.Model.ContaPoupanca;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author neyadrian
 */
public class Saque {
    
    public void processar(JFrame TelaSaque, String contaLogada, String valorTexto, String senha) {
        
        try {
            double valorDesejado = Double.parseDouble(valorTexto.replace(",", "."));
            
            if(valorDesejado <= 0 || senha.isEmpty()) {
                JOptionPane.showMessageDialog(TelaSaque, "Preencha o valor e a senha corretamente!");
                return;
            }
            
            String sqlVerificacao = "SELECT id_conta, saldo, tipo_conta, nome_titular, cpf FROM contas WHERE numero_conta = ? AND senha = ?";
            
            try (Connection conn = conexao.conectar(); PreparedStatement stmtVer = conn.prepareStatement(sqlVerificacao)) {
                
                stmtVer.setString(1, contaLogada);
                stmtVer.setString(2, senha);
                ResultSet rs = stmtVer.executeQuery();  
                
                if (rs.next()) {
                    double saldoBanco = rs.getDouble("saldo");
                    int idConta = rs.getInt("id_conta");
                    String tipoConta = rs.getString("tipo_conta");
                    String nomeTitular = rs.getString("nome_titular");
                    String cpfTitular = rs.getString("cpf");

                    Cliente titular = new Cliente(nomeTitular, cpfTitular);
                    
                    Conta conta;

                    if (tipoConta != null && tipoConta.equals("CORRENTE")) {
                        conta = new ContaCorrente(contaLogada, saldoBanco, titular);
                    } else {
                        conta = new ContaPoupanca(contaLogada, saldoBanco, titular);
                    }
                    
                    double valorTotalDesconto = conta.taxaSaque(valorDesejado);

                    if (saldoBanco >= valorTotalDesconto) {
                        
                        String sqlUpdate = "UPDATE contas SET saldo = saldo - ? WHERE id_conta = ?";
                        String sqlInsert = "INSERT INTO transacoes (id_conta, tipo_operacao, valor, descricao) VALUES (?, 'SAQUE', ?, 'Saque no caixa')";

                        try (PreparedStatement stmtUp = conn.prepareStatement(sqlUpdate);
                             PreparedStatement stmtIn = conn.prepareStatement(sqlInsert)) {
                            
                            stmtUp.setDouble(1, valorTotalDesconto);
                            stmtUp.setInt(2, idConta);
                            stmtUp.executeUpdate();

                            stmtIn.setInt(1, idConta);
                            stmtIn.setDouble(2, valorDesejado);
                            stmtIn.executeUpdate();

                            if (valorTotalDesconto > valorDesejado) {
                                JOptionPane.showMessageDialog(TelaSaque, "Saque realizado com sucesso!\nFoi cobrada uma taxa de manutenção de R$ 5,00.");
                            } else {
                                JOptionPane.showMessageDialog(TelaSaque, "Saque realizado com sucesso!\nConta Poupança isenta de taxas.");
                            }
                            
                            TelaSaque.dispose();
                            new com.mycompany.projeto.bancario.View.TelaPrincipal(contaLogada).setVisible(true);

                        }
                    } else {
                        JOptionPane.showMessageDialog(TelaSaque, "Saldo insuficiente para o saque (incluindo possíveis taxas)!\nDisponível: R$ " + String.format("%.2f", saldoBanco));
                    }
                } else {
                    JOptionPane.showMessageDialog(TelaSaque, "Senha incorreta!");
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(TelaSaque, "Erro no banco: " + e.getMessage());
            }                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(TelaSaque, "Digite um valor numérico válido!");
        }
    }
}