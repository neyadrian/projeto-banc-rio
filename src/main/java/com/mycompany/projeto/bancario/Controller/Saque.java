package com.mycompany.projeto.bancario.Controller;

import com.mycompany.projeto.bancario.BancoDeDados.conexao;
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
            double valor = Double.parseDouble(valorTexto.replace(",", "."));
            
            if(valor <= 0 || senha.isEmpty()) {
                JOptionPane.showMessageDialog(TelaSaque, "Preencha o valor e a senha corretamente!");
                return;
            }
            
            String sqlVerificacao = "SELECT id_conta, saldo FROM contas WHERE numero_conta = ? AND senha = ?";
            
            try (Connection conn = conexao.conectar(); PreparedStatement stmtVer = conn.prepareStatement(sqlVerificacao)) {
                
                stmtVer.setString(1, contaLogada);
                stmtVer.setString(2, senha);
                ResultSet rs = stmtVer.executeQuery();  
                
                if (rs.next()) {
                    double saldo = rs.getDouble("saldo");
                    int idConta = rs.getInt("id_conta");

                    if (saldo >= valor) {
                        String sqlUpdate = "UPDATE contas SET saldo = saldo - ? WHERE id_conta = ?";
                        String sqlInsert = "INSERT INTO transacoes (id_conta, tipo_operacao, valor, descricao) VALUES (?, 'SAQUE', ?, 'Saque no caixa')";

                        try (PreparedStatement stmtUp = conn.prepareStatement(sqlUpdate);
                             PreparedStatement stmtIn = conn.prepareStatement(sqlInsert)) {
                            
                            stmtUp.setDouble(1, valor);
                            stmtUp.setInt(2, idConta);
                            stmtUp.executeUpdate();

                            stmtIn.setInt(1, idConta);
                            stmtIn.setDouble(2, valor);
                            stmtIn.executeUpdate();

                            JOptionPane.showMessageDialog(TelaSaque, "Saque realizado com sucesso!");
                            TelaSaque.dispose();
                            new com.mycompany.projeto.bancario.View.TelaPrincipal(contaLogada).setVisible(true);

                        }
                    } else {
                        JOptionPane.showMessageDialog(TelaSaque, "Saldo insuficiente!\nDisponível: R$ " + String.format("%.2f", saldo));
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
