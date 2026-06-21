
package com.mycompany.projeto.bancario.Controller;

/**
 *
 * @author neyad
 */
import com.mycompany.projeto.bancario.Utils.conexao;
import com.mycompany.projeto.bancario.View.TelaPrincipal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro {
    public void cadastrarUsuario(JFrame tela, String nome, String cpf, String telefone, String senha, String tipoConta) {
        
        if(nome.isEmpty() || cpf.equals("   .   .   -  ") || senha.isEmpty()){
            JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
            return;
        }

        String numeroConta = String.valueOf((int)(Math.random() * 90000) + 10000);

        String sql = "INSERT INTO contas (numero_conta, nome_titular, cpf, telefone, senha, saldo, tipo_conta) VALUES (?, ?, ?, ?, ?, 0.0, ?)";

        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, numeroConta);
            stmt.setString(2, nome);
            stmt.setString(3, cpf);
            stmt.setString(4, telefone);
            stmt.setString(5, senha);
            stmt.setString(6, tipoConta); // Nova coluna!

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(tela, "Cadastro Realizado com Sucesso!\nSua conta é: " + numeroConta);

            tela.dispose();
            new TelaPrincipal(numeroConta).setVisible(true);

        } catch (SQLException e) {
            if(e.getMessage().contains("Duplicate entry")){
                JOptionPane.showMessageDialog(tela, "Erro: Este CPF já está cadastrado.");
            } else {
                JOptionPane.showMessageDialog(tela, "Erro ao salvar no banco: " + e.getMessage());
            }
        }
    }
}
