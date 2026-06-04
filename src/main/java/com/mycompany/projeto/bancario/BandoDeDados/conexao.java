
package com.mycompany.projeto.bancario.BandoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexao {
     public static Connection conectar() {
        String CLASSE_DRIVER = "com.mysql.cj.jdbc.Driver";
        String USUARIO = "root";
        String SENHA = "admin";
        String URL_SERVIDOR = "jdbc:mysql://localhost:3306/jmysql?useSSL=false";

        try {
            Class.forName(CLASSE_DRIVER);
            return DriverManager.getConnection(URL_SERVIDOR, USUARIO, SENHA);
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException) {
                JOptionPane.showMessageDialog(null,"Verifique o driver de conexão.");
            } else {
                JOptionPane.showMessageDialog(null,"Verifique se o servidor está ativo.");
            }
            System.exit(-42);
            return null;
        }
    }

    public static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Não foi possí­vel fechar a conexão.");
                e.printStackTrace();
            }
        }
    }

}
