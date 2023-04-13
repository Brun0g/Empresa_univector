/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Estoques;
import model.dao.EstoqueDAO;

/**
 *
 * @author Lari
 */
public class Estoque extends javax.swing.JInternalFrame {

    /**
     * Creates new form Estoques
     */
    public Estoque() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tabelaEstoque.getModel();
        tabelaEstoque.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }
    
    public  void readJTable(){
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaEstoque.getModel();
        modelo.setNumRows(0);
        EstoqueDAO edao = new EstoqueDAO();

        for (Estoques e: edao.read()) {

            modelo.addRow(new Object[]{
                e.getId_item(),
                e.getItem(),
                e.getQuantidade(),
            });
    }
        
}
    
    public void readJTableForDesc(String desc) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabelaEstoque.getModel();
        modelo.setNumRows(0);
        EstoqueDAO edao = new EstoqueDAO();

        for (Estoques e : edao.readForDesc(desc)) {

            modelo.addRow(new Object[]{
                e.getId_item(),
                e.getItem(),
                e.getQuantidade(),
            });

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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarItem = new javax.swing.JTextField();
        btnBuscarItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEstoque = new javax.swing.JTable();
        btnCadastrarItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JFormattedTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Item");

        jLabel2.setText("Quantidade");

        btnBuscarItem.setText("Buscar");
        btnBuscarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarItemActionPerformed(evt);
            }
        });

        tabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id_item", "Item", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEstoqueMouseClicked(evt);
            }
        });
        tabelaEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaEstoqueKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaEstoque);

        btnCadastrarItem.setText("Cadastrar");
        btnCadastrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarItemActionPerformed(evt);
            }
        });

        btnExcluirItem.setText("Excluir");
        btnExcluirItem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnExcluirItemStateChanged(evt);
            }
        });
        btnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirItemActionPerformed(evt);
            }
        });

        try {
            txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(txtBuscarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnBuscarItem))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrarItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItem))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidade))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(txtItem)))))
                .addGap(84, 84, 84))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarItem)
                    .addComponent(btnExcluirItem))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarItem))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarItemActionPerformed
        Estoques e = new Estoques();
        EstoqueDAO dao = new EstoqueDAO();
        e.setItem(txtItem.getText());
        e.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        dao.create(e);
        DefaultTableModel dtmClientes = (DefaultTableModel) tabelaEstoque.getModel();
        Object[] dados = {txtItem.getText(), txtQuantidade.getText()};
        dtmClientes.addRow(dados);
        readJTableForDesc(txtBuscarItem.getText());
    }//GEN-LAST:event_btnCadastrarItemActionPerformed

    private void tabelaEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEstoqueMouseClicked
         if (tabelaEstoque.getSelectedRow() != -1) {

            txtItem.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 1).toString());
            txtQuantidade.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_tabelaEstoqueMouseClicked

    private void tabelaEstoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaEstoqueKeyReleased
      
        if (tabelaEstoque.getSelectedRow() != -1) {

            txtItem.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 1).toString());
            txtQuantidade.setText(tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_tabelaEstoqueKeyReleased

    private void btnExcluirItemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnExcluirItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirItemStateChanged

    private void btnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirItemActionPerformed
        if (tabelaEstoque.getSelectedRow() !=-1) {

            Estoques e = new Estoques();
            EstoqueDAO dao = new EstoqueDAO();

            e.setId_item((int) tabelaEstoque.getValueAt(tabelaEstoque.getSelectedRow(), 0));

            dao.delete(e);

            txtItem.setText("");
            txtQuantidade.setText("");
            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item para excluir.");
        }
    }//GEN-LAST:event_btnExcluirItemActionPerformed

    private void btnBuscarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarItemActionPerformed
        readJTableForDesc(txtBuscarItem.getText());
    }//GEN-LAST:event_btnBuscarItemActionPerformed

    
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
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarItem;
    private javax.swing.JButton btnCadastrarItem;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaEstoque;
    private javax.swing.JTextField txtBuscarItem;
    private javax.swing.JTextField txtItem;
    private javax.swing.JFormattedTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
