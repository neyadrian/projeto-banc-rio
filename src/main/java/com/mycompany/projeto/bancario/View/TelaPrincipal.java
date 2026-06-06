
package com.mycompany.projeto.bancario.View;

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

        nomeCliente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saldoCliente = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        botaoVerExtrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeCliente.setFont(new java.awt.Font("Fira Sans", 0, 48)); // NOI18N
        nomeCliente.setText("Olá, Ney Adrian!");

        jLabel2.setText("Saldo Atual:");

        saldoCliente.setFont(new java.awt.Font("Fira Sans", 0, 36)); // NOI18N
        saldoCliente.setText("709,09");

        jButton1.setText("Depósito");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Saque");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Trasnferência/PIX");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        botaoVerExtrato.setText("Ver Extrato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoVerExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(saldoCliente))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(nomeCliente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saldoCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(botaoVerExtrato))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal("").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVerExtrato;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nomeCliente;
    private javax.swing.JLabel saldoCliente;
    // End of variables declaration//GEN-END:variables
}
