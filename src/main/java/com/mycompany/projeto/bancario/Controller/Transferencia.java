
package com.mycompany.projeto.bancario.Controller;

import com.mycompany.projeto.bancario.BancoDeDados.conexao;
import com.mycompany.projeto.bancario.View.TelaPrincipal; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author neyad
 */
public class Transferencia {

    public void processar(JFrame tela, String contaLogada, String cpfDestino, String valorTexto, String senha) {
        try {
            double valorTransferencia = Double.parseDouble(valorTexto.replace(",", "."));
            
            if (valorTransferencia <= 0 || cpfDestino.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(tela, "Preencha todos os campos corretamente!");
                return;
            }

            try (Connection conn = conexao.conectar()) {
                String sqlRemetente = "SELECT id_conta, saldo, cpf FROM contas WHERE numero_conta = ? AND senha = ?";
                try (PreparedStatement stmtRem = conn.prepareStatement(sqlRemetente)) {
                    stmtRem.setString(1, contaLogada);
                    stmtRem.setString(2, senha);
                    ResultSet rsRem = stmtRem.executeQuery();

                    if (rsRem.next()) {
                        double saldoRemetente = rsRem.getDouble("saldo");
                        int idRemetente = rsRem.getInt("id_conta");
                        String cpfRemetente = rsRem.getString("cpf");

                        if (cpfRemetente.equals(cpfDestino)) {
                             JOptionPane.showMessageDialog(tela, "Você não pode transferir para sua conta!");
                             return;
                        }

                        if (saldoRemetente >= valorTransferencia) {
                            
                            String sqlDestinatario = "SELECT id_conta, nome_titular FROM contas WHERE cpf = ?";
                            try (PreparedStatement stmtDest = conn.prepareStatement(sqlDestinatario)) {
                                stmtDest.setString(1, cpfDestino);
                                ResultSet rsDest = stmtDest.executeQuery();

                                if (rsDest.next()) {
                                    int idDestinatario = rsDest.getInt("id_conta");
                                    String nomeDestinatario = rsDest.getString("nome_titular");

                                    String sqlMandarValor = "UPDATE contas SET saldo = saldo - ? WHERE id_conta = ?";
                                    String sqlReceberValor = "UPDATE contas SET saldo = saldo + ? WHERE id_conta = ?";
                                    
                                    try(PreparedStatement stmtT = conn.prepareStatement(sqlMandarValor);
                                        PreparedStatement stmtB = conn.prepareStatement(sqlReceberValor)) {
                                        
                                        stmtT.setDouble(1, valorTransferencia);
                                        stmtT.setInt(2, idRemetente);
                                        stmtT.executeUpdate();

                                        stmtB.setDouble(1, valorTransferencia);
                                        stmtB.setInt(2, idDestinatario);
                                        stmtB.executeUpdate();
                                    }

                                    String sqlExtrato = "INSERT INTO transacoes (id_conta, tipo_operacao, valor, descricao) VALUES (?, ?, ?, ?)";
                                    try(PreparedStatement stmtExt = conn.prepareStatement(sqlExtrato)) {
                                        stmtExt.setInt(1, idRemetente);
                                        stmtExt.setString(2, "TRANSF_ENVIADA");
                                        stmtExt.setDouble(3, valorTransferencia);
                                        stmtExt.setString(4, "Para CPF: " + cpfDestino + " (" + nomeDestinatario + ")");
                                        stmtExt.executeUpdate();
                                        stmtExt.setInt(1, idDestinatario);
                                        stmtExt.setString(2, "TRANSF_RECEBIDA");
                                        stmtExt.setDouble(3, valorTransferencia);
                                        stmtExt.setString(4, "De CPF: " + cpfRemetente);
                                        stmtExt.executeUpdate();
                                    }
                                    JOptionPane.showMessageDialog(tela, "Transferência de R$ " + String.format("%.2f", valorTransferencia) + "\nenviada para " + nomeDestinatario + " com sucesso!");
                                    
                                    tela.dispose(); 
                                    new TelaPrincipal(contaLogada).setVisible(true); 

                                } else {
                                    JOptionPane.showMessageDialog(tela, "Conta de destino não encontrada no sistema!");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(tela, "Saldo insuficiente!\nSeu saldo atual é: R$ " + String.format("%.2f", saldoRemetente));
                        }
                    } else {
                        JOptionPane.showMessageDialog(tela, "Senha incorreta!");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro ao processar a transferência: " + e.getMessage());
        }
    }
}