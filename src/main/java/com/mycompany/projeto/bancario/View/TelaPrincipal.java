
package com.mycompany.projeto.bancario.View;

import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

    private String contaLogada;
    
    public TelaPrincipal(String numeroConta) {
        this.contaLogada = numeroConta;
        initComponents();
        setLocationRelativeTo(null);
        carregarDadosConta();
    }

    private void carregarDadosConta() {
        String sql = "SELECT nome_titular, saldo FROM contas WHERE numero_conta = ?";

        try (java.sql.Connection conn = com.mycompany.projeto.bancario.Utils.conexao.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, this.contaLogada);
            
            java.sql.ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nomeDoBanco = rs.getString("nome_titular");
                double saldoDoBanco = rs.getDouble("saldo");
                
                nomeCliente.setText("Olá, " + nomeDoBanco + "!");
                java.text.NumberFormat formatoMoeda = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));
                saldoCliente.setText(formatoMoeda.format(saldoDoBanco));
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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoValorEmprestimo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoParcelas = new javax.swing.JTextField();
        botaoSimular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimo = new javax.swing.JTable();
        botaoConfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

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
                .addGap(304, 304, 304)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        botaoVerExtrato.addActionListener(this::botaoVerExtratoActionPerformed);

        botaoDeposito.setText("Depósito");
        botaoDeposito.addActionListener(this::botaoDepositoActionPerformed);

        jButton2.setText("Saque");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        nomeCliente.setFont(new java.awt.Font("Fira Sans", 1, 48)); // NOI18N
        nomeCliente.setForeground(new java.awt.Color(255, 255, 255));
        nomeCliente.setText("Olá, Ney Adrian!");

        saldoCliente.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        saldoCliente.setForeground(new java.awt.Color(255, 255, 255));
        saldoCliente.setText("709,09");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo Atual:");

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Empréstimo");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Faça uma Simulação");

        campoValorEmprestimo.addActionListener(this::campoValorEmprestimoActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Digite o Valor:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("N° de Parcelas:");

        campoParcelas.addActionListener(this::campoParcelasActionPerformed);

        botaoSimular.setText("Simular");
        botaoSimular.addActionListener(this::botaoSimularActionPerformed);

        tabelaEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Parcela", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaEmprestimo);

        botaoConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/projeto/bancario/Icones/valid.png"))); // NOI18N
        botaoConfirmar.setText("SIM");
        botaoConfirmar.addActionListener(this::botaoConfirmarActionPerformed);

        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/projeto/bancario/Icones/cancelar-icono-9428-128.png"))); // NOI18N
        botaoCancelar.setText("NÃO");
        botaoCancelar.addActionListener(this::botaoCancelarActionPerformed);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Deseja pegar esse valor?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoValorEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel7)))
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(botaoSimular))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValorEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoSimular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoCancelar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(saldoCliente)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botaoVerExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nomeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nomeCliente)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(saldoCliente)
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(botaoDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoVerExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
        dispose();
        new TelaPix(this.contaLogada).setVisible(true);
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

    private void botaoVerExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerExtratoActionPerformed
        dispose();
        new TelaExtrato(this.contaLogada).setVisible(true);
    }//GEN-LAST:event_botaoVerExtratoActionPerformed

    private void campoValorEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorEmprestimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoValorEmprestimoActionPerformed

    private void campoParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoParcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoParcelasActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        String valorDigitado = campoValorEmprestimo.getText();
    
        if(!valorDigitado.isEmpty()) {
            new com.mycompany.projeto.bancario.Controller.Emprestimo().efetivarEmprestimo(this.contaLogada, valorDigitado);

            carregarDadosConta();

            campoValorEmprestimo.setText("");
            campoParcelas.setText("");
            ((javax.swing.table.DefaultTableModel) tabelaEmprestimo.getModel()).setNumRows(0);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Faça uma simulação primeiro!");
        }
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        campoValorEmprestimo.setText("");
        campoParcelas.setText("");
        ((javax.swing.table.DefaultTableModel) tabelaEmprestimo.getModel()).setNumRows(0);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSimularActionPerformed
        new com.mycompany.projeto.bancario.Controller.Emprestimo().simularEmprestimo(
        tabelaEmprestimo,
        campoValorEmprestimo.getText(), 
        campoParcelas.getText()
    );
    }//GEN-LAST:event_botaoSimularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal("").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoDeposito;
    private javax.swing.JButton botaoDeslogar;
    private javax.swing.JButton botaoSimular;
    private javax.swing.JButton botaoVerExtrato;
    private javax.swing.JTextField campoParcelas;
    private javax.swing.JTextField campoValorEmprestimo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel nomeCliente;
    private javax.swing.JLabel saldoCliente;
    private javax.swing.JTable tabelaEmprestimo;
    // End of variables declaration//GEN-END:variables
}
