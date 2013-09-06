/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.gui.datamining;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import prepos.core.Shared;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import prepos.core.FileSaver;
import prepos.preprocessing.AprioriPreparator;

/**
 *
 * @author Cristian
 */
public class Preprocessing extends javax.swing.JPanel {

    private JTree tAlgorithms;

    public Preprocessing() {
        initComponents();
        initResources();
        createTree();
    }
    
    private void initResources() {
        bSaveResult.setEnabled(false);
    }

    private void createTree() {
        // Root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("prepos");

        // Algorithms
        DefaultMutableTreeNode prepareDatabaseApriori = new DefaultMutableTreeNode("Prepare Database to Apriori");
        DefaultMutableTreeNode desnormalizingDatabase = new DefaultMutableTreeNode("Desnormalizing Database");
        
        // Add on tree
        root.add(prepareDatabaseApriori);
        root.add(desnormalizingDatabase);

        tAlgorithms = new JTree(root);
        pAlgorithms.setViewportView(tAlgorithms);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chSaveResult = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tOutput = new javax.swing.JTextArea();
        bSaveResult = new javax.swing.JButton();
        bStart = new javax.swing.JButton();
        pAlgorithms = new javax.swing.JScrollPane();

        chSaveResult.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setMaximumSize(new java.awt.Dimension(800, 516));
        setMinimumSize(new java.awt.Dimension(800, 516));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 516));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Result"));

        tOutput.setEditable(false);
        tOutput.setColumns(20);
        tOutput.setRows(5);
        jScrollPane1.setViewportView(tOutput);

        bSaveResult.setText("Save Result");
        bSaveResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bSaveResult, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSaveResult))
        );

        bStart.setText("Start");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        pAlgorithms.setBorder(javax.swing.BorderFactory.createTitledBorder("Algorithms"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pAlgorithms)
                    .addComponent(bStart, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pAlgorithms)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStart))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        if (tAlgorithms.getSelectionPath().toString().contains("Prepare Database to Apriori")) {
            AprioriPreparator apriori = new AprioriPreparator(Shared.getInstance().getDatabase());
            tOutput.setText(apriori.prepareDatabase());
            bSaveResult.setEnabled(true);
            
            Shared.getInstance().changeStatus("Database prepared.");
        }

    }//GEN-LAST:event_bStartActionPerformed

    private void bSaveResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveResultActionPerformed
        int option = chSaveResult.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            FileSaver fileSaver = new FileSaver(chSaveResult.getSelectedFile().getName(), chSaveResult.getSelectedFile().getPath(), tOutput.getText());
            try {
                fileSaver.save();
            } catch (IOException ex) {
                Logger.getLogger(Miner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bSaveResultActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSaveResult;
    private javax.swing.JButton bStart;
    private javax.swing.JFileChooser chSaveResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane pAlgorithms;
    private javax.swing.JTextArea tOutput;
    // End of variables declaration//GEN-END:variables
}
