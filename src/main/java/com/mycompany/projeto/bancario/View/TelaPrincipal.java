
package com.mycompany.projeto.bancario.View;

import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

    private String contaLogada;
    
    public TelaPrincipal(String numeroConta) {
        this.contaLogada = numeroConta;
        initComponents();
        
        carregarDadosConta();    
    }

    private void carregarDadosConta() {
        String sql = "SELECT nome_titular, saldo FROM contas WHERE numero_conta = ?";

        try (java.sql.Connection conn = com.mycompany.projeto.bancario.BancoDeDados.conexao.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, this.contaLogada);
            
            java.sql.ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nomeDoBanco = rs.getString("nome_titular");
                double saldoDoBanco = rs.getDouble("saldo");
                
                nomeCliente.setText("Olá, " + nomeDoBanco + "!");
                saldoCliente.setText(String.format("R$ %.2f", saldoDoBanco));
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao buscar os dados da conta: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoDeslogar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        botaoVerExtrato = new javax.swing.JButton();
        botaoDeposito = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nomeCliente = new javax.swing.JLabel();
        saldoCliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/projeto/bancario/Icones/BANK1.png"))); // NOI18N

        botaoDeslogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/projeto/bancario/Icones/voltar.png"))); // NOI18N
        botaoDeslogar.addActionListener(this::botaoDeslogarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoDeslogar)
                .addGap(298, 298, 298)
                .addComponent(jLabel1)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoDeslogar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(57, 161, 56));

        jButton3.setText("Trasnferência/PIX");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        botaoVerExtrato.setText("Ver Extrato");

        botaoDeposito.setText("Depósito");
        botaoDeposito.addActionListener(this::botaoDepositoActionPerformed);

        jButton2.setText("Saque");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        nomeCliente.setFont(new java.awt.Font("Fira Sans", 0, 48)); // NOI18N
        nomeCliente.setForeground(new java.awt.Color(255, 255, 255));
        nomeCliente.setText("Olá, Ney Adrian!");

        saldoCliente.setFont(new java.awt.Font("Fira Sans", 0, 36)); // NOI18N
        saldoCliente.setForeground(new java.awt.Color(255, 255, 255));
        saldoCliente.setText("709,09");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo Atual:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeCliente)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldoCliente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botaoVerExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nomeCliente)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saldoCliente)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)))
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(botaoDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoVerExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDepositoActionPerformed
        dispose();
        new TelaDepósito(this.contaLogada).setVisible(true);
    }//GEN-LAST:event_botaoDepositoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new TelaSaque(this.contaLogada).setVisible(true);    }//GEN-LAST:event_jButton2ActionPerformed

    private void botaoDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeslogarActionPerformed
        
        int resposta = JOptionPane.showConfirmDialog(
            null, 
            "Deseja sair da conta?", 
            "Sair da Conta",                 
            JOptionPane.YES_NO_OPTION
        );
       
        if (resposta == JOptionPane.YES_OPTION) {
            System.out.println("Conta Deslogada");
            dispose();
            new TelaLogin().setVisible(true);
        } else if(resposta == JOptionPane.NO_OPTION) {
            
        } else {
            
        }
 
    }//GEN-LAST:event_botaoDeslogarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal("").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoDeposito;
    private javax.swing.JButton botaoDeslogar;
    private javax.swing.JButton botaoVerExtrato;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel nomeCliente;
    private javax.swing.JLabel saldoCliente;
    // End of variables declaration//GEN-END:variables
}
