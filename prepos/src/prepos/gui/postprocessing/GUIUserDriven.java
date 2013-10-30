/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.gui.postprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import prepos.core.SystemInfo;
import prepos.rules.AssociationRule;
import prepos.core.*;
import prepos.gui.datamining.Postprocessing;

/**
 *
 * @author Cristian
 */
public class GUIUserDriven extends javax.swing.JFrame {

    private ArrayList<AssociationRule> rules;
    private Postprocessing postProcessing;

    public GUIUserDriven(ArrayList<AssociationRule> rules, Postprocessing postProcessing) {
        this.rules = (ArrayList<AssociationRule>) rules.clone();
        this.postProcessing = postProcessing;
        initComponents();
        initLayout();
        initResources();
    }

    private void initResources() {
        // Initialize the table
        updateTable(this.rules);
    }

    public void updateTable(ArrayList<AssociationRule> rules) {
        // Initialize the table
        DefaultTableModel model = (DefaultTableModel) tRules.getModel();
        model.setNumRows(0);
        int i = 0;
        for (AssociationRule rule : rules) {
            ButtonInfo info = new ButtonInfo(tRules, 5, rules);
            ButtonDelete delete = new ButtonDelete(tRules, i, 6, rules, this);
            model.addRow(new Object[]{i, rule.strPremise(), rule.strConsequent(), rule.getSupport(), rule.getConfidence(), info, delete});
            i++;
        }
    }

    private void initLayout() {
        // Location
        pack();
        setLocation(100, 100);

        // Visual Windows 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName()) || "Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            SystemInfo.getLog().log(Level.WARNING, ex.getLocalizedMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tRules = new javax.swing.JTable();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tRules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Premise", "Consequent", "Support", "Confidence", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tRules.setColumnSelectionAllowed(true);
        tRules.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tRules);
        tRules.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tRules.getColumnModel().getColumn(0).setMinWidth(30);
        tRules.getColumnModel().getColumn(0).setPreferredWidth(30);
        tRules.getColumnModel().getColumn(0).setMaxWidth(30);
        tRules.getColumnModel().getColumn(3).setMinWidth(70);
        tRules.getColumnModel().getColumn(3).setPreferredWidth(70);
        tRules.getColumnModel().getColumn(3).setMaxWidth(70);
        tRules.getColumnModel().getColumn(4).setMinWidth(70);
        tRules.getColumnModel().getColumn(4).setPreferredWidth(70);
        tRules.getColumnModel().getColumn(4).setMaxWidth(70);
        tRules.getColumnModel().getColumn(5).setMinWidth(60);
        tRules.getColumnModel().getColumn(5).setPreferredWidth(60);
        tRules.getColumnModel().getColumn(5).setMaxWidth(60);
        tRules.getColumnModel().getColumn(6).setMinWidth(80);
        tRules.getColumnModel().getColumn(6).setPreferredWidth(80);
        tRules.getColumnModel().getColumn(6).setMaxWidth(80);

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(484, Short.MAX_VALUE)
                .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave)
                    .addComponent(bCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        StringBuilder msg = new StringBuilder();
        msg.append("Association Rules:\n");
        for (AssociationRule rule : this.rules) {
            msg.append(rule.toString() + "\n");
        }

        this.postProcessing.gettResult().gettResult().setText(msg.toString());
        this.dispose();
    }//GEN-LAST:event_bSaveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tRules;
    // End of variables declaration//GEN-END:variables
}
