/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netcar.telas;

import static br.com.netcar.telas.TelaPrincipal.bntManterUsu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Wilton Santos
 */
public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(getIconImage());

    }

    public final Image getIconImage() {
        Image Icone = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/netcar/icones/n.png"));
        return Icone;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblimg = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        bntDash = new javax.swing.JButton();
        bntClien = new javax.swing.JButton();
        bntVeic = new javax.swing.JButton();
        bntMoto = new javax.swing.JButton();
        bntViag = new javax.swing.JButton();
        bntRela = new javax.swing.JButton();
        bntAvis = new javax.swing.JButton();
        bntSair = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bntManterUsu = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        lblData = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Netcar - Sistema para controle de frota");
        setBackground(new java.awt.Color(255, 51, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 51, 0));

        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/netcar-multimarcas-ltda-5423289054fc8.png"))); // NOI18N
        lblimg.setAlignmentY(0.3F);
        lblimg.setAutoscrolls(true);
        lblimg.setMaximumSize(new java.awt.Dimension(250, 88));
        lblimg.setMinimumSize(new java.awt.Dimension(20, 88));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(lblimg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jDesktopPane2.setBackground(new java.awt.Color(204, 51, 0));
        jDesktopPane2.setForeground(new java.awt.Color(204, 51, 0));

        bntDash.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntDash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/dashboard.png"))); // NOI18N
        bntDash.setText("Dashboard");
        bntDash.setDefaultCapable(false);
        bntDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDashActionPerformed(evt);
            }
        });

        bntClien.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntClien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/cliente.png"))); // NOI18N
        bntClien.setText("Clientes");
        bntClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntClienActionPerformed(evt);
            }
        });

        bntVeic.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntVeic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/veiculos.png"))); // NOI18N
        bntVeic.setText("Veiculos");

        bntMoto.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/motorista.png"))); // NOI18N
        bntMoto.setText("Motoristas");

        bntViag.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntViag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/viagem.png"))); // NOI18N
        bntViag.setText("Viagens");

        bntRela.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntRela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/relatorio.png"))); // NOI18N
        bntRela.setText("Relatórios");
        bntRela.setFocusable(false);
        bntRela.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntRela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRelaActionPerformed(evt);
            }
        });

        bntAvis.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntAvis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/aviso.png"))); // NOI18N
        bntAvis.setText("Avisos");
        bntAvis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAvisActionPerformed(evt);
            }
        });

        bntSair.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/exit.png"))); // NOI18N
        bntSair.setText("Sair");
        bntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSairActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/about.png"))); // NOI18N
        jButton1.setText("Sobre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bntManterUsu.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bntManterUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/usuario.png"))); // NOI18N
        bntManterUsu.setText("Manter usuário");
        bntManterUsu.setEnabled(false);
        bntManterUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntManterUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bntDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntManterUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntMoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntVeic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntAvis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntViag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntRela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntClien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addComponent(bntSair)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bntDash, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(bntClien)
                .addGap(20, 20, 20)
                .addComponent(bntVeic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(bntMoto)
                .addGap(20, 20, 20)
                .addComponent(bntViag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(bntRela)
                .addGap(20, 20, 20)
                .addComponent(bntAvis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(bntManterUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jDesktopPane2.setLayer(bntDash, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntClien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntVeic, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntMoto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntViag, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntRela, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntAvis, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntSair, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(bntManterUsu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblData.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lblData.setText("DATA");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel2.setText("Seja bem-vindo !");

        lblUsuario.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        lblUsuario.setText("Usuário");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
                        .addComponent(lblData))
                    .addGroup(desktopLayout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        desktop.setLayer(lblData, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(lblUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane1)
                    .addComponent(jDesktopPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane2))
            .addComponent(desktop)
        );

        setSize(new java.awt.Dimension(1088, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bntDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDashActionPerformed


    }//GEN-LAST:event_bntDashActionPerformed

    private void bntAvisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAvisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAvisActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //as linhas abaixos substituem a lbldata pela data atual e lbl usuario e pelo usuario
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));

    }//GEN-LAST:event_formWindowActivated

    private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSairActionPerformed
        //exibi uma caixa de dialogo
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_bntSairActionPerformed

    private void bntManterUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntManterUsuActionPerformed
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (Exception e) {
        }

        //abrir tela de cadastro
        TelaUsuario usuario = new TelaUsuario();
        usuario.setVisible(true);
        desktop.add(usuario);
        try {
            usuario.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bntManterUsuActionPerformed

    private void bntRelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntRelaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // chamando a tela sobre
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bntClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntClienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntClienActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (Exception e) {
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAvis;
    private javax.swing.JButton bntClien;
    private javax.swing.JButton bntDash;
    public static javax.swing.JButton bntManterUsu;
    private javax.swing.JButton bntMoto;
    private javax.swing.JButton bntRela;
    private javax.swing.JButton bntSair;
    private javax.swing.JButton bntVeic;
    private javax.swing.JButton bntViag;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblimg;
    // End of variables declaration//GEN-END:variables

}
