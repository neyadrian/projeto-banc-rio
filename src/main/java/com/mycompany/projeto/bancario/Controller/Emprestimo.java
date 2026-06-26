
package com.mycompany.projeto.bancario.Controller;

import com.mycompany.projeto.bancario.Model.Conta;
import com.mycompany.projeto.bancario.Model.ContaCorrente;
import com.mycompany.projeto.bancario.Model.ContaPoupanca;
import com.mycompany.projeto.bancario.Utils.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author neyad
 */
public class Emprestimo {
   
    public String obterTaxa(String numeroConta) {
        String sql = "SELECT  tipo_conta FROM contas WHERE numero_conta = ?";
        
        try (java.sql.Connection conn = conexao.conectar(); java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, numeroConta);
            java.sql.ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                String tipo = rs.getString("tipo_conta");
                
                if("CORRENTE".equals(tipo)) {
                    return "Conta corrente de 5% ao mês!";
                } else {
                    return "Conta poupança de 2% ao mês!";
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar a taxa: " + e.getMessage());
        }
        return "Taxa de juros padrão de 5% ao mês!";
    }  
    
    public void simularEmprestimo(JTable tabela, String valorTexto, String parcelasTexto, String contaLogada) {
        try {
            double valorSolicitado = Double.parseDouble(valorTexto.replace(",", "."));
            int parcelas = Integer.parseInt(parcelasTexto);

            if(valorSolicitado <= 0 || parcelas <= 0) {
                JOptionPane.showMessageDialog(null, "Digite valores válidos!");
                return;
            }
            
            double taxaJuros = 0.05;
            String sql = "SELECT tipo_conta FROM contas WHERE numero_conta = ?";
            
            try (java.sql.Connection conn = conexao.conectar(); java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            
                stmt.setString(1, contaLogada);
                java.sql.ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String tipoConta = rs.getString("tipo_conta");

                    Conta contaObjeto;
                    if ("CORRENTE".equals(tipoConta)) {
                        contaObjeto = new ContaCorrente(contaLogada, 0.0, null);
                    } else {
                        contaObjeto = new ContaPoupanca(contaLogada, 0.0, null);
                    }

                    taxaJuros = contaObjeto.getTaxaEmprestimo();
                }
            } catch (Exception e) {
                System.out.println("Erro ao aplicar taxa polimórfica: " + e.getMessage());
            }
            
            double valorTotalComJuros = valorSolicitado + (valorSolicitado * taxaJuros * parcelas);
            double valorParcela = valorTotalComJuros / parcelas;
            
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);
            
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            
            for (int i = 1; i <= parcelas; i++) {
                modelo.addRow(new Object[] {
                    i + "ª Parcela",
                    formatoMoeda.format(valorParcela)
                });
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas números válidos!");
        }
    }
    
    public void efetivarEmprestimo(String numeroConta, String valorTexto) {
        try {
            double valorSolicitado = Double.parseDouble(valorTexto.replace(",", "."));
            
            if(valorSolicitado <= 0) {
                JOptionPane.showMessageDialog(null, "Valor inválido para empréstimo!");
                return;
            }
            
            String sqlUpdate = "UPDATE contas SET saldo = saldo + ? WHERE numero_conta = ?";
            String sqlInsert = "INSERT INTO transacoes (id_conta, tipo_operacao, valor, descricao) " +
                               "SELECT id_conta, 'DEPOSITO', ?, 'Empréstimo Aprovado' FROM contas WHERE numero_conta = ?";
            
            try (Connection conn = conexao.conectar();
                 PreparedStatement stmtUp = conn.prepareStatement(sqlUpdate);
                 PreparedStatement stmtIn = conn.prepareStatement(sqlInsert)) {

                stmtUp.setDouble(1, valorSolicitado);
                stmtUp.setString(2, numeroConta);
                stmtUp.executeUpdate();

                stmtIn.setDouble(1, valorSolicitado);
                stmtIn.setString(2, numeroConta);
                stmtIn.executeUpdate();

                JOptionPane.showMessageDialog(null, "Parabéns! Empréstimo de R$ " + String.format("%.2f", valorSolicitado) + " creditado na sua conta.");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar empréstimo: " + e.getMessage());
        }
    }
}
