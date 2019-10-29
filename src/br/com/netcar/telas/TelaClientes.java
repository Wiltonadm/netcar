/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.netcar.telas;

import java.sql.*;
import br.com.netcar.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Wilton Santos
 */
public class TelaClientes extends javax.swing.JInternalFrame {
//serve para conectar o banco de dados 
    Connection conexao = null;
    //Serve para prepara a classe para o banco de dados
    PreparedStatement pst = null;
    //Exibi o resultado das instrucoes SQL
    ResultSet rs = null;

    /**
     * Creates new form TelaClientes
     */
    public TelaClientes() {
        initComponents();
        conexao = ModuloConexao.conector();

    }

    private void adicionar() {
        String sql = "insert into tbclientes(CNPJ, NOME, NOME_CONTATO, EMAIL_CONTATO, TEL_CONTATO,STATUS)"
                + "values(?, ? , ? , ?, ?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliCnjp.getText());
            pst.setString(2, txtCliNome.getText());
            pst.setString(3, txtCliFantasia.getText());
            pst.setString(4, txtCliEmail.getText());
            pst.setString(5, txtCliContato.getText());
            pst.setString(6, cboCli.getSelectedItem().toString().trim());


            //validacao dos campos obrigatoriso
            if ((txtCliCnjp.getText().isEmpty()) || (txtCliNome.getText().isEmpty()) || (txtCliFantasia.getText().isEmpty()) || (txtCliEmail.getText().isEmpty()) || (txtCliContato.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");

            } else {

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
                    txtCliCnjp.setText(null);
                    txtCliNome.setText(null);
                    txtCliFantasia.setText(null);
                    txtCliEmail.setText(null);
                    txtCliContato.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void pesquisar_clientes() {
        String sql = "select * from tbclientes where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliPequisar.getText() + "%");
            rs = pst.executeQuery();
            // usa a biblioteca rs2xml.jar 
            tblCli.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // metodo para setar os campos no formalurio com conteudo da tabela
    public void setar_campos() {
        int setar = tblCli.getSelectedRow();
        txtCliCnjp.setText(tblCli.getModel().getValueAt(setar, 0).toString());
        txtCliNome.setText(tblCli.getModel().getValueAt(setar, 1).toString());
        txtCliFantasia.setText(tblCli.getModel().getValueAt(setar, 2).toString());
        txtCliEmail.setText(tblCli.getModel().getValueAt(setar, 3).toString());
        txtCliContato.setText(tblCli.getModel().getValueAt(setar, 4).toString());

        bntCliAdicionar.setEnabled(false);
    }
    
    private void alterar() {
        String sql = "update tbclientes set NOME=?,NOME_CONTATO=?,TEL_CONTATO=?,EMAIL_CONTATO=? where CNPJ=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCliNome.getText());
            pst.setString(2, txtCliFantasia.getText());
            pst.setString(3, txtCliContato.getText());
            pst.setString(4, txtCliEmail.getText());
            pst.setString(5, txtCliCnjp.getText());


            if ((txtCliCnjp.getText().isEmpty()) || (txtCliNome.getText().isEmpty()) || (txtCliFantasia.getText().isEmpty()) || (txtCliEmail.getText().isEmpty()) || (txtCliEmail.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");

            } else {

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Cliente alterado com sucesso");
                    txtCliCnjp.setText(null);
                    txtCliNome.setText(null);
                    txtCliFantasia.setText(null);
                    txtCliEmail.setText(null);
                    txtCliContato.setText(null);
                    bntCliAdicionar.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
     private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atulizar o status deste Cliente", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update tbclientes set status=? where cnpj=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, cboCli.getSelectedItem().toString());
                pst.setString(2, txtCliCnjp.getText());

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Status do Cliente alterado com sucesso");
                    txtCliCnjp.setText(null);
                    txtCliNome.setText(null);
                    txtCliFantasia.setText(null);
                    txtCliEmail.setText(null);
                    txtCliContato.setText(null);

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

        txtCliPequisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCli = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCliCnjp = new javax.swing.JFormattedTextField();
        txtCliContato = new javax.swing.JFormattedTextField();
        txtCliNome = new javax.swing.JTextField();
        txtCliFantasia = new javax.swing.JTextField();
        txtCliEmail = new javax.swing.JTextField();
        bntCliAdicionar = new javax.swing.JButton();
        bntCliUpdate = new javax.swing.JButton();
        bntCliExcluir = new javax.swing.JButton();
        cboCli = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Clientes");
        setMinimumSize(new java.awt.Dimension(105, 34));
        setPreferredSize(new java.awt.Dimension(791, 69));

        txtCliPequisar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtCliPequisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPequisarKeyReleased(evt);
            }
        });

        tblCli.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tblCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5"
            }
        ));
        tblCli.setMinimumSize(new java.awt.Dimension(200, 1000));
        tblCli.setPreferredSize(new java.awt.Dimension(850, 1000));
        tblCli.setRequestFocusEnabled(false);
        tblCli.setShowHorizontalLines(false);
        tblCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCli);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/pesquisar.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("*Campos Obrigatórios");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("*CNPJ");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("*NOME");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("*NOME FANTASIA");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("*E-MAIL");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("CONTATO");

        try {
            txtCliCnjp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCliCnjp.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        try {
            txtCliContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCliContato.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtCliNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtCliNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliNomeActionPerformed(evt);
            }
        });

        txtCliFantasia.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtCliEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        bntCliAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/create.png"))); // NOI18N
        bntCliAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCliAdicionarActionPerformed(evt);
            }
        });

        bntCliUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/update.png"))); // NOI18N
        bntCliUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCliUpdateActionPerformed(evt);
            }
        });

        bntCliExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/yes1.png"))); // NOI18N
        bntCliExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCliExcluirActionPerformed(evt);
            }
        });

        cboCli.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cboCli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo", " ", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCliFantasia, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                    .addComponent(txtCliEmail)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtCliPequisar, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel1)
                                    .addGap(279, 279, 279)
                                    .addComponent(jLabel2))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCliCnjp, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliContato, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(159, 159, 159))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bntCliAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bntCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(cboCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(bntCliExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliPequisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliCnjp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCliFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCliContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(bntCliAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntCliExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(bntCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setBounds(0, 0, 946, 712);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliNomeActionPerformed

    private void bntCliAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCliAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_bntCliAdicionarActionPerformed

    private void txtCliPequisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPequisarKeyReleased
        pesquisar_clientes();
    }//GEN-LAST:event_txtCliPequisarKeyReleased

    private void tblCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCliMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblCliMouseClicked

    private void bntCliUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCliUpdateActionPerformed
        alterar();
    }//GEN-LAST:event_bntCliUpdateActionPerformed

    private void bntCliExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCliExcluirActionPerformed
        remover();
    }//GEN-LAST:event_bntCliExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCliAdicionar;
    private javax.swing.JButton bntCliExcluir;
    private javax.swing.JButton bntCliUpdate;
    private javax.swing.JComboBox cboCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCli;
    private javax.swing.JFormattedTextField txtCliCnjp;
    private javax.swing.JFormattedTextField txtCliContato;
    private javax.swing.JTextField txtCliEmail;
    private javax.swing.JTextField txtCliFantasia;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliPequisar;
    // End of variables declaration//GEN-END:variables
}
