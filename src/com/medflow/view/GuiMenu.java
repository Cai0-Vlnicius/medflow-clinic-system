/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medflow.view;

/**
 *
 * @author CaioLuiz
 */
public class GuiMenu extends javax.swing.JFrame {

    /**
     * Creates new form GuiMenu
     */
    public GuiMenu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCadastroMedico = new javax.swing.JMenuItem();
        jMenuItemCadastroPaciente = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuRegistro = new javax.swing.JMenu();
        jMenuItemMarcarConsulta = new javax.swing.JMenuItem();
        jMenuItemMarcarExame = new javax.swing.JMenuItem();
        jMenuItemPrescreverM = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedFlow - Sistema de Gestão Clínica");

        jMenuCadastro.setText("Cadastro");

        jMenuItemCadastroMedico.setText("Medico");
        jMenuItemCadastroMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroMedicoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroMedico);

        jMenuItemCadastroPaciente.setText("Paciente");
        jMenuItemCadastroPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroPacienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroPaciente);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemSair);

        jMenuBar1.add(jMenuCadastro);

        jMenuRegistro.setText("Registro");

        jMenuItemMarcarConsulta.setText("Marcar Consulta");
        jMenuItemMarcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMarcarConsultaActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemMarcarConsulta);

        jMenuItemMarcarExame.setText("Marcar Exame");
        jMenuItemMarcarExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMarcarExameActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemMarcarExame);

        jMenuItemPrescreverM.setText("Prescrever medicação");
        jMenuItemPrescreverM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrescreverMActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemPrescreverM);

        jMenuBar1.add(jMenuRegistro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastroMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroMedicoActionPerformed
        new GuiCadastroMedico().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroMedicoActionPerformed

    private void jMenuItemCadastroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroPacienteActionPerformed
        new GuiCadastroPaciente().setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroPacienteActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
       dispose();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMarcarConsultaActionPerformed
        new GuiMarcarConsulta().setVisible(true);
    }//GEN-LAST:event_jMenuItemMarcarConsultaActionPerformed

    private void jMenuItemMarcarExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMarcarExameActionPerformed
        new GuiMarcarExame().setVisible(true);
    }//GEN-LAST:event_jMenuItemMarcarExameActionPerformed

    private void jMenuItemPrescreverMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrescreverMActionPerformed
        new GuiPrescreverMedicacao().setVisible(true);
    }//GEN-LAST:event_jMenuItemPrescreverMActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItemCadastroMedico;
    private javax.swing.JMenuItem jMenuItemCadastroPaciente;
    private javax.swing.JMenuItem jMenuItemMarcarConsulta;
    private javax.swing.JMenuItem jMenuItemMarcarExame;
    private javax.swing.JMenuItem jMenuItemPrescreverM;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenu jMenuRegistro;
    // End of variables declaration//GEN-END:variables
}
