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
public class TelaMotorista extends javax.swing.JInternalFrame {

    //serve para conectar o banco de dados 
    Connection conexao = null;
    //Serve para prepara a classe para o banco de dados
    PreparedStatement pst = null;
    //Exibi o resultado das instrucoes SQL
    ResultSet rs = null;

    /**
     * Creates new form TelaViagens
     */
    public TelaMotorista() {
        initComponents();
        conexao = ModuloConexao.conector();
        //tblMotorista.setAutoResizeMode(tblMotorista.AUTO_RESIZE_OFF);
        // tblMotorista.getColumnModel().getColumn(5).setPreferredWidth(200);

    }

    private void adicionar() {
        String sql = "insert into tbmotorista(CPF, NOME, CNH, DATA_NASCI, ENDERECO,status)"
                + "values(?, ? , ? , ?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtMotCpf.getText());
            pst.setString(2, txtMotNome.getText());
            pst.setString(3, txtMotCnh.getText());
            pst.setString(4, txtMotData.getText());
            pst.setString(5, txtMotEndereco.getText());
            pst.setString(6, cbmStatu.getSelectedItem().toString());

            //validacao dos campos obrigatoriso
            if ((txtMotCpf.getText().isEmpty()) || (txtMotNome.getText().isEmpty()) || (txtMotCnh.getText().isEmpty()) || (txtMotData.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");

            } else {

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Motorista adicionado com sucesso");
                    txtMotCpf.setText(null);
                    txtMotNome.setText(null);
                    txtMotCnh.setText(null);
                    txtMotData.setText(null);
                    txtMotEndereco.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // pesquisar clientes pelo nome com filtro
    private void pesquisar_motorista() {
        String sql = "select * from tbmotorista where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtMotPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // usa a biblioteca rs2xml.jar 
            tblMotorista.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // metodo para setar os campos no formalurio com conteudo da tabela
    public void setar_campos() {
        int setar = tblMotorista.getSelectedRow();
        txtMotCpf.setText(tblMotorista.getModel().getValueAt(setar, 0).toString());
        txtMotNome.setText(tblMotorista.getModel().getValueAt(setar, 1).toString());
        txtMotCnh.setText(tblMotorista.getModel().getValueAt(setar, 2).toString());
        txtMotData.setText(tblMotorista.getModel().getValueAt(setar, 3).toString());
        txtMotEndereco.setText(tblMotorista.getModel().getValueAt(setar, 4).toString());
        cbmStatu.setSelectedItem(tblMotorista.getModel().getValueAt(setar, 5).toString());

        btnMotoAdicionar.setEnabled(false);
    }

    private void alterar() {
        String sql = "update tbmotorista set NOME=?,CNH=?,DATA_NASCI=?,ENDERECO=? where CPF=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtMotNome.getText());
            pst.setString(2, txtMotCnh.getText());
            pst.setString(3, txtMotData.getText());
            pst.setString(4, txtMotEndereco.getText());
            pst.setString(5, txtMotCpf.getText());

            if ((txtMotCpf.getText().isEmpty()) || (txtMotNome.getText().isEmpty()) || (txtMotCnh.getText().isEmpty()) || (txtMotData.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");

            } else {

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Motorista alterado com sucesso");
                    txtMotCpf.setText(null);
                    txtMotNome.setText(null);
                    txtMotCnh.setText(null);
                    txtMotData.setText(null);
                    txtMotEndereco.setText(null);
                    btnMotoAdicionar.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atulizar o status deste Motorista", "Atenção", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update tbmotorista set status=? where cpf=?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, cbmStatu.getSelectedItem().toString());
                pst.setString(2, txtMotCpf.getText());

                // a linha a baixo atuliza a tabela com dados do formulario
                //estrutura serve para confirma a insercao dos dados na tabel
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Status do motorista alterado com sucesso");
                    txtMotCpf.setText(null);
                    txtMotNome.setText(null);
                    txtMotCnh.setText(null);
                    txtMotData.setText(null);
                    txtMotEndereco.setText(null);

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMotNome = new javax.swing.JTextField();
        txtMotEndereco = new javax.swing.JTextField();
        txtMotPesquisar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMotorista = new javax.swing.JTable();
        txtMotCpf = new javax.swing.JFormattedTextField();
        txtMotCnh = new javax.swing.JFormattedTextField();
        txtMotData = new javax.swing.JFormattedTextField();
        btnMotoAdicionar = new javax.swing.JButton();
        btnMotoAlterar = new javax.swing.JButton();
        cbmStatu = new javax.swing.JComboBox();
        btnMotoDeletar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Motorista");
        setMinimumSize(new java.awt.Dimension(105, 34));
        setNormalBounds(new java.awt.Rectangle(0, 0, 105, 0));
        setPreferredSize(new java.awt.Dimension(791, 69));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("*Nome");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("*CPF ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("*CNH");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("*Data nascimento ");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Endereço");

        txtMotNome.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtMotEndereco.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        txtMotPesquisar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtMotPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMotPesquisarActionPerformed(evt);
            }
        });
        txtMotPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMotPesquisarKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setText("*Campos Obrigatórios");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/pesquisar.png"))); // NOI18N

        tblMotorista.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tblMotorista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "CNH", "Data Nascimento", "Endereço"
            }
        ));
        tblMotorista.setAutoscrolls(false);
        tblMotorista.setMinimumSize(new java.awt.Dimension(200, 1000));
        tblMotorista.setPreferredSize(new java.awt.Dimension(850, 1000));
        tblMotorista.setRequestFocusEnabled(false);
        tblMotorista.setShowVerticalLines(false);
        tblMotorista.getTableHeader().setResizingAllowed(false);
        tblMotorista.getTableHeader().setReorderingAllowed(false);
        tblMotorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMotoristaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMotorista);

        try {
            txtMotCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMotCpf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        try {
            txtMotCnh.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMotCnh.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        try {
            txtMotData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMotData.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        btnMotoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/create.png"))); // NOI18N
        btnMotoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoAdicionarActionPerformed(evt);
            }
        });

        btnMotoAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/update.png"))); // NOI18N
        btnMotoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoAlterarActionPerformed(evt);
            }
        });

        cbmStatu.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cbmStatu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo", " " }));

        btnMotoDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/netcar/icones/yes1.png"))); // NOI18N
        btnMotoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMotoAdicionar)
                                .addGap(234, 234, 234)
                                .addComponent(btnMotoAlterar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMotEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                                .addComponent(txtMotNome)
                                .addComponent(txtMotCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMotCnh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMotData, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbmStatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(btnMotoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtMotPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtMotPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMotCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMotNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMotCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMotData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMotEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmStatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMotoAdicionar)
                    .addComponent(btnMotoAlterar)
                    .addComponent(btnMotoDeletar))
                .addGap(30, 30, 30))
        );

        setBounds(0, 0, 1002, 651);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMotoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnMotoAdicionarActionPerformed

    private void txtMotPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotPesquisarKeyReleased
        // O evento abaixa e do tipo enquanto for digitando em tempo real
        pesquisar_motorista();
    }//GEN-LAST:event_txtMotPesquisarKeyReleased

    private void btnMotoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnMotoAlterarActionPerformed

    private void txtMotPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMotPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotPesquisarActionPerformed

    private void btnMotoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoDeletarActionPerformed
       remover();
    }//GEN-LAST:event_btnMotoDeletarActionPerformed

    private void tblMotoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMotoristaMouseClicked
        // Evento que sera usado para setar os campos da table cliccando o mouse
        setar_campos();
    }//GEN-LAST:event_tblMotoristaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMotoAdicionar;
    private javax.swing.JButton btnMotoAlterar;
    private javax.swing.JButton btnMotoDeletar;
    private javax.swing.JComboBox cbmStatu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMotorista;
    private javax.swing.JFormattedTextField txtMotCnh;
    private javax.swing.JFormattedTextField txtMotCpf;
    private javax.swing.JFormattedTextField txtMotData;
    private javax.swing.JTextField txtMotEndereco;
    private javax.swing.JTextField txtMotNome;
    private javax.swing.JTextField txtMotPesquisar;
    // End of variables declaration//GEN-END:variables
}
