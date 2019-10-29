/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netcar.telas;

import br.com.netcar.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Wilton Santos
 */
public class TelaVeiculos extends javax.swing.JInternalFrame {

    //serve para conectar o banco de dados 
    Connection conexao = null;
    //Serve para prepara a classe para o banco de dados
    PreparedStatement pst = null;
    //Exibi o resultado das instrucoes SQL
    ResultSet rs = null;
    
    /**
     * Creates new form TelaVeiculos
     */
    public TelaVeiculos() {
        initComponents();
        conexao = ModuloConexao.conector();

    }

    private void adicionar() {
        String sql = "insert into tbveiculos(PLACA, NOME_VEICULO, MARCA_VEICULO, N_CHASSI, ANO_VEICULO,STATUS)"
                + "values(?, ? , ? , ?, ?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtVeiPlaca.getText());
            pst.setString(2, txtVeiNome.getText());
            pst.setString(3, txtVeiMarca.getText());
            pst.setString(4, txtVeiChassi.getText());
            pst.setString(5, txtVeiAno.getText());
            pst.setString(6, cboVei.getSelectedItem().toString().trim());


            //validacao dos campos obrigatoriso
            if ((txtVeiPlaca.getText().isEmpty()) || (txtVeiNome.getText().isEmpty()) || (txtVeiMarca.getText().isEmpty()) || (txtVeiChassi.getText().isEmpty()) || (txtVeiAno.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");

            } else {

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Veiculo adicionado com sucesso");
                    txtVeiPlaca.setText(null);
                    txtVeiNome.setText(null);
                    txtVeiMarca.setText(null);
                    txtVeiChassi.setText(null);
                    txtVeiAno.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
     private void pesquisar_veiculos() {
            String sql = "select * from tbveiculos where placa like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtVeiPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // usa a biblioteca rs2xml.jar 
            tblVei.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // metodo para setar os campos no formalurio com conteudo da tabela
    public void setar_campos() {
        int setar = tblVei.getSelectedRow();
        txtVeiPlaca.setText(tblVei.getModel().getValueAt(setar, 0).toString());
        txtVeiNome.setText(tblVei.getModel().getValueAt(setar, 1).toString());
        txtVeiMarca.setText(tblVei.getModel().getValueAt(setar, 2).toString());
        txtVeiChassi.setText(tblVei.getModel().getValueAt(setar, 3).toString());
        txtVeiAno.setText(tblVei.getModel().getValueAt(setar, 4).toString());

        bntVeiAdicionar.setEnabled(false);
    }
    
    
     private void alterar() {
        String sql = "update tbveiculos set NOME_VEICULO=?,MARCA_VEICULO=?,N_CHASSI=?,ANO_VEICULO=? where PLACA=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtVeiNome.getText());
            pst.setString(2, txtVeiMarca.getText());
            pst.setString(3, txtVeiChassi.getText());
            pst.setString(4, txtVeiAno.getText());
            pst.setString(5, txtVeiPlaca.getText());

            if ((txtVeiPlaca.getText().isEmpty()) || (txtVeiNome.getText().isEmpty()) || (txtVeiMarca.getText().isEmpty()) || (txtVeiChassi.getText().isEmpty()) || (txtVeiAno.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");

            } else {

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Veiculos alterado com sucesso");
                    txtVeiPlaca.setText(null);
                    txtVeiNome.setText(null);
                    txtVeiMarca.setText(null);
                    txtVeiChassi.setText(null);
                    txtVeiAno.setText(null);
                    bntVeiAdicionar.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
     
     
      private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atulizar o status deste Veiculos", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update tbveiculos set status=? where placa=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, cboVei.getSelectedItem().toString());
                pst.setString(2, txtVeiPlaca.getText());

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Status do Veiculo alterado com sucesso");
                    txtVeiPlaca.setText(null);
                    txtVeiNome.setText(null);
                    txtVeiMarca.setText(null);
                    txtVeiChassi.setText(null);
                    txtVeiAno.setText(null);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntVeiAdicionar = new javax.swing.JButton();
        txtVeiMarca = new javax.swing.JTextField();
        bntVeiExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtVeiNome = new javax.swing.JTextField();
        txtVeiPlaca = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bntVeiUpdate = new javax.swing.JButton();
        txtVeiAno = new javax.swing.JFormattedTextField();
        txtVeiChassi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtVeiPesquisar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboVei = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVei = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Veiculos");

        bntVeiAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/create.png"))); // NOI18N
        bntVeiAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVeiAdicionarActionPerformed(evt);
            }
        });

        txtVeiMarca.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        bntVeiExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/yes1.png"))); // NOI18N
        bntVeiExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVeiExcluirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("*CHASSI");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("*MARCA");

        txtVeiNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtVeiNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVeiNomeActionPerformed(evt);
            }
        });

        try {
            txtVeiPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtVeiPlaca.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("*NOME");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("*Campos Obrigatórios");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/pesquisar.png"))); // NOI18N

        bntVeiUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/update.png"))); // NOI18N
        bntVeiUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVeiUpdateActionPerformed(evt);
            }
        });

        try {
            txtVeiAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtVeiAno.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtVeiChassi.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("*PLACA");

        txtVeiPesquisar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtVeiPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVeiPesquisarKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("*ANO");

        cboVei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cboVei.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        tblVei.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tblVei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5"
            }
        ));
        tblVei.setMinimumSize(new java.awt.Dimension(200, 1000));
        tblVei.setPreferredSize(new java.awt.Dimension(850, 1000));
        tblVei.setRequestFocusEnabled(false);
        tblVei.setShowHorizontalLines(false);
        tblVei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVei);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtVeiPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1)
                            .addGap(279, 279, 279)
                            .addComponent(jLabel2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(bntVeiAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204)
                                .addComponent(bntVeiUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(cboVei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                        .addComponent(bntVeiExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVeiNome, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVeiPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVeiAno, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtVeiMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                .addComponent(txtVeiChassi)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVeiPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtVeiPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVeiNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtVeiMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtVeiChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtVeiAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboVei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(bntVeiAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntVeiExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(bntVeiUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVeiAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVeiAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_bntVeiAdicionarActionPerformed

    private void bntVeiExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVeiExcluirActionPerformed
        remover();
    }//GEN-LAST:event_bntVeiExcluirActionPerformed

    private void txtVeiNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVeiNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVeiNomeActionPerformed

    private void bntVeiUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVeiUpdateActionPerformed
        alterar();
    }//GEN-LAST:event_bntVeiUpdateActionPerformed

    private void txtVeiPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVeiPesquisarKeyReleased
        pesquisar_veiculos();
    }//GEN-LAST:event_txtVeiPesquisarKeyReleased

    private void tblVeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeiMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblVeiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVeiAdicionar;
    private javax.swing.JButton bntVeiExcluir;
    private javax.swing.JButton bntVeiUpdate;
    private javax.swing.JComboBox cboVei;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVei;
    private javax.swing.JFormattedTextField txtVeiAno;
    private javax.swing.JTextField txtVeiChassi;
    private javax.swing.JTextField txtVeiMarca;
    private javax.swing.JTextField txtVeiNome;
    private javax.swing.JTextField txtVeiPesquisar;
    private javax.swing.JFormattedTextField txtVeiPlaca;
    // End of variables declaration//GEN-END:variables
}
