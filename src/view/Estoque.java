/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import model.dao.EstoqueDAO;
/**
 *
 * @author Lari
 */
public class Estoque extends javax.swing.JInternalFrame {

    /**
     * Creates new form Estoque
     */
    public Estoque() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopEstoque = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEstoque = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        btnCadastrarItem = new javax.swing.JButton();
        btnExcluirItem = new javax.swing.JButton();

        desktopEstoque.setBorder(javax.swing.BorderFactory.createTitledBorder("ESTOQUE"));

        tabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Item", "Quantidade"
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
        jScrollPane2.setViewportView(tabelaEstoque);

        jLabel1.setText("Item");

        jLabel2.setText("Quantidade");

        btnCadastrarItem.setText("Cadastrar");
        btnCadastrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarItemActionPerformed(evt);
            }
        });

        btnExcluirItem.setText("Excluir");

        desktopEstoque.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopEstoque.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopEstoque.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopEstoque.setLayer(txtItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopEstoque.setLayer(txtQuantidade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopEstoque.setLayer(btnCadastrarItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopEstoque.setLayer(btnExcluirItem, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopEstoqueLayout = new javax.swing.GroupLayout(desktopEstoque);
        desktopEstoque.setLayout(desktopEstoqueLayout);
        desktopEstoqueLayout.setHorizontalGroup(
            desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopEstoqueLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(desktopEstoqueLayout.createSequentialGroup()
                .addGroup(desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopEstoqueLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtItem)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopEstoqueLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCadastrarItem)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirItem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        desktopEstoqueLayout.setVerticalGroup(
            desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopEstoqueLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(desktopEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarItem)
                    .addComponent(btnExcluirItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopEstoque)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopEstoque)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarItemActionPerformed
        Estoque e = new Estoque();
        e.setItem(txtItem.getText());
        e.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        
        EstoqueDAO dao = new EstoqueDAO();
        dao.adiciona(e);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }//GEN-LAST:event_btnCadastrarItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarItem;
    private javax.swing.JButton btnExcluirItem;
    private javax.swing.JDesktopPane desktopEstoque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaEstoque;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
