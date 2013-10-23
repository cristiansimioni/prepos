/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.gui.parameters;

import java.util.logging.Level;
import prepos.core.SystemInfo;
import prepos.gui.datamining.Miner;

/**
 *
 * @author z00380tv
 */
public class GUIParametersAprioriBorgelt extends javax.swing.JDialog {

    private Miner miner;

    public GUIParametersAprioriBorgelt(Miner miner) {
        this.miner = miner;
        initLayout();
        initComponents();
        parserParameters();
    }

    private void parserParameters() {
        String parameters[] = miner.getParameters().split(" ");
        for (String parameter : parameters) {
            if (parameter.contains("-c")) {
                tMinConfidence.setText(parameter.split("c")[1]);
            } else if (parameter.contains("-s")) {
                tMinSupport.setText(parameter.split("s")[1]);
            } else if (parameter.contains("-S")) {
                tMaxSupport.setText(parameter.split("S")[1]);
            } else if (parameter.contains("-m")) {
                tMinItem.setText(parameter.split("m")[1]);
            } else if (parameter.contains("-n")) {
                tMaxItem.setText(parameter.split("n")[1]);
            }
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

        lMinConfidence = new javax.swing.JLabel();
        tMinConfidence = new javax.swing.JTextField();
        lMinSupport = new javax.swing.JLabel();
        tMinSupport = new javax.swing.JTextField();
        lMaxSupport = new javax.swing.JLabel();
        tMaxSupport = new javax.swing.JTextField();
        lMinItems = new javax.swing.JLabel();
        tMinItem = new javax.swing.JTextField();
        lMaxItems = new javax.swing.JLabel();
        tMaxItem = new javax.swing.JTextField();
        bCancel = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        lUnstructured = new javax.swing.JLabel();
        bUnstructured = new javax.swing.JButton();
        tUnstructured = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parameters - Apriori (Borgelt)");
        setModal(true);
        setResizable(false);

        lMinConfidence.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMinConfidence.setText("Minimum confidence of a rule:");

        lMinSupport.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMinSupport.setText("Minimum support of a rule:");
        lMinSupport.setToolTipText("");

        lMaxSupport.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMaxSupport.setText("Maximum support of a rule:");
        lMaxSupport.setToolTipText("");

        lMinItems.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMinItems.setText("Minimum number of items per rule:");
        lMinItems.setToolTipText("");

        lMaxItems.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lMaxItems.setText("Maximum number of items per rule:");
        lMaxItems.setToolTipText("");

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        lUnstructured.setText("Unstructured database:");

        bUnstructured.setText("Choose unstructured database");

        tUnstructured.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lMinSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tMinSupport, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lMinItems, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMaxSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMaxItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tMaxItem, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(tMinItem)
                            .addComponent(tMaxSupport)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lMinConfidence, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tMinConfidence))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bUnstructured, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lUnstructured, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tUnstructured)
                                    .addComponent(bSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMinConfidence)
                    .addComponent(tMinConfidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMinSupport)
                    .addComponent(tMinSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMaxSupport)
                    .addComponent(tMaxSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMinItems)
                    .addComponent(tMinItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tMaxItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lMaxItems))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bUnstructured)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUnstructured)
                    .addComponent(tUnstructured, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave)
                    .addComponent(bCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        String parameters = "-tr ";
        if (!tMinSupport.getText().equals("")) {
            parameters += "-s" + tMinSupport.getText() + " ";
        }
        if (!tMaxSupport.getText().equals("")) {
            parameters += "-S" + tMaxSupport.getText() + " ";
        }
        if (!tMinConfidence.getText().equals("")) {
            parameters += "-c" + tMinConfidence.getText() + " ";
        }
        if (!tMinItem.getText().equals("")) {
            parameters += "-m" + tMinItem.getText() + " ";
        }
        if (!tMaxItem.getText().equals("")) {
            parameters += "-n" + tMaxItem.getText() + " ";
        }
        parameters = parameters.trim();
        miner.setParameters(parameters);
        this.dispose();
    }//GEN-LAST:event_bSaveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bUnstructured;
    private javax.swing.JLabel lMaxItems;
    private javax.swing.JLabel lMaxSupport;
    private javax.swing.JLabel lMinConfidence;
    private javax.swing.JLabel lMinItems;
    private javax.swing.JLabel lMinSupport;
    private javax.swing.JLabel lUnstructured;
    private javax.swing.JTextField tMaxItem;
    private javax.swing.JTextField tMaxSupport;
    private javax.swing.JTextField tMinConfidence;
    private javax.swing.JTextField tMinItem;
    private javax.swing.JTextField tMinSupport;
    private javax.swing.JTextField tUnstructured;
    // End of variables declaration//GEN-END:variables
}
