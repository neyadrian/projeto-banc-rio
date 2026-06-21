
package com.mycompany.projeto.bancario.Controller;

import com.mycompany.projeto.bancario.Utils.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author neyad
 */
public class Extrato {
    
    public void tabela(JTable tabela, String numeroConta) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        
        String sql = "SELECT t.data_hora, t.tipo_operacao, t.valor FROM transacoes t JOIN contas c ON t.id_conta = c.id_conta WHERE c.numero_conta = ?  ORDER BY t.data_hora DESC";
        
        try(Connection conn = conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, numeroConta);
            ResultSet rs = stmt.executeQuery();
            
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            
            while (rs.next()) {
                java.sql.Timestamp dataBanco = rs.getTimestamp("data_hora");
                String dataFormatada = (dataBanco != null) ? formatoData.format(dataBanco) : "Data Indisponível";

                String operacao = rs.getString("tipo_operacao");
                double valor = rs.getDouble("valor");
                String valorFormatado = formatoMoeda.format(valor);

                if (operacao.contains("SAQUE") || operacao.contains("ENVIADA")) {
                    valorFormatado = "- " + valorFormatado; 
                } else if (operacao.contains("DEPOSITO") || operacao.contains("RECEBIDA")) {
                    valorFormatado = "+ " + valorFormatado;
                }

                modelo.addRow(new Object[]{
                    dataFormatada,
                    operacao,
                    valorFormatado
                });
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar o extrato: " + e.getMessage());
        }
    }
}
