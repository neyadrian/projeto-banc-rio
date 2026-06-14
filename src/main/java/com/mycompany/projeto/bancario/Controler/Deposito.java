package com.mycompany.projeto.bancario.Controler;

import com.mycompany.projeto.bancario.BancoDeDados.conexao;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Deposito {
    
    public void processar(JFrame TelaDepósito, String contaLogada, String valorTexto) {
        
        try {
            double valor = Double.parseDouble(valorTexto.replace(",", "."));
            if (valor <= 0) {
                JOptionPane.showMessageDialog(TelaDepósito, "O valor deve ser maior que zero!");
                return;
            }

            String sqlUpdate = "UPDATE contas SET saldo = saldo + ? WHERE numero_conta = ?";
            String sqlInsert = "INSERT INTO transacoes (id_conta, tipo_operacao, valor, descricao) VALUES ((SELECT id_conta FROM contas WHERE numero_conta = ?), 'DEPOSITO', ?, 'Depósito em conta')";

            try (Connection conn = conexao.conectar();
                 PreparedStatement stmtUp = conn.prepareStatement(sqlUpdate);
                 PreparedStatement stmtIn = conn.prepareStatement(sqlInsert)) {

                stmtUp.setDouble(1, valor);
                stmtUp.setString(2, contaLogada);
                stmtUp.executeUpdate();

                stmtIn.setString(1, contaLogada);
                stmtIn.setDouble(2, valor);
                stmtIn.executeUpdate();

                JOptionPane.showMessageDialog(TelaDepósito, "Depósito realizado com sucesso!");
                TelaDepósito.dispose();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(TelaDepósito, "Erro no banco: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(TelaDepósito, "Digite um valor numérico válido!");
        }
    }
    
}
