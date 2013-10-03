/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.postprocessing.filter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import prepos.gui.datamining.*;
import java.util.logging.Level;
import javax.crypto.spec.GCMParameterSpec;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import prepos.core.SystemInfo;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;
import weka.datagenerators.classifiers.classification.RDG1;

/**
 *
 * @author z00380tv
 */
public class GUIRulesFilter extends javax.swing.JDialog {
    
    private RulesFilter filter;
    private Postprocessing postProcessing;
    
    public GUIRulesFilter(RulesFilter filter, Postprocessing postProcessing) {
        this.filter = filter;
        this.postProcessing = postProcessing;
        initLayout();
        initComponents();
        insertPremises();
        insertConsequents();
        initResources();
    }
    
    private void initResources() {
        ButtonGroup group = new ButtonGroup();
        group.add(rbAnd);
        group.add(rbOr);

        // Default values of parameters
        tMinSupport.setText("0");
        tMaxSupport.setText("100");
        tMinConfidence.setText("0");
        tMaxConfidence.setText("100");
        rbAnd.setSelected(true);
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

        pSelectedPremises = new javax.swing.JPanel();
        bRemovePremises = new javax.swing.JButton();
        bAddPremises = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tSelectedPremises = new javax.swing.JTable();
        pParameters = new javax.swing.JPanel();
        rbOr = new javax.swing.JRadioButton();
        rbAnd = new javax.swing.JRadioButton();
        lMinConfidence = new javax.swing.JLabel();
        tMinConfidence = new javax.swing.JTextField();
        lMaxConfidence = new javax.swing.JLabel();
        tMaxConfidence = new javax.swing.JTextField();
        lMinSupport = new javax.swing.JLabel();
        tMinSupport = new javax.swing.JTextField();
        lMaxSupport = new javax.swing.JLabel();
        tMaxSupport = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pSelectedConsequents = new javax.swing.JPanel();
        bRemoveConsequents = new javax.swing.JButton();
        bAddConsequents = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tSelectedConsequents = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        bCancel = new javax.swing.JButton();
        bStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filter of Association Rules");
        setModal(true);
        setResizable(false);

        pSelectedPremises.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Premises"));

        bRemovePremises.setText("Remove All");
        bRemovePremises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemovePremisesActionPerformed(evt);
            }
        });

        bAddPremises.setText("Add All");
        bAddPremises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddPremisesActionPerformed(evt);
            }
        });

        tSelectedPremises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Label", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tSelectedPremises);
        tSelectedPremises.getColumnModel().getColumn(0).setResizable(false);
        tSelectedPremises.getColumnModel().getColumn(0).setPreferredWidth(230);
        tSelectedPremises.getColumnModel().getColumn(1).setResizable(false);
        tSelectedPremises.getColumnModel().getColumn(1).setPreferredWidth(9);

        javax.swing.GroupLayout pSelectedPremisesLayout = new javax.swing.GroupLayout(pSelectedPremises);
        pSelectedPremises.setLayout(pSelectedPremisesLayout);
        pSelectedPremisesLayout.setHorizontalGroup(
            pSelectedPremisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSelectedPremisesLayout.createSequentialGroup()
                .addGroup(pSelectedPremisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pSelectedPremisesLayout.createSequentialGroup()
                        .addComponent(bRemovePremises, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAddPremises, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pSelectedPremisesLayout.setVerticalGroup(
            pSelectedPremisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSelectedPremisesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pSelectedPremisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRemovePremises)
                    .addComponent(bAddPremises)))
        );

        pParameters.setBorder(javax.swing.BorderFactory.createTitledBorder("Parameters"));

        rbOr.setText("OR");

        rbAnd.setText("AND");

        lMinConfidence.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lMinConfidence.setText("Minimum confidence of a rule:");

        lMaxConfidence.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lMaxConfidence.setText("Maximum confidence of a rule:");

        lMinSupport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lMinSupport.setText("Minimum support of a rule:");

        lMaxSupport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lMaxSupport.setText("Maximum support of a rule:");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Condition between premise and consequent:");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout pParametersLayout = new javax.swing.GroupLayout(pParameters);
        pParameters.setLayout(pParametersLayout);
        pParametersLayout.setHorizontalGroup(
            pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pParametersLayout.createSequentialGroup()
                .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pParametersLayout.createSequentialGroup()
                        .addComponent(rbAnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbOr))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pParametersLayout.createSequentialGroup()
                        .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lMaxConfidence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lMinConfidence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tMinConfidence, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(tMaxConfidence)))
                    .addGroup(pParametersLayout.createSequentialGroup()
                        .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lMaxSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMinSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tMinSupport, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(tMaxSupport))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pParametersLayout.setVerticalGroup(
            pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pParametersLayout.createSequentialGroup()
                .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMinConfidence)
                    .addComponent(tMinConfidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMaxConfidence)
                    .addComponent(tMaxConfidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMinSupport)
                    .addComponent(tMinSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMaxSupport)
                    .addComponent(tMaxSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbOr)
                    .addComponent(rbAnd)))
        );

        pSelectedConsequents.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Consequents"));

        bRemoveConsequents.setText("Remove All");
        bRemoveConsequents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveConsequentsActionPerformed(evt);
            }
        });

        bAddConsequents.setText("Add All");
        bAddConsequents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddConsequentsActionPerformed(evt);
            }
        });

        tSelectedConsequents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Label", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tSelectedConsequents);
        tSelectedConsequents.getColumnModel().getColumn(0).setPreferredWidth(230);
        tSelectedConsequents.getColumnModel().getColumn(1).setResizable(false);
        tSelectedConsequents.getColumnModel().getColumn(1).setPreferredWidth(9);

        javax.swing.GroupLayout pSelectedConsequentsLayout = new javax.swing.GroupLayout(pSelectedConsequents);
        pSelectedConsequents.setLayout(pSelectedConsequentsLayout);
        pSelectedConsequentsLayout.setHorizontalGroup(
            pSelectedConsequentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pSelectedConsequentsLayout.createSequentialGroup()
                .addComponent(bRemoveConsequents, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAddConsequents, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pSelectedConsequentsLayout.setVerticalGroup(
            pSelectedConsequentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSelectedConsequentsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pSelectedConsequentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRemoveConsequents)
                    .addComponent(bAddConsequents)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Execution"));

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bStart.setText("Start");
        bStart.setActionCommand("Start");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bStart, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bCancel)
                .addComponent(bStart))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pSelectedPremises, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pSelectedConsequents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pSelectedPremises, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pSelectedConsequents, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(pParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertPremises() {
        ArrayList<AssociationRule> rules = filter.getRules();
        ArrayList<String> premises = new ArrayList<>();
        
        for (AssociationRule rule : rules) {
            for (AttributeValue attribute : rule.getPremises()) {
                if (!premises.contains(attribute.getAttribute())) {
                    premises.add(attribute.getAttribute());
                }
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) tSelectedPremises.getModel();
        
        Collections.sort(premises, Collator.getInstance());
        
        for (String premise : premises) {
            model.addRow(new Object[]{premise, false});
        }
    }
    
    private void insertConsequents() {
        ArrayList<AssociationRule> rules = filter.getRules();
        ArrayList<String> consequents = new ArrayList<>();
        
        for (AssociationRule rule : rules) {
            for (AttributeValue attribute : rule.getConsequents()) {
                if (!consequents.contains(attribute.getAttribute())) {
                    consequents.add(attribute.getAttribute());
                }
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) tSelectedConsequents.getModel();
        
        Collections.sort(consequents, Collator.getInstance());        
        
        for (String consequent : consequents) {
            model.addRow(new Object[]{consequent, false});
        }
    }
    
    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed
    
    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
        if (rbAnd.isSelected()) {
            filter.setAnd(true);
        } else {
            filter.setOr(true);
        }
        
        filter.setMinSupport(Float.parseFloat(tMinSupport.getText()));
        filter.setMaxSupport(Float.parseFloat(tMaxSupport.getText()));
        filter.setMinConfidence(Float.parseFloat(tMinConfidence.getText()));
        filter.setMaxConfidence(Float.parseFloat(tMaxConfidence.getText()));
        
        DefaultTableModel mPremises = (DefaultTableModel) tSelectedPremises.getModel();
        for (int i = 0; i < mPremises.getRowCount(); i++) {
            if ((boolean) mPremises.getValueAt(i, 1)) {
                filter.addSelectedPremise((String) mPremises.getValueAt(i, 0));
            }
        }
        
        DefaultTableModel mConsequents = (DefaultTableModel) tSelectedConsequents.getModel();
        for (int i = 0; i < mConsequents.getRowCount(); i++) {
            if ((boolean) mConsequents.getValueAt(i, 1)) {
                filter.addSelectedConsequent((String) mConsequents.getValueAt(i, 0));
            }
        }
        
        ArrayList<AssociationRule> rules = filter.filter();
        StringBuilder msg = new StringBuilder();
        for (AssociationRule rule : rules) {
             msg.append(rule.toString());
             msg.append("\n");
        }
        
        postProcessing.gettResult().gettResult().setText(msg.toString());
        
        this.dispose();
    }//GEN-LAST:event_bStartActionPerformed
    
    private void bRemovePremisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemovePremisesActionPerformed
        DefaultTableModel model = (DefaultTableModel) tSelectedPremises.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(false, i, 1);
        }
    }//GEN-LAST:event_bRemovePremisesActionPerformed
    
    private void bAddPremisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddPremisesActionPerformed
        DefaultTableModel model = (DefaultTableModel) tSelectedPremises.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(true, i, 1);
        }
    }//GEN-LAST:event_bAddPremisesActionPerformed
    
    private void bRemoveConsequentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveConsequentsActionPerformed
        DefaultTableModel model = (DefaultTableModel) tSelectedConsequents.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(false, i, 1);
        }
    }//GEN-LAST:event_bRemoveConsequentsActionPerformed
    
    private void bAddConsequentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddConsequentsActionPerformed
        DefaultTableModel model = (DefaultTableModel) tSelectedConsequents.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(true, i, 1);
        }
    }//GEN-LAST:event_bAddConsequentsActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddConsequents;
    private javax.swing.JButton bAddPremises;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bRemoveConsequents;
    private javax.swing.JButton bRemovePremises;
    private javax.swing.JButton bStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lMaxConfidence;
    private javax.swing.JLabel lMaxSupport;
    private javax.swing.JLabel lMinConfidence;
    private javax.swing.JLabel lMinSupport;
    private javax.swing.JPanel pParameters;
    private javax.swing.JPanel pSelectedConsequents;
    private javax.swing.JPanel pSelectedPremises;
    private javax.swing.JRadioButton rbAnd;
    private javax.swing.JRadioButton rbOr;
    private javax.swing.JTextField tMaxConfidence;
    private javax.swing.JTextField tMaxSupport;
    private javax.swing.JTextField tMinConfidence;
    private javax.swing.JTextField tMinSupport;
    private javax.swing.JTable tSelectedConsequents;
    private javax.swing.JTable tSelectedPremises;
    // End of variables declaration//GEN-END:variables
}
