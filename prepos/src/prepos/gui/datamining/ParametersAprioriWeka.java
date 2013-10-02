/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.gui.datamining;

import java.util.logging.Level;
import prepos.core.SystemInfo;

/**
 *
 * @author z00380tv
 */
public class ParametersAprioriWeka extends javax.swing.JDialog {

    private Miner miner;

    public ParametersAprioriWeka(Miner miner) {
        this.miner = miner;
        initLayout();
        initComponents();
        parserParameters();
    }

    private void parserParameters() {
        String parameters[] = miner.getParameters().split(" ");
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].contains("-C")) {
                tMinConfidence.setText(parameters[i+1]);
            } else if (parameters[i].contains("-M")) {
                tMinSupport.setText(parameters[i+1]);
            } else if (parameters[i].contains("-U")) {
                tMaxSupport.setText(parameters[i+1]);
            } else if (parameters[i].contains("-N")) {
                tNumRules.setText(parameters[i+1]);
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
        lNumRules = new javax.swing.JLabel();
        tNumRules = new javax.swing.JTextField();
        bCancel = new javax.swing.JButton();
        bSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parameters - Apriori (WEKA)");
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

        lNumRules.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNumRules.setText("Number of Rules to Find");
        lNumRules.setToolTipText("");

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
                            .addComponent(lNumRules, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMaxSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tNumRules, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(tMaxSupport))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lMinConfidence, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tMinConfidence))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(lNumRules)
                    .addComponent(tNumRules, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String parameters = "";
        if (!tMinSupport.getText().equals("")) {
            parameters += "-M " + tMinSupport.getText() + " ";
        }
        if (!tMaxSupport.getText().equals("")) {
            parameters += "-U " + tMaxSupport.getText() + " ";
        }
        if (!tMinConfidence.getText().equals("")) {
            parameters += "-C " + tMinConfidence.getText() + " ";
        }
        if (!tNumRules.getText().equals("")) {
            parameters += "-N " + tNumRules.getText() + " ";
        }
        parameters = parameters.trim();
        miner.setParameters(parameters);
        this.dispose();
    }//GEN-LAST:event_bSaveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bSave;
    private javax.swing.JLabel lMaxSupport;
    private javax.swing.JLabel lMinConfidence;
    private javax.swing.JLabel lMinSupport;
    private javax.swing.JLabel lNumRules;
    private javax.swing.JTextField tMaxSupport;
    private javax.swing.JTextField tMinConfidence;
    private javax.swing.JTextField tMinSupport;
    private javax.swing.JTextField tNumRules;
    // End of variables declaration//GEN-END:variables
}
